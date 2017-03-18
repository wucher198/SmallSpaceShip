package pl.myjava.smallspaceship.base;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anonim on 28.01.17.
 */
public abstract class AbstractPaintComponent extends JComponent {
    protected static Logger logger = Logger.getLogger("PaintComponent");

    private boolean running = true;

    public abstract void moveEntitis();

    public abstract void drawEntitis(Graphics2D g2);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawEntitis(g2);
        g2.dispose();
    }

    public void start() {
        (new Thread(new Loop(this))).start();
    }

    public void stop() {
        running = false;
    }

    private class Loop implements Runnable {
        private AbstractPaintComponent componentToPaint;

        public Loop(AbstractPaintComponent componentToPaint) {
            this.componentToPaint = componentToPaint;
        }

        @Override
        public void run() {
            logger.log(Level.INFO, "Start Run Method");

            while (running) {
                try {
                    logger.log(Level.INFO, "Loop Execution Start");
                    componentToPaint.moveEntitis();
                    componentToPaint.repaint();
                    Thread.sleep(25);
                    logger.log(Level.INFO, "Loop Execution Stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
