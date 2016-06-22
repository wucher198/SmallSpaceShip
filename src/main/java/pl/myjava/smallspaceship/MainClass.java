package pl.myjava.smallspaceship;

import javax.swing.*;
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
                Integer.valueOf(startProps.get(PropertiesNames.main_window_x.toString())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_y.toString())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_width.toString())),
                Integer.valueOf(startProps.get(PropertiesNames.main_window_height.toString())));

        //Add the ubiquitous "Hello World" label
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // Display the window
        frame.setVisible(true);
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