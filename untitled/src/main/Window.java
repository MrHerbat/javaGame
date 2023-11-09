package main;

import javax.swing.*;

public class Window
{
    private JFrame jframe;
    public Window(Panel panel)
    {
        jframe = new JFrame();
        jframe.setSize(500,500);
        jframe.setLocationRelativeTo(null);

        jframe.add(panel);

        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
