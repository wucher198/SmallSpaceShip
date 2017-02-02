package pl.myjava.smallspaceship.base;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by anonim on 02.02.17.
 */
public abstract class AbstractEntity {
    private Shape shape;
    private Point2D.Double position;
    private int xSpeed;
    private int ySpeed;

    protected void setShape(Shape shape) {
        this.shape = shape;
    }

    public void draw(Graphics2D g2) {
        g2.draw(shape);
    }

    abstract protected void changeXSpeed(int xSpeed);
    abstract protected void changeYSpeed(int ySpeed);

    protected void move() {
        
    }
}
