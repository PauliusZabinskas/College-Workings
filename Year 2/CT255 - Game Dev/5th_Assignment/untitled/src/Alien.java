import java.awt.Image;
public class Alien extends Sprite2D {

    private static double xSpeed = 0;

    public Alien(Image i, Image i2) {

        super(i, i2);// invoke constructor on superclass Sprite2D
    }

// public interface

    public boolean move() {

        x += xSpeed;

        boolean bool = false;

        while (alive) {
// direction reversal needed?

            if (x <= 0 || x >= winWidth - myImage.getWidth(null))
                return true;

            else
                return false;
        }
        return bool;
    }

    public static void setFleetXSpeed(double dx) {

        xSpeed = dx;
    }

    public static void reverseDirection() {

        xSpeed = -xSpeed;
    }

    public void jumpDownwards() {

        y += 20;
    }
}