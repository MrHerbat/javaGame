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
    //other
    public byte choice = 0, cChoice=0, loop = 1, x = 4;;
    private int aniTick, aniId, aniSpeed = 60;
    public boolean hit = false;

    //texts
    public String[] tekst = {"Attack","Defend", "Items", "Run"};
    public JLabel label1 = new JLabel();

    //images
    private BufferedImage img, subImg;
    private BufferedImage[] dummyHit, dummyIdle;
    private Image scaledImg;

    public Panel()
    {
        //panel size
        setPanelSize();


        //images
        importImg();
        loadAnimations();

        //Keyboard Inputs
        this.addKeyListener(new KeyboardInputs(this));
        this.setFocusable(true);
        this.requestFocusInWindow();

        //texts
        this.add(label1);
    }
    //setting size of the panel
    private void setPanelSize()
    {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    //load animations
    private void loadAnimations()
    {
        dummyHit = new BufferedImage[4];
        dummyIdle = new BufferedImage[1];

        for (int i = 0; i < dummyHit.length; i++)
        {
            dummyHit[i] = img.getSubimage((i+1)*32,0,32,32);
        }
        dummyIdle[0] = img.getSubimage(0,0,32,32);
    }
    private void updateAnimationTick()
    {
        aniTick++;
        if(aniTick >= aniSpeed)
        {
            aniTick = 0;
            aniId++;
            if(aniId >= dummyHit.length)
            {
                aniId = 0;
            }
        }
    }

    //getting images
    private void importImg()
    {
        InputStream iStream = getClass().getResourceAsStream("/characters/dummy.png");
        try {
            img = ImageIO.read(iStream);
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                iStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //showing things on screen
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.fillRect(500, 200, 50, 50);
        graphics.drawImage(scaledImg, 700,200, null);
        label1.setText(tekst[choice]);
        if(hit == true)
        {
            scaledImg = dummyHit[aniId].getScaledInstance(128,128, Image.SCALE_SMOOTH);
            graphics.drawImage(scaledImg, 700,200, null);
            if(aniId==3)
            {
                hit = false;
                aniId = 0;
            }
            updateAnimationTick();
        }else {
            scaledImg = dummyIdle[0].getScaledInstance(128,128, Image.SCALE_SMOOTH);
            graphics.drawImage(scaledImg, 700,200, null);
        }
    }


}
