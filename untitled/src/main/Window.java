package main;

import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame jframe;
    public Window(Panel panel)
    {

        jframe = new JFrame("gra");
        jframe.setSize(500,500);
        jframe.setLocationRelativeTo(null);
        panel.add(panel.label1);
        jframe.add(panel);

        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
