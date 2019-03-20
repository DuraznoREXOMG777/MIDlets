package Helloworld;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class FormCommandME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private Command c;

    public FormCommandME() {
        d = Display.getDisplay(this);
        f = new Form("Form y Command");
        f.append("Hello MIDlet\n");  //String items 
        c = new Command("Exit", Command.EXIT, 3);// 3 - priority on the display 
        f.addCommand(c);
        f.setCommandListener(this);
    }

    protected void startApp() {
        d.setCurrent(f);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean b) {
    }

    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            d.setCurrent(new Alert("", "Another command .. ", null, AlertType.ERROR));
        }
    }
}
