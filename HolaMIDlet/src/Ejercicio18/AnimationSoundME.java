/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio18;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 * @author Durazno
 */
public class AnimationSoundME extends MIDlet {

    Display d;
    Pantalla p;
    Player player;
    InputStream ins;

    public AnimationSoundME() {
        d = Display.getDisplay(this);
        p = new Pantalla();
        ins = getClass().getResourceAsStream("/Resources/church.mp3");
        try {
            player = Manager.createPlayer(ins, "audio/mp3");
            player.setLoopCount(1);
            player.start();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }

    public void startApp() {
        d.setCurrent(p);
    }

    public void pauseApp() {
        try {
            player.stop();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }

    public void destroyApp(boolean unconditional) {
    }

    class Pantalla extends GameCanvas implements Runnable {

        int x = 0, y = 0;
        int velx = 6, vely = 4;

        public Pantalla() {
            super(true);
            Thread t = new Thread(this);
            t.start();
        }

        public void paint(Graphics g) {
            g.setColor(255, 255, 210);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(0, 255, 2);
            g.fillArc(x, y, 30, 30, 0, 360);
        }

        public void run() {
            while (true) {
                x += velx;
                y += vely;
                repaint();
                if (x + 30 > getWidth() || x < 0) {
                    velx = -velx;
                }
                if (y + 30 < getHeight() || y < 0) {
                    vely = -vely;
                }
                try{
                    Thread.sleep(50);
                    flushGraphics();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
