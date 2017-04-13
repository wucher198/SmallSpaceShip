package pl.myjava.smallspaceship;

import pl.myjava.smallspaceship.base.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by anonim on 13.04.17.
 */
public class SnowEntity implements Entity {
    private Shape shape;

    private MoveStrategy moveStrategy;
    private DrawStrategy drawStrategy;

    public SnowEntity(int x, int y) {
        shape = new Ellipse2D.Double(x, y, 30, 30);
        moveStrategy = new SimpleMoveStrategy(shape);
        drawStrategy = new SimpleShapeDrawStrategy(Color.BLACK, shape);
    }

    @Override
    public void move() {
        moveStrategy.move();
    }

    @Override
    public void draw(Graphics2D g2) {
        drawStrategy.draw(g2);
    }
}
