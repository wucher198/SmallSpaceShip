package pl.myjava.smallspaceship.base;

import java.awt.geom.Point2D;

/**
 * Created by anonim on 14.03.17.
 */
interface MoveStrategy {
    /**
     * Set new X speed.
     * @param newXSpeed
     */
    void setNewXSpeed(Double newXSpeed);

    /**
     * Set new Y speed.
     * @param newYSpeed
     */
    void setNewYSpeed(Double newYSpeed);

    /**
     * Returns current position.
     * It should be changed after invocation of move() method.
     */
    Point2D.Double getPosition();

    /**
     * Should calculate new positon for next move.
     */
    void move();
}
