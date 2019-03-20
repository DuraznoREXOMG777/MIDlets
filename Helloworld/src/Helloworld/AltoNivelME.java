package Helloworld;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class AltoNivelME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private Command c; 
    private Alert a;

    public AltoNivelME() {
        d = Display.getDisplay(this);
        f = new Form("Hello MIDlet");
        f.append("Hello MIDlet!\n"); //String items 
        c = new Command("Exit", Command.EXIT, 3); // 3 - priority on the display 
        f.addCommand(c); //add the command to the form 
        f.setCommandListener(this);
    }
    

    protected void startApp() {
        d.setCurrent(f);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean b) {
    }

    //the actions for the applicastion 
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            d.setCurrent(new Alert("", "Otro comando...", null,
                    AlertType.ERROR));
        }
    }
}
