/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class Triangle extends MIDlet {

    Display d;
    Canvas c;

    public Triangle() {
        d = Display.getDisplay(this);
        c = new Canvas() {
            protected void paint(Graphics g) {
                int h = getHeight();
                int w = getWidth();
                //Paint the Background.
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, w, h);

                //Paint three dots.
                g.setColor(255, 0, 0);
                g.fillRect(0, h / 4 * 3, 4, 4);
                g.fillRect(w - 4, h / 4 * 3, 4, 4);

                int distance = (w - 4) / 2;
                int altitude = (int) Math.sqrt((((w - 4) ^ 2) - (distance ^ 2)));

                g.fillRect(distance, altitude, 4, 4);

                g.setColor(239, 100, 206);
                Random r = new Random();
                
                int y = r.nextInt(100);
                int x = r.nextInt(100);
                int vector[][] = {
                    {0, h / 4 * 3},
                    {w - 4, h / 4 * 3},
                    {distance, altitude}
                };

                g.fillRect(x, y, 4, 4);

                g.setColor(0, 0, 255);
                
                
                int randomLoop = r.nextInt(10000)+1000;
                for (int i = 0; i < randomLoop; i++) {
                    int index = r.nextInt(3);
                    int tempx = vector[index][0];
                    int tempy = vector[index][1];
                    int xx = (x + tempx) / 2;
                    int yy = (y + tempy) / 2;
                    g.fillRect(xx, yy, 1, 1);
                    
                    x = xx;
                    y = yy;
                }
            }
        };
    }

    private void paintMyTriangle(Graphics g, int w, int h) {

    }

    public void startApp() {
        d.setCurrent(c);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
