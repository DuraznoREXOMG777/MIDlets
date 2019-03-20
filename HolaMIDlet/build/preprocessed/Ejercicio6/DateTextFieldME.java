/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio6;

import java.util.Calendar;
import java.util.Date;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

/**
 * @author Durazno
 */
public class DateTextFieldME extends MIDlet implements CommandListener{
    private Display d;
    private Form f;
    private Command cc;
    private Command cs;
    private DateField dt;
    private TextField tf;
    private StringItem si;

    public DateTextFieldME() {
        d = Display.getDisplay(this);
        f = new Form("Textfield y Datefield");
        cs = new Command("Salir", Command.EXIT, 3);
        cc = new Command("Continuar", Command.OK, 0);
        tf = new TextField("Nombre: ", "", 10, TextField.ANY);
        dt = new DateField("Cumpleaños: ", DateField.DATE);
        si = new StringItem("", "");
        
        f.append(tf);
        f.append(dt);
        f.append(si);
        f.addCommand(cc);
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
        if(c == cs){
            destroyApp(true);
            notifyDestroyed();
        }else if(c == cc){
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Date date = dt.getDate();
            
            if(date == null || (tf.getString().equals(""))){
                si.setText("Favor de ingresar su nombre...");
                return;
            }
            c2.setTime(date);
            int edad = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
            f.delete(0);
            f.delete(0);
            f.removeCommand(cc);
            si.setText("Hola, " + tf.getString() +"\ntu Edad es = "+ edad +" años");
        }else{
            this.d.setCurrent(new Alert("", "Otro comando...", null, AlertType.INFO));
        }
    }
}
