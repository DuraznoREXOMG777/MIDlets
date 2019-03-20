/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;

/**
 * @author Durazno
 */
public class ImagesDir extends MIDlet implements CommandListener {

    Display d;
    Form f;
    Image img;
    ImageItem imgItem;
    Command c;

    public ImagesDir() {
        d = Display.getDisplay(this);
        f = new Form("ImageItem");
        try {
            imgItem = new ImageItem("", Image.createImage("Resources/java.jpg"),
                    ImageItem.LAYOUT_CENTER, "Logo de Java");
            f.append(imgItem);
        } catch (IOException e) {
            f.append("Error al leer el archivo java.jpg: " + e);
        }
        c = new Command("Salir", Command.EXIT, 3);
        f.addCommand(c);
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
        if (c == this.c) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            this.d.setCurrent(new Alert("", "Otro comando...", null, AlertType.INFO));

        }
    }
}
