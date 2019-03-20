/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fibonacci;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Durazno
 */
public class FibonacciME extends MIDlet implements CommandListener{

    private Display d;
    private Form f;
    private Command cs;
    private int n;

    public FibonacciME() {
        d = Display.getDisplay(this);
        n = 131;
        f = new Form("Fibonacci");
        if(isFibonacci(n)){
            f.append(n+" es fibonacci");
        }else{
            f.append(n+" no es fibonacci");
        }
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
        }
    }
    
    private boolean isFibonacci(int n){
        return isPerfectSquare(5*n*n+4) || isPerfectSquare(5*n*n-4);
    }
    
    private boolean isPerfectSquare(int n){
        int x = (int) Math.sqrt(n);
        return x*x == n;
    }
}
