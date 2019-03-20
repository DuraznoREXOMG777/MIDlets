/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class ChoiceGroupME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private TextField tf;
    private ChoiceGroup cg;
    private ChoiceGroup ch;
    private Command cs;

    public ChoiceGroupME() {
        d = Display.getDisplay(this);
        f = new Form("ChoiceGroup");
        tf = new TextField("Nombre: ", "", 10, TextField.ANY);
        cg = new ChoiceGroup("Sexo: ", ChoiceGroup.EXCLUSIVE);
        cg.append("Masculino", null);
        cg.append("Femenino", null);
        ch = new ChoiceGroup("Lenguajes: ", ChoiceGroup.MULTIPLE);
        ch.append("Java", null);
        ch.append("C#", null);
        ch.append("Prolog", null);
        ch.append("Otros", null);
        cs = new Command("Salir", Command.EXIT, 3);

        f.append(tf);
        f.append(cg);
        f.append(ch);
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
