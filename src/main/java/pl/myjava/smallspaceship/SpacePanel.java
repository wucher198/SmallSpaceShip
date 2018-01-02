package pl.myjava.smallspaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class SpacePanel extends MainPanel implements ActionListener {
    private Timer timer;
    private long start;
    private final long MIN_TIME = 1000;
    private long count;

    public void initPanel() {
        addKeyListener(new KeysAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        timer = new Timer(25,this);
        timer.start();
    }

    @Override
    protected void doDrawing(Graphics g) {
        if (start <= 0) {
            start = new Date().getTime();
        }

        count++;
        Graphics2D g2 = create(g);

        MainGameClass.entitys.entrySet().forEach(entry -> {
            entry.getValue().draw(g2);
        });

        long stop = new Date().getTime();

        if (stop - start >= MIN_TIME) {
            System.out.println(1000 * count / (stop - start) + ": " + (stop - start));
            start = -1;
            count = 0;
        }

        dispose(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainGameClass.entitys.entrySet().forEach(entry -> entry.getValue().move(getWidth(), 0, getHeight(), 0));
        repaint();
    }

    private class KeysAdapter extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent e) {
            MainGameClass.entitys.entrySet().forEach(entry -> entry.getValue().keyPressed(e));
        }

        @Override
        public void keyReleased(final KeyEvent e) {
            MainGameClass.entitys.entrySet().forEach(entry -> entry.getValue().keyReleased(e));
        }
    }
}
