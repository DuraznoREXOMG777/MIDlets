package Ejercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

/**
 * @author Durazno
 */
public class Main extends MIDlet implements CommandListener{
    private Display d;
    private Form f;
    private Command c;
    private Command c2;
    
    public Main(){
        d = Display.getDisplay(this);
        f = new Form("Hola MIDlet");
        f.append("Hola MIDlet!\n");
        c = new Command("Salir", Command.EXIT, 3);
        c2 = new Command("ShowAlert", Command.EXIT, 2);
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
            this.d.setCurrent(new Alert("Error Message", "Otro comando...", null,  AlertType.ERROR));
        }
    }
}
