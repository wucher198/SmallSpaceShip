package pl.myjava.smallspaceship;

import pl.myjava.smallspaceship.enums.ApplicationArguments;
import pl.myjava.smallspaceship.enums.Messages;
import pl.myjava.smallspaceship.enums.PropertiesNames;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anonim on 28.01.17.
 */
public class SmallSpaceShip {
    private static Logger logger = Logger.getLogger(SmallSpaceShip.class.getName());

    private static Map<String, String> applicationProperties = null;
    private static SmallSpaceShip mainClass = null;

    private String resourceFileName = "start.props";
    private String resourceFileNameDir = Utills.CURRNET_DIR;

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        mainClass = new SmallSpaceShip();

        if (mainClass.parseArguments(args)) {
            mainClass.loadProperties();
            SwingUtilities.invokeLater(() -> mainClass.createAndShowGUI());
        }
    }

    public SmallSpaceShip getMainClass;

    private void createAndShowGUI() {
        logger.log(Level.ALL, String.format(System.getProperty("user.dir")));

        // Create and set up the window.
        JFrame mainWindow = new JFrame("Small Space Ship");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setBounds(
                Integer.valueOf(applicationProperties.get(PropertiesNames.main_window_x.name())),
                Integer.valueOf(applicationProperties.get(PropertiesNames.main_window_y.name())),
                Integer.valueOf(applicationProperties.get(PropertiesNames.main_window_width.name())),
                Integer.valueOf(applicationProperties.get(PropertiesNames.main_window_height.name())));
        mainWindow.setLayout(new BorderLayout());
        SnowPaintComponent panel = new SnowPaintComponent(Arrays.asList(new SnowEntity(100, 100)));
        mainWindow.add(panel, BorderLayout.CENTER);

        // Display the window
        mainWindow.setVisible(true);
        panel.start();
    }

    private boolean parseArguments(String[] args) {
        boolean result = true;

        for (int count = 0; count < args.length; count++) {
            Optional<ApplicationArguments> parameter = ApplicationArguments.byParemeter(args[count]);

            if (parameter.isPresent()) {
                switch (parameter.get()) {
                    case H:
                        showHelp();
                        result = false;
                        break;
                    case P:
                        readDirAndFileNameOfProps(args, count);
                        break;
                }
            } else {
                logger.log(Level.ALL, String.format(Messages.UNDEFINED_PARAMETER.name(), args[count]));
            }
        }

        return result;
    }

    private int readDirAndFileNameOfProps(String[] arguments, int currentArgument) {
        String parameterWithPath = arguments[++currentArgument];

        resourceFileName = Utills.getFileName(parameterWithPath);
        resourceFileNameDir = Utills.getDirectory(parameterWithPath);

        return currentArgument;
    }

    private void showHelp() {
        System.out.println("Some help will be written. Now it ");

        System.exit(0);
    }

    private void loadProperties() {
        applicationProperties = Utills.loadProperties(resourceFileName, resourceFileNameDir);
    }
}
