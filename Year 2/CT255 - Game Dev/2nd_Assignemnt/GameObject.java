import java.awt.*;

public class GameObject {
    // object data
    private int x, y;
    private Color c;

    int pos = 0;
    // coloring square and call move method
    public GameObject() {
        int c1 = (int) (Math.random() * 256);
        int c2 = (int) (Math.random() * 256);
        int c3 = (int) (Math.random() * 256);
        c = new Color(c1, c2, c3);
        move();
    }
    // move
    public void move() {
        if (pos == 0) {
            // set location of the square randomly 
            x += (int) (Math.random() * 500);
            y += (int) (Math.random() * 500);
            pos++;
        } else {
            // move the square x pixels(repaint it x, y pixels away from previous location)
            x += (int) (Math.random() * 5) - 2;
            y += (int) (Math.random() * 5) - 2;
        }
    }
    // paint the square
    public void paint(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, 60, 60);
    }
}
