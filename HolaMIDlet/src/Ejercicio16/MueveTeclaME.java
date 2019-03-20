/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio16;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Durazno
 */
public class MueveTeclaME extends MIDlet implements CommandListener {

    private Display d;
    private Canvas ca;
    private Command cs;

    public MueveTeclaME() {
        d = Display.getDisplay(this);
        cs = new Command("Salir", Command.EXIT, 3);
        ca = new Canvas() {
            private int x = 0;
            private int y = 0;

            protected void paint(Graphics g) {
                g.setColor(255, 255, 255);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(255, 0, 0);
                g.setStrokeStyle(Graphics.SOLID);
                g.fillArc(x, y, 50, 50, 0, 360);
                g.drawString("x = " + x + " y = " + y, getWidth() / 2, getHeight() / 2, 0);
            }

            protected void keyPressed(int k) {
                int up = getKeyCode(UP);
                int dn = getKeyCode(DOWN);
                int lf = getKeyCode(LEFT);
                int rt = getKeyCode(RIGHT);

                if (k == up) {
                    if (y > 0) {
                        y -= 1;
                    }
                    repaint();
                } else if (k == dn) {
                    if (y < getWidth()) {
                        y += 1;
                    }
                    repaint();
                } else if (k == lf) {
                    if (y > 0) {
                        x -= 1;
                    }
                    repaint();
                } else if (k == lf) {
                    if (x < getHeight()) {
                        x += 1;
                    }
                    repaint();
                }
            }
        };
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
