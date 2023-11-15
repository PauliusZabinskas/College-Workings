import java.awt.Image;

public class PlayerBullet extends Sprite2D{
    private double ySpeed=0;
    public PlayerBullet(Image i) {
        super(i,i); // invoke constructor on superclass Sprite2D
    }
    //attaches the bullet image to the bullet entity
    public void setYSpeed(double yy){
        ySpeed=yy;
    }
    public void move() {
            y-=ySpeed;
    }
}
