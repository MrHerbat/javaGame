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
                    if(!panel.hit)
                    {
                        panel.choice++;
                        panel.loop = 1;
                    }
                } else
                {
                    if(!panel.hit)
                    {
                        panel.choice=0;
                        panel.loop = 1;
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if(panel.choice>0)
                {
                    if(!panel.hit)
                    {
                        panel.choice--;
                        panel.loop = 1;
                    }

                } else
                {
                    if(!panel.hit)
                    {
                        panel.choice=3;
                        panel.loop = 1;
                    }
                }
                break;
            case KeyEvent.VK_ENTER:
                if(panel.choice == 0)
                {
                    if(!panel.hit)
                    {
                        panel.hit = true;
                    }

                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
