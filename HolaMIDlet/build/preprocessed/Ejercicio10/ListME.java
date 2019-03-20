/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio10;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class ListME extends MIDlet implements CommandListener {

    public static final int CONECTAR = 0;
    public static final int ESTADO = 1;
    public static final int INSERTAR = 2;
    public static final int DESCONECTAR = 3;
    public static final int MENU = 4;

    private Display d;
    private List l;
    private TextBox tb;
    private Form f;
    private TextField ts;
    private TextField tf;
    private ChoiceGroup cr;
    private Command cs;
    private Command cc;
    private int n;

    public ListME() {
        n = MENU;
        d = Display.getDisplay(this);
        ts = new TextField("Servidor: ", "", 10, TextField.URL);
        tb = new TextBox("Estado", "Sin Conexión", 400, TextField.ANY);
        tf = new TextField("Area ID", "0", 10, TextField.NUMERIC);

        cr = new ChoiceGroup("Riesgo: ", ChoiceGroup.EXCLUSIVE);
        cr.append("Bajo", null);
        cr.append("Normal", null);
        cr.append("Alto", null);

        l = new List("Seleccionar opción: ", List.EXCLUSIVE);
        l.append("Conectar", null);
        l.append("Solicitar Datos", null);
        l.append("Ingresar Datos", null);
        l.append("Desconectar", null);

        f = new Form("Menú Conectar");
        cs = new Command("Salir", Command.EXIT, 3);
        cc = new Command("Continuar", Command.OK, 1);

        l.addCommand(cs);
        l.addCommand(cc);
        l.setCommandListener(this);

        f.addCommand(cs);
        f.addCommand(cc);
        f.setCommandListener(this);

        tb.addCommand(cs);
        tb.setCommandListener(this);
    }

    public void startApp() {
        d.setCurrent(l);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (n == MENU) {
            if (c == cs) {
                destroyApp(true);
                notifyDestroyed();
            } else if (c == cc) {
                switch (l.getSelectedIndex()) {
                    case CONECTAR:
                        conectar();
                        break;
                    case ESTADO:
                        listar();
                        break;
                    case INSERTAR:
                        insertar();
                        break;
                    case DESCONECTAR:
                        desconectar();
                        break;
                }
            } else {
                this.d.setCurrent(new Alert("", "Otro comando seleccionado...", null, AlertType.ERROR));
            }
        } else if (c == cs) {
            muestraMenu();
        } else if (c == cc) {
            switch (l.getSelectedIndex()) {
                case CONECTAR:
                    conectar();
                    break;
                case ESTADO:
                    listar();
                    break;
                case INSERTAR:
                    insertar();
                    break;
                case DESCONECTAR:
                    desconectar();
                    break;
            }
        } else {
            this.d.setCurrent(new Alert("", "Otro comando seleccionado...", null, AlertType.ERROR));
        }
    }

    public void conectar() {
        n = CONECTAR;
        f.setTitle("Menú Conectar");
        while(f.size() > 0){
            f.delete(0);
        }
        f.append(ts);
        d.setCurrent(f);
    }
    
    public void listar() {
        n = ESTADO;
        d.setCurrent(tb);
    }
    
    public void insertar() {
        n = INSERTAR;
        f.setTitle("Menú Insertar");
        while(f.size() > 0){
            f.delete(0);
        }
        f.append(tf);
        f.append(cr);
        d.setCurrent(f);
    }
    
    public void desconectar() {
        n = DESCONECTAR;
        d.setCurrent(new Alert("Desconectar", "No está conectado a un servidor.", null, AlertType.ERROR));
        n = MENU;
    }
    
    public void muestraMenu() {
        n = MENU;
        d.setCurrent(l);
    }

}
