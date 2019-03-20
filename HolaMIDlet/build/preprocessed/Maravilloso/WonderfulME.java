/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maravilloso;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class WonderfulME extends MIDlet implements CommandListener{

    private Display d;
    private TextBox tb;
    private Command cs;
    private int n;

    public WonderfulME() {
        d = Display.getDisplay(this);
        n = 131;
        tb = new TextBox("Maravilloso", wonderfulIt(n), 400, TextField.ANY);
    }

    public void startApp() {
        d.setCurrent(tb);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c == cs){
            destroyApp(true);
            notifyDestroyed();
        }
    }
    
    private String wonderfulIt(int n){
        String cadena = "";
        int temp = n;
        cadena += n+", ";
        while(temp != 1){
            if(temp%2 == 0){
                temp /= 2;
            }else{
                temp = temp*3+1;
            }
            cadena += temp+", ";
        }
        return cadena.substring(0, cadena.length()-2);
    }
}
