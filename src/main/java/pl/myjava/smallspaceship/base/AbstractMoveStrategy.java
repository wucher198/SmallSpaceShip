package pl.myjava.smallspaceship.base;

import java.awt.geom.Point2D;

/**
 * Created by anonim on 14.03.17.
 */
public abstract class AbstractMoveStrategy implements MoveStrategy {
    private Double xSpeed = null;
    private Double ySpeed = null;
    private Point2D.Double position = null;

    @Override
    public void setNewXSpeed(Double newXSpeed) {
        this.xSpeed = newXSpeed;
    }

    @Override
    public void setNewYSpeed(Double newYSpeed) {
        this.ySpeed = newYSpeed;
    }

    @Override
    public Point2D.Double getPosition() {
        return position;
    }
}
