package inputs;

import main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private Panel panel;
    public KeyboardInputs(Panel panel)
    {
        this.panel = panel;
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
                if(panel.choice<3)
                {
                    panel.choice++;
                } else
                {
                    panel.choice=0;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(panel.choice>0)
                {
                    panel.choice--;
                } else
                {
                    panel.choice=3;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(panel.choice == 0)
                {
                    panel.cChoice = 1;
                }else{
                    panel.cChoice = 0;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
