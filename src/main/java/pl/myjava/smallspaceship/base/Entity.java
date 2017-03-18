package pl.myjava.smallspaceship.base;

/**
 * Created by anonim on 14.03.17.
 */
public interface Entity {
    MoveStrategy getMoveStrategy();
    DrawStrategy getDrawStrategy();
}
