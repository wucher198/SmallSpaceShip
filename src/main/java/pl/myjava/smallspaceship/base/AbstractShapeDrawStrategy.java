package pl.myjava.smallspaceship.base;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by anonim on 02.02.17.
 */
public abstract class AbstractShapeDrawStrategy implements DrawStrategy {
    private Shape shape = null;
    private Point2D.Double position = null;

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    @Override
    public Point2D.Double getPosition() {
        return this.position;
    }
}
