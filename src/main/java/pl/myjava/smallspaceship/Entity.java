package pl.myjava.smallspaceship;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.logging.Logger;

public class Entity {
    private static final Logger LOGGER = Logger.getLogger(Entity.class.getName());

    private Point2D.Double topLeft = new Point2D.Double(40, 40);
    private int dx = 0;
    private int dy = 0;
    private Image image;

    public void initDefaultEntity() {

        image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2bi = (Graphics2D) image.getGraphics();
        g2bi.setColor(Color.CYAN);
        int x[] = {0, 8, 15, 0};
        int y[] = {15, 0, 15, 15};
        g2bi.draw(new Polygon(x, y, 4));
        g2bi.dispose();
    }

    final public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, (int) topLeft.getX(), (int) topLeft.getY(), null);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    final public void setTopLeft(Point2D.Double topLeft) {
        if (topLeft != null) {
            this.topLeft = topLeft;
        }
    }

    final public void setImage(Image image) {
        if (image != null) {
            this.image = image;
        } else {
            LOGGER.fine("No IMAGE provided");
        }
    }

    public void move(double maxX, double minX, double maxY, double minY) {
        double xOut = topLeft.getX() + dx;
        double yOut = topLeft.getY() + dy;

        if (xOut > (maxX + image.getWidth(null))) {
            xOut = minX - image.getWidth(null);
        } else if (xOut < (minX - image.getWidth(null))) {
            xOut = maxX + image.getWidth(null);
        }

        if (yOut > (maxY + image.getHeight(null))) {
            yOut = minY - image.getHeight(null);
        } else if (yOut < (minY - image.getHeight(null))) {
            yOut = maxY + image.getHeight(null);
        }

        topLeft.setLocation(xOut, yOut);
    }

    protected void keyPressed(KeyEvent keyEvent) {
        parseKey(keyEvent);
    }

    protected void keyReleased(KeyEvent keyEvent) {
        parseKey(keyEvent);
    }

    private void parseKey(KeyEvent keyEvent) {
        switch (getKeyCode(keyEvent)) {
            case KeyEvent.VK_UP:
                dy--;
                break;
            case KeyEvent.VK_DOWN:
                dy++;
                break;
            case KeyEvent.VK_LEFT:
                dx--;
                break;
            case KeyEvent.VK_RIGHT:
                dx++;
                break;
            default:
                System.out.println("Key not supported: " + keyEvent.getKeyChar());
        }
    }

    protected int getKeyCode(KeyEvent keyEvent) {
        return keyEvent.getKeyCode();
    }
}