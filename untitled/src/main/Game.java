package main;

public class Game implements Runnable
{

    private Window window;
    private  Panel panel;
    private Thread gameThread;
    private final int FPS_SET=60;
    private final int UPS_SET = 100;


    public Game()
    {
        panel = new Panel();
        startGameLoop();
        window = new Window(panel);
        panel.requestFocus();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastFrame = System.nanoTime();
        long now;

        long previousTime = System.nanoTime();
        

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) 
        {
            now = System.nanoTime();
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerUpdate;
            previousTime = currentTime;
        
            if(deltaU>=1)
            {
                //update();
                updates++;
                deltaU--;
            }
            if(deltaF>=1)
            {
                panel.repaint();
                //update();
                frames++;
                deltaF--;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames+ " | UPS: "+updates);
                frames = 0;
                updates = 0;
            }
        }
    }


}
