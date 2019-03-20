/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio11;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class CanvasME extends MIDlet implements CommandListener {

    private Display d;
    private Canvas canvas;
    private Command cs;

    public CanvasME() {
        d = Display.getDisplay(this);
        canvas = new Canvas() {
            private int width;
            private int height;

            public void paint(Graphics g) {
                width = getWidth();
                height = getHeight();

                //Set Graphics Properties and Draw
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, width, height);
                g.setColor(255, 255, 255);
            }
        };

        cs = new Command("Salir", Command.EXIT, 3);
        canvas.addCommand(cs);
        canvas.setCommandListener(this);
    }

    public void startApp() {
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
            this.d.setCurrent(new Alert("", "Otro comandno..", null, AlertType.ERROR));
        }
    }
}
