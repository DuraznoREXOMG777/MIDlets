/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio15;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Durazno
 */
public class ImagenCanvasME extends MIDlet implements CommandListener {

    private Display d;
    private Command cs;
    private Canvas ca;

    public ImagenCanvasME() {
        d = Display.getDisplay(this);
        ca = new Canvas() {
            private int w;
            private int h;

            protected void paint(Graphics g) {
                w = getWidth();
                h = getHeight();
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, w, h);
                try {
                    Image i = Image.createImage("/java.jpg");
                    g.drawImage(i, w / 2, h / 2, (Graphics.VCENTER | Graphics.HCENTER));

                } catch (IOException e) {
                    g.setColor(255, 255, 255);
                    g.setStrokeStyle(Graphics.SOLID);
                    g.drawString("Error al leer java.jpg", 0, h / 2, (Graphics.BASELINE | Graphics.LEFT));
                }
            }
        };
        cs = new Command("Salir", Command.EXIT, 3);
        ca.addCommand(cs);
        ca.setCommandListener(this);
    }

    public void startApp() {
        d.setCurrent(ca);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            this.d.setCurrent(new Alert("", "Otro comando digitado...", null, AlertType.ERROR));
        }
    }
}
