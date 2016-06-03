/*
 * MainWindow
 * Date of creation: 2016-06-03
 * 
 * Copyright (c) CompuGROUP Software GmbH,
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */

import javax.swing.*;

/** @author Maciej Smolka on 03.06.2016, PL */
public class MainClass {
    private static final String START_PROPS = "start.props";

    private static void createAndShowGUI() {
        Utills.loadProperties(START_PROPS);

        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(MainClass::createAndShowGUI);
    }
}
