/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.CommandListener;

/**
 * @author Durazno
 */
public class FormCommand extends MIDlet implements CommandListener{
    Display d;
    Form f;
    Command c, c2;
    
    public FormCommand(){
        d = Display.getDisplay(this);
        f = new Form("Form y Command");
        c = new Command("Salir", Command.EXIT, 3);
        c2 = new Command("ShowAlert", Command.EXIT, 3);
        
        f.append("Hola MIDlet\n");
        f.addCommand(c);
        f.addCommand(c2);
        f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void commandAction(Command c, Displayable d){
        if(c == this.c){
            destroyApp(true);
            notifyDestroyed();
        }else{
            this.d.setCurrent(new Alert("", "Otro comandno..", null, AlertType.ERROR));
        }
    }
}
