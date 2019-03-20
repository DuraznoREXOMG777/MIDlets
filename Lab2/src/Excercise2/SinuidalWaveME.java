package Excercise2;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class SinuidalWaveME extends MIDlet {

    private Display d;
    private Canvas ca;

    public SinuidalWaveME() {
        d = Display.getDisplay(this);
        ca = new Canvas() {
            private int h = getHeight();
            private int w = getWidth();
            private int yBase = h/2;
            private int xBase = 0;
            
            protected void paint(Graphics g) {
                g.setColor(255, 255, 255);
                g.drawRect(0, 0, w, h);
                
                g.setColor(0, 255, 0);
                
                g.fillRect(w/2, 0, 2, h);
                g.fillRect(0, h/2, w, 2);
                
                g.setColor(0, 0, 255);
                for (int i = 0; i < w; i++) {
                    int x = i+5;
                    int y = (int) ((yBase - 60*Math.cos(Math.toRadians((i-5)/-.18))));
                    g.fillRect(x, y, 1, 1);
                }
            }
        };
    }

    public void startApp() {
        d.setCurrent(ca);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
