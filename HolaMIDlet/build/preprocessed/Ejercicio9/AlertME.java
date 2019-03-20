/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class AlertME extends MIDlet implements CommandListener, ItemStateListener {

    private Display d;
    private Alert a;
    private Form f;
    private TextField tt;
    private TextField tx;
    private ChoiceGroup ct;
    private ChoiceGroup cg;
    private Gauge g;
    private Command cc;
    private Command cs;
    private int s = 2;
    
    public AlertME() {
        d = Display.getDisplay(this);
        tt = new TextField("Título: ", "Un título", 10, TextField.ANY);
        tx = new TextField("", "... texto del Alert...", 50, TextField.ANY);
        
        ct = new ChoiceGroup("Seleccionar tipo: ", ChoiceGroup.EXCLUSIVE);
        ct.append("ALARM", null);
        ct.append("CONFIRMATION", null);
        ct.append("ERROR", null);
        ct.append("INFO", null);
        ct.append("WARNING", null);
        ct.setSelectedIndex(0, true);
        
        cg = new ChoiceGroup("Tiempo: ", ChoiceGroup.EXCLUSIVE);
        cg.append("Forever", null);
        cg.append("Temporal", null);
        cg.setSelectedIndex(0, true);
        
        g = new Gauge("Gauge (min = 0 max = 20)", true, 20, s);
        f = new Form("Ejemplo de Alert");
        
        cc = new Command("Continuar", Command.OK, 0);
        cs = new Command("Salir", Command.EXIT, 3);
        f.append(tt);
        f.append(tx);
        f.append(ct);
        f.append(cg);
        f.append(g);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
        f.setItemStateListener(this);
    }
    
    public void startApp() {
        d.setCurrent(new Alert("", "En estado activo", null, AlertType.ERROR));
        d.setCurrent(f);
    }
    
    public void pauseApp() {
        d.setCurrent(new Alert("", "En estado pausado", null, AlertType.ERROR));
    }
    
    public void destroyApp(boolean unconditional) {
        d.setCurrent(new Alert("", "En estado terminando", null, AlertType.ERROR));
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (c == cc) {
            switch (ct.getSelectedIndex()) {
                case 0:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.ALARM);
                    break;
                case 1:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.CONFIRMATION);
                    break;
                case 2:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.ERROR);
                    break;
                case 3:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.INFO);
                    break;
                case 4:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.WARNING);
                    break;
                default:
                    a = new Alert(tt.getString(), tx.getString(), null, AlertType.INFO);
                    break;
            }
            
            if ((cg.getSelectedIndex() == 0) || g.getValue() == 0) {
                a.setTimeout(Alert.FOREVER);
            } else {
                a.setTimeout(g.getValue() * 1000);
            }
            this.d.setCurrent(a);
        }else{
            this.d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));
        }
        
    }
    
    public void itemStateChanged(Item item) {
        if(item == cg){
            if(cg.getSelectedIndex() == 0){
                s = g.getValue();
                g.setValue(0);
            }else{
                g.setValue(s);
            }
        }else if(item == g){
            if(g.getValue() == 0){
                cg.setSelectedIndex(0, true);
            }else{
                cg.setSelectedIndex(1, true);
            }
        }else{
            this.d.setCurrent(new Alert("", "Otro item seleccionado...", null, AlertType.ERROR));
        }
    }
}
