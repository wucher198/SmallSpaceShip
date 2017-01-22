package pl.myjava.smallspaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Created by anonim on 21.01.17.
 */
public class MainWindow extends JPanel {
    private Double[][] pointsMatrix = null;
    private int height = 100;
    private int width = 100;
    private int start = 0;

    public MainWindow(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void initContent() {
        pointsMatrix = new Double[height][];
        addRow();
    }

    private void addRow() {
        pointsMatrix[start] = getRandomPoints((int) (Math.random() * 100));
        start++;

        if (start > height) {
            start = 0;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("PaintComponent");
        drawPoints((Graphics2D) g);
        addRow();
    }

    private void drawPoints(Graphics2D g2) {
        g2.setBackground(Color.black);
        g2.setPaint(Color.BLACK);
        g2.fill(new Rectangle(0, 0, width, height));
        g2.setColor(Color.white);

        int left = start - 1;

        while (left != start -1 ) {
            if (pointsMatrix[left] != null) {
                for (int right = pointsMatrix[left].length - 1; right >= 0 ; right--) {
                    if (pointsMatrix[left][right] != null) {
                        g2.setColor(Color.white);
                        g2.draw(new Line2D.Double(
                                pointsMatrix[left][right],
                                left,
                                pointsMatrix[left][right],
                                left));
                    }
                }
            }

            left--;

            if (left < 0) {
                left = pointsMatrix.length - 1;
            }
        }

    }

    private Double[] getRandomPoints(int numberOfPoints) {
        Double[] points = new Double[numberOfPoints];

        for (int count = 0; count < numberOfPoints; count++) {
            points[count] = getRandomPointOnTop();
        }

        return points;
    }

    private Double getRandomPointOnTop() {
        return Math.random() * width;
    }
}
