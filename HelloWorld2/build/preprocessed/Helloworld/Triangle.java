package Helloworld;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

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
             
                //int distance = getHeight();
                //int altitude = (((w^2) - (b)^2) ^ (1 / 2));
                
                //calculate the middle point 
                int distance = w/2;
                
                // a^2 = c^2 - b^2
                int height = (((w)^2) - (distance^2))^(1/2); //Pythagoras to calculate the height
                                
                g.fillRect(distance, height, 4, 4);

                g.setColor(239, 100, 206);
                Random r = new Random();

                int y = r.nextInt() % 100;
                int x = r.nextInt() % 100;
                int vector[][] = {
                    {0, h / 4 * 3},
                    {w - 4, h / 4 * 3},
                    {distance, height}
                };

                g.fillRect(x, y, 4, 4);

                g.setColor(0, 0, 255);

                for (int i = 0; i < 1000; i++) {
                    int index = r.nextInt() % 2 + 1;
                 System.out.println(index);
                    
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
