package main;

public class Game
{

    private Window window;
    private  Panel panel;


    public Game()
    {
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
    }
}
