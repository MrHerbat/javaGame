package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener
{
    private int deltaX = 0, deltaY = 0;
    public void moveX(int value)
    {
        deltaX+=value;
        repaint();
    }
    public void moveY(int value)
    {
        deltaY+=value;
        repaint();
    }
    public Panel()
    {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.fillRect(200+deltaX,200+deltaY,50,50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key)
        {
            case KeyEvent.VK_UP:
                moveY(-5);
                break;
            case KeyEvent.VK_DOWN:
                moveY(5);
                break;
            case KeyEvent.VK_LEFT:
                moveX(-5);
                break;
            case KeyEvent.VK_RIGHT:
                moveX(5);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
