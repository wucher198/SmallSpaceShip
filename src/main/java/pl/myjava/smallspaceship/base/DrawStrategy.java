package pl.myjava.smallspaceship.base;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by anonim on 14.03.17.
 */
interface DrawStrategy {
    /**
     * Set shape that will be draw on new
     * @param shape
     */
    void setShape(Shape shape);
    Shape getShape();
    void setPosition(Point2D.Double position);
    Point2D.Double getPosition();
    void draw(Graphics2D g2);
}
