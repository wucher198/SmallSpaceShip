package pl.myjava.smallspaceship;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow initUI() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return this;
    }

    public static void show(final MainWindow frame) {
        EventQueue.invokeLater(() -> {
            frame.setVisible(true);
        });
    }
}
