package pl.myjava.smallspaceship;

import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainGameClass {
    public static String SHIP = "Ship";
    public static Map<String, Entity> entitys = new HashMap<>();

    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.initDefaultEntity();
        entitys.put(SHIP, entity);

        MainWindow frame = new MainWindow();
        StatusPanel statusPanel = new StatusPanel(entitys.get(SHIP));
        SpacePanel spacePanel = new SpacePanel(statusPanel);
        spacePanel.initPanel();
        frame.setLayout(new BorderLayout());
        frame.add(spacePanel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.PAGE_END);
        frame.setSize(640, 480);
        frame.setTitle("Space Ship");
        frame.initUI();
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 25));
        entity.setTopLeft(frame.getWidth() / 2d, frame.getHeight() / 2d );
        MainWindow.show(frame);
    }
}
