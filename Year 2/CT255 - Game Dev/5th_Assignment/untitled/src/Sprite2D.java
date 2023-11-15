import java.awt.*;
public class Sprite2D {
    int framesDrawn = 0;
    // member data
    protected double x,y;
    protected Image myImage;
    protected Image myImage2;
    // static member data
    protected static int winWidth;
    boolean alive = true;
    //alive is used to determine if an alien is considered dead or not
    // constructor
    public Sprite2D(Image i, Image i2) {
        myImage = i;
        myImage2 = i2;
    }
    public void setPosition(double xx, double yy) {
        x=xx;
        y=yy;
    }

    public void paint(Graphics g) {
        framesDrawn++;
        if(alive) {
            if (framesDrawn % 100 < 50)
                g.drawImage(myImage, (int) x, (int) y, null);
            else
                g.drawImage(myImage2, (int) x, (int) y, null);
        }
    }
    public static void setWinWidth(int w) {
        winWidth = w;
    }

    //Dead() is used when an alien is hit by a bullet, it sets the alien to dead and moves them off the screen
    public void Dead(){
        alive=false;
        setPosition(1000,1000);
        //once the alien is "killed" their hitbox remains acting as an invisible wall for the player
        //to stop this their position is moved off the screen
    }

    //this undoes the Dead() function above and allows the wave system to respawn waves
    public void reSpawn(){
        alive=true;
    }
}