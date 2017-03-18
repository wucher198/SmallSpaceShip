package pl.myjava.smallspaceship.base;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by anonim on 14.03.17.
 */
public class SimpleShapePaintStrategy extends AbstractShapeDrawStrategy {
    private Color paintColor = null;

    public SimpleShapePaintStrategy(Color paintColor, Shape shape) {
        this.paintColor = paintColor;
        setShape(shape);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setPaint(paintColor);
        g2.draw(getShape());
    }
}
