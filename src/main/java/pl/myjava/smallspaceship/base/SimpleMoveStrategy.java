package pl.myjava.smallspaceship.base;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by anonim on 14.03.17.
 */
public class SimpleMoveStrategy extends AbstractMoveStrategy {
    private Shape shape;

    public SimpleMoveStrategy(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void move() {
        int random = (int) (Math.random() * 2);
        double x = this.shape.getBounds().getX();
        double y = this.shape.getBounds().getY();
        double width = this.shape.getBounds().getWidth();
        double height = this.shape.getBounds().getHeight();

        switch (random) {
            case 0:
                this.shape = new Ellipse2D.Double(x + 3, y + 3, width, height);
                break;
            case 1:
            default:
                this.shape = new Rectangle2D.Double(x + 3, y + 3, width, height);
                break;
        }
    }
}
