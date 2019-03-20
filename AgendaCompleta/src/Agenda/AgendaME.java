/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class AgendaME extends MIDlet implements CommandListener {

    Display d;
    Forma f;
    Editar e;
    ListaContactos lc;
    RMSOps r = new RMSOps();
    ListaFotos lf;

    public AgendaME() {
        d = Display.getDisplay(this);
        f = new Forma(this);
        lc = new ListaContactos(this);
        lf = new ListaFotos(this);
        e = new Editar(this);

    }

    public void startApp() {
        d.setCurrent(lc);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean x) {
    }

    public void commandAction(Command co, Displayable di) {
    }
}
