package pl.myjava.smallspaceship;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends BasicPanel {
    private static final String SPEED = "S: ";
    private static final String X_POS = "X: ";
    private static final String Y_POS = "Y: ";
    private static final String DIRECTION = "D: ";

    private Entity entity;
    private JLabel speed = new JLabel(SPEED);
    private JLabel xPos = new JLabel(X_POS);
    private JLabel yPos = new JLabel(Y_POS);
    private JLabel direction = new JLabel(DIRECTION);

    public StatusPanel(Entity entity) {
        this.entity = entity;
        setLayout(new FlowLayout());
        add(xPos);
        add(yPos);
        add(speed);
        add(direction);
    }

    @Override
    protected void doDrawing(Graphics g) {
        updateLabels();
    }

    private void updateLabels() {
        speed.setText(SPEED + entity.getSpeed());
        xPos.setText(X_POS + entity.getTopLeft().getX());
        yPos.setText(Y_POS + entity.getTopLeft().getY());
        direction.setText(DIRECTION + entity.getDirction());
    }
}
