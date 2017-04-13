package pl.myjava.smallspaceship;

import pl.myjava.smallspaceship.base.AbstractPaintComponent;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anonim on 02.02.17.
 */
public class SnowPaintComponent extends AbstractPaintComponent {
    private List<SnowEntity> entitys = new ArrayList<>();

    public SnowPaintComponent(List<SnowEntity> entitys) {
        this.entitys = entitys;
    }

    @Override
    public void moveEntitis() {
        entitys.forEach(entity -> entity.move());
    }

    @Override
    public void drawEntitis(Graphics2D g2) {
        entitys.forEach(entity -> entity.draw(g2));
    }
}
