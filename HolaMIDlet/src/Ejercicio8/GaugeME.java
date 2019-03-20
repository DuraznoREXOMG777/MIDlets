/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class GaugeME extends MIDlet implements CommandListener{
    private Display d;
    private Form f;
    private Gauge g;
    private Command cs;

    public GaugeME() {
        d = Display.getDisplay(this);
        f = new Form("Gauge");
        g = new Gauge("Amplitud", false, 10, 3);
        cs = new Command("Salir", Command.EXIT, 3);
        
        f.append(g);
        f.addCommand(cs);
        f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == this.cs) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            this.d.setCurrent(new Alert("", "Otro comandno..", null, AlertType.ERROR));
        }
    }
}
