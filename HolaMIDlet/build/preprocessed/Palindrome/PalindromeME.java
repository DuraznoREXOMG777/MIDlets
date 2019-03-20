/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palindrome;


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
public class PalindromeME extends MIDlet implements CommandListener{

    private Display d;
    private Form f;
    private Command cs;
    private int n;

    public PalindromeME() {
        d = Display.getDisplay(this);
        n = 132;
        f = new Form("Fibonacci");
        if(isPalindromo(n)){
            f.append(n+" es palindromo");
        }else{
            f.append(n+" no es palindromo");
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
    
    private boolean isPalindromo(int n){
        String str = n+"";
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }
    
}
