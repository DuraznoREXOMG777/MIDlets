/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagen;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Durazno
 */
public class MoverImagenME extends MIDlet {
    
    Display d;
    Imagen img;

    public MoverImagenME() {
        d = Display.getDisplay(this);
        img = new Imagen(this);
    }
    
    public void startApp() {
        d.setCurrent(img);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    
    public void salir(){
        destroyApp(true);
        notifyDestroyed();
    }
    
    class Imagen extends Canvas implements CommandListener {
    private MoverImagenME mi;
    private Image im;
    private Command c;
    private int x, y;
    public Imagen(MoverImagenME mid) {
        c = new Command("Salir", Command.EXIT, 1);
        this.mi = mid;
        this.addCommand(c);
        this.setCommandListener(this);
        try {						// Carpeta para la imagen, por ejemplo:
            im = Image.createImage("Resources/foto.jpg");	//...\NetBeansProjects\MiProyecto\build\compiled\foto.png
        } catch (Exception e) {
            // System.out.println("Error al cargar archivo de imagen");
        }
        x = y = 0;
    }
    public void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0, 0, 0);
        g.drawImage(im, x, y, Graphics.TOP|Graphics.LEFT);
    }
    protected void keyPressed(int keyCode) {
        switch (getGameAction(keyCode)) {
            case Canvas.DOWN: {
                if ((y + 20) < getHeight()) {
                    y = y + 1;
                }
                break;
            }
            case Canvas.LEFT: {
                if (x > 0) {
                    x = x - 1;
                }
                break;
            }
            case Canvas.UP: {
                if (y > 0) {
                    y = y - 1;
                }
                break;
            }
            case Canvas.RIGHT: {
                if ((x + 20) < getWidth()) {
                    x = x + 1;
                }
                break;
            }
        }
        this.repaint();
    }
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            mi.salir();
        }
    }
}
}
