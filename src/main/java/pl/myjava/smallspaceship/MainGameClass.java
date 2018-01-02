package pl.myjava.smallspaceship;

import java.util.HashMap;
import java.util.Map;

public class MainGameClass {
    public static Map<String, Entity> entitys = new HashMap<>();

    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.initDefaultEntity();
        entitys.put("Single", entity);

        MainWindow frame = new MainWindow();
        SpacePanel panel = new SpacePanel();
        panel.initPanel();
        frame.add(panel);
        frame.setSize(350, 300);
        frame.setTitle("Space Ship");
        frame.initUI();
        MainWindow.show(frame);
    }
}
