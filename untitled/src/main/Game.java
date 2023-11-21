package main;

public class Game implements Runnable
{

    private Window window;
    private  Panel panel;
    private Thread gameThread;
    private final int FPS_SET=120;


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
        long lastFrame = System.nanoTime();
        long now;

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {

            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                panel.repaint();
                lastFrame = now;
                frames++;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }


}
