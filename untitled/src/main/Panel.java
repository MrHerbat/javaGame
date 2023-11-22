package main;

import inputs.KeyboardInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Panel extends JPanel
{
    public byte choice = 0, cChoice=0;
    public String[] tekst = {"Attack","Defend", "Items", "Run"};
    public JLabel label1 = new JLabel();
    private BufferedImage img, subImg;
    private Image scaledImg;
    private int x,y;

    public Panel()
    {
        this.addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        importImg();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.add(label1);
    }

    private void importImg()
    {
        InputStream inputStream = getClass().getResourceAsStream("/characters/dummy.png");
        try {
            img = ImageIO.read(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setPanelSize()
    {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }
    public void setCordinates(int x,int y)
    {
        x = 100;
        y = 300;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        subImg = img.getSubimage(0,0,32,32);
        scaledImg = subImg.getScaledInstance(128,128, Image.SCALE_SMOOTH);

        graphics.fillRect(100, 200, 50, 50);
        graphics.drawImage(scaledImg, 300,200, null);
        repaint();
    }
}
