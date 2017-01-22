package pl.myjava.smallspaceship;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import pl.myjava.smallspaceship.enums.PropertiesNames;

public class MainClass {
    private static final String START_PROPS = "start.props";
    private static String resourceDir = "";
    private static Map<String, String> startProps = null;

    private static void createAndShowGUI() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        startProps = Utills.loadProperties(START_PROPS, resourceDir);

        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(
                Integer.valueOf(startProps.get(PropertiesNames.main_window_x.name())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_y.name())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_width.name())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_height.name())));
        frame.setLayout(new BorderLayout());
        MainWindow panel = new MainWindow(frame.getHeight(), frame.getWidth());
        panel.initContent();
        frame.add(panel, BorderLayout.CENTER);

        // Display the window
        frame.setVisible(true);
        (new Thread(new MainLoop(panel))).start();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            resourceDir = args[0];
        }

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(MainClass::createAndShowGUI);
    }
}

class MainLoop implements Runnable {
    private JPanel mainFrame = null;
    private boolean paint = true;

    public MainLoop(JPanel mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        while (paint) {
            mainFrame.repaint();

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        paint = false;
    }
}