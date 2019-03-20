/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package Helloworld;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

public class Sinus extends MIDlet {

    Display d;
    Canvas c;

    public Sinus() {

        d = Display.getDisplay(this);
        c = new Canvas() {

            int h = getHeight();
            int w = getWidth();

            protected void paint(Graphics g) {

                //The x-axis
                g.setColor(0, 0, 0);
                g.fillRect(0, h / 2, w, 3);
                g.drawString("x", w - 8, h / 2 + 3, 0);

                //The y-axis
                g.fillRect(w / 2, 0, 3, h);
                g.drawString("y", w / 2 + 5, 2, 0);

                g.setColor(214, 75, 214);
                for (int i = 0; i < w; i++) {
                        int y = (int) (h/2 - (50 * Math.cos(Math.toRadians(i/-.15+Math.PI/180 ))));

                        g.drawRect(i, y, 1, 1);

                }
            }
        };

    }

    public void startApp() {
        d.setCurrent(c);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
