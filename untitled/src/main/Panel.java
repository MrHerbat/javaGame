package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener
{
    public int choice = 0, cChoice=0;
    public String[] tekst = {"Attack","Defend", "Items", "Run"};
    private int frames;
    private long lastCheck = 0;
    public JLabel label1 = new JLabel();
    private Color[] color = {new Color(0,0,0),new Color(127,50,50)};

    public Panel()
    {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.add(label1);
    }
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(100,200,50,50);
        graphics.setColor(color[cChoice]);
        graphics.fillRect(300,200,50,50);
        label1.setLocation(215, 350);
        label1.setText(tekst[choice]);


        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000)
        {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: "+frames);
            frames=0;
        }

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
                case KeyEvent.VK_ENTER:
                    if(choice == 0)
                    {
                        cChoice = 1;
                    }else{
                        cChoice = 0;
                    }
                    break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
