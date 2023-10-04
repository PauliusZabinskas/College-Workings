import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Iterator;
public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    private static String workingDirectory;
    private static boolean isInitialised = false;
    private static final Dimension WindowSize = new Dimension(800,600);
    private BufferStrategy strategy;
    private Graphics offscreenGraphics;
    private static final int NUMALIENS = 30;
    private int score,highScore = 0;
    private int GameState=0;
    private int waveSpeed = 2;

    ArrayList<PlayerBullet> bulletsList = new ArrayList<PlayerBullet>();
    private Alien[] AliensArray = new Alien[NUMALIENS];
    private Spaceship PlayerShip;
    public InvadersApplication() {

        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height); // display window on the center
        this.setTitle("Space Invaders");
        setVisible(true);

        // get images
        ImageIcon icon = new ImageIcon(workingDirectory +"\\src"+ "\\alien_ship_1.png");
        ImageIcon icon2 = new ImageIcon(workingDirectory +"\\src"+ "\\alien_ship_2.png");
        Image alienImage = icon.getImage();
        Image alienImage2 = icon2.getImage();

        // create NUMALIENS and store them in alien array
        for (int i=0; i<NUMALIENS; i++) {
            AliensArray[i] = new Alien(alienImage, alienImage2);

            double xx = (i%5)*80 + 70;
            double yy = (i/5)*40 + 50;

            // alien position on 2D canvas
            // while iterating
            AliensArray[i].setPosition(xx, yy);
        }
        Alien.setFleetXSpeed(waveSpeed); // increase the alien speed by wave Speed (2)

        // 
        icon = new ImageIcon(workingDirectory +"\\src"+ "\\player_ship.png");
        Image shipImage = icon.getImage();
        PlayerShip = new Spaceship(shipImage);
        PlayerShip.setPosition(400,500);

        // tell all sprites the window width
        Sprite2D.setWinWidth(WindowSize.width);
        
        Thread t = new Thread(this);
        t.start();
// send keyboard events arriving into this JFrame back to its own event handlers
        addKeyListener(this);
        
// initialise double-buffering
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offscreenGraphics = strategy.getDrawGraphics();
        isInitialised = true;
    }


    public static void main(String[] args) {
        workingDirectory = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDirectory);
        InvadersApplication w = new InvadersApplication();
    }
    
    public void paint(Graphics g) {
        if (!isInitialised)
            return;

        g = offscreenGraphics;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);


        if(GameState==0) {// check the state of the game
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 60));

            g.drawString("New Game",250,250);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));

            g.drawString("Press any key to start.",290,300);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 15));

            g.drawString("[Arrows to move & space to shoot]",270,330);
        }

        else {
            for (int i = 0; i < NUMALIENS; i++) {
                AliensArray[i].paint(g);
                PlayerShip.paint(g);
            }
            // start game display
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.drawString("High Score: "+highScore,30,60);
            g.drawString("Score: "+score,30,80);
            g.drawString("Space key to shoot",30, 500 );

            Iterator iterator = bulletsList.iterator();
            while (iterator.hasNext()){
                // are bullets iteration continuing
                // if yes, then keep iterating
                PlayerBullet bullet = (PlayerBullet) iterator.next();
                if (bulletCollision()) {iterator.remove();}
                bullet.move();
                bullet.paint(g);
            }
        }
        // buffer from of screen to on screen
        strategy.show();
    }
    
    public void run() {
        while ( true ) {
            try {
                Thread.sleep((1000/76)); // 1/76 sec
            }

            catch (InterruptedException e) {

            }

            // alien movement control
            boolean alienDirectionChange = false;

            for (int i = 0; i < NUMALIENS; i++) {

                if (AliensArray[i].move()){
                    alienDirectionChange = true;
                }
            }

            if (alienDirectionChange) {
                Alien.reverseDirection();
                for (int i = 0; i < NUMALIENS; i++) {
                    AliensArray[i].jumpDownwards();
                }
            }
            PlayerShip.move();

            // in thread check if collision alien vs ship happens
            this.shipCollision();

            this.repaint();
            // game restart control
            if(shipCollision()) {
                GameState=0;
                startnewGame();

            }
        }
    }
    //interface
    public void keyPressed(KeyEvent e) {
        GameState += 1;
        // pressed key handling switches
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                PlayerShip.setXSpeed(-4);
                break;
            case KeyEvent.VK_RIGHT:
                PlayerShip.setXSpeed(4);
                break;
            case KeyEvent.VK_SPACE:
                shootBullet(); // calling method.
                break;
        }
    }
    //interface
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT)
        PlayerShip.setXSpeed(0);
    }
    //interface
    public void keyTyped(KeyEvent e) {}
    public void shootBullet() {
        //add a new bullet object to list
        ImageIcon icon = new ImageIcon(workingDirectory +"\\src"+ "\\bullet.png");
        Image bulletImage = icon.getImage();
        PlayerBullet bullet = new PlayerBullet(bulletImage);//WindowSize.width);
        bullet.setPosition(PlayerShip.x+54/2, PlayerShip.y);
        bulletsList.add(bullet);
        bullet.setYSpeed(25);
        bulletCollision(); // look for collisions
    }
    
    public boolean shipCollision() {
        boolean bool = false;
        for (int x = 0; x < NUMALIENS; x++) {

            double x1 = AliensArray[x].x;
            double y1 = AliensArray[x].y;
            double widthAlien = 50;
            double heightAlien = 30;
            double x2 = PlayerShip.x;
            double y2 = PlayerShip.y;
            double widthShip = 54;
            double heightShip = 32;
            if (((x1 < x2 && x1 + widthAlien > x2) || (x2 < x1 && x2 + widthShip > x1)) &&
                    ((y1 < y2 && y1 + heightAlien > y2) || (y2 < y1 && y2 + heightShip > y1))) {
                return true;
            }
        }
        return bool;
    }
    public boolean bulletCollision() {
        boolean bool = false;
        // needs nested loop 
        for (int x = 0; x < NUMALIENS; x++) {
            for (int xx = 0; xx < bulletsList.size(); xx++) {
                double x1 = AliensArray[x].x;
                double y1 = AliensArray[x].y;
                double widthAlien = 50;
                double heightAlien = 30;
                double x2 = bulletsList.get(xx).x;
                double y2 = bulletsList.get(xx).y;
                double widthBullet = 5;
                double heightBullet = 16;

                if (((x1 < x2 && x1 + widthAlien > x2) || (x2 < x1 && x2 + widthBullet > x1)) &&
                        ((y1 < y2 && y1 + heightAlien > y2) || (y2 < y1 && y2 + heightBullet > y1))) {
                    score ++;
                    AliensArray[x].Dead();// if collision happens, send alien to grave
                    if (score%30==0 && score>0){this.waveSpeeds();} // check if all aliens are killed

                    return true;
                }
            }
        }
        return bool;
    }
    
    private void startnewGame() {
        // new game settings
        waveSpeed=2;

        if(score>highScore) {highScore = score;}
        score=0;
        // call alien objects again
        Alien.setFleetXSpeed(waveSpeed);
        for(int i=0; i<NUMALIENS; i++)
        {
            AliensArray[i].reSpawn();
            double xx = (i%5)*80 + 70;
            double yy = (i/5)*40 + 50;
            AliensArray[i].setPosition(xx, yy);
        }
    }
    
    private void waveSpeeds() {
        Alien.setFleetXSpeed(waveSpeed);
        waveSpeed +=4;
        // respawn aliens to origin location
        for(int i=0; i<NUMALIENS; i++) {
            AliensArray[i].reSpawn();
            double xx = (i%5)*80 + 70;
            double yy = (i/5)*40 + 50;
            AliensArray[i].setPosition(xx, yy);
        }
    }

}