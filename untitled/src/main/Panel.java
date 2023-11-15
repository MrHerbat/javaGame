package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener
{
    public int choice = 0;
    public String[] tekst = {"Attack","Defend", "Items", "Run",""};
    public JLabel label1 = new JLabel();

    public Panel()
    {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.fillRect(100,200,50,50);
        graphics.fillRect(300,200,50,50);
        label1.setText(tekst[choice]);
        repaint();
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
                if(choice<3)
                {
                    choice++;
                } else
                {
                    choice=0;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(choice>0)
                {
                    choice--;
                } else
                {
                    choice=3;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
