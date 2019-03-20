/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Displayable;

/**
 * @author Durazno
 */
public class StringItemME extends MIDlet implements CommandListener{
    private Display d;
    private Form f;
    private Command cs;
    private Command cc;
    private StringItem si;
    private int n;

    public StringItemME() {
        n = 0;
        d = Display.getDisplay(this);
        f = new Form("StringItem");
        si = new StringItem("Cadena: ", "Contador = "+ n);
        cs = new Command("Salir", Command.EXIT, 3);
        cc = new Command("Contar", Command.SCREEN, 1);
        
        f.append("Ejemplo de String Item");
        f.append(si);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(new Alert("", "MIDlet activo...", null, AlertType.INFO));
        d.setCurrent(f);
    }
    
    public void pauseApp() {
        d.setCurrent(new Alert("", "MIDlet pausado...", null, AlertType.INFO));
        d.setCurrent(f);
    }
    
    public void destroyApp(boolean unconditional) {
        d.setCurrent(new Alert("", "MIDlet terminado.", null, AlertType.ERROR));
    }
    
    public void commandAction(Command c, Displayable d){
        if(c == cs){
            destroyApp(true);
            notifyDestroyed();
        }else if(c == cc){
            n++;
            si.setText("Contador = "+n);
        }else{
            this.d.setCurrent(new Alert("", "Otro comando...", null, AlertType.INFO));
        }
    }
}
