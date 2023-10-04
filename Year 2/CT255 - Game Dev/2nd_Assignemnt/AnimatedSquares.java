

import java.awt.*;
import javax.swing.*;

public class AnimatedSquares extends JFrame implements Runnable {
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int NUM_GAME_OBJECTS = 30;
    private GameObject[] GameObjectsArray = new GameObject[NUM_GAME_OBJECTS];

    public AnimatedSquares() {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - WindowSize.width / 2;
        int y = screenSize.height / 2 - WindowSize.height / 2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        // declare thread and start it
        Thread t = new Thread(this);
        t.start();

        for (int i = 0; i < NUM_GAME_OBJECTS; i++) {
            GameObjectsArray[i] = new GameObject();
        }
    }

    // thread interface
    public void run() {
        while (true) {

            for (GameObject array : GameObjectsArray) {
                array.move();
                this.repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // repaint the canvas
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);
        for (GameObject array : GameObjectsArray) {
            array.paint(g);
        }
    }

    public static void main(String[] args) {
        AnimatedSquares squares = new AnimatedSquares();
    }
}
