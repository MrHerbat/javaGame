package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel
{
    public int choice = 0, cChoice=0;
    public String[] tekst = {"Attack","Defend", "Items", "Run"};
    public JLabel label1 = new JLabel();
    private Color[] color = {new Color(0,0,0),new Color(127,50,50)};

    public Panel()
    {
        this.addKeyListener(new KeyboardInputs(this));
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

        repaint();
    }

}
