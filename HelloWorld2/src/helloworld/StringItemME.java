package Helloworld;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class StringItemME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private Alert a;
    private Command cs;
    private Command cc;
    private StringItem si;
    private int n;

    public StringItemME() {
        n = 0;
        d = Display.getDisplay(this);
        f = new Form("StringItem");
        f.append("Example of StringItem\n");
        si = new StringItem("String: ", "Counter = " + n);
        f.append(si);
        cs = new Command("Exit", Command.EXIT, 3);
        cc = new Command("Count", Command.SCREEN, 1);
        f.addCommand(cs);
        f.addCommand(cc);
        f.setCommandListener(this);
    }

    protected void startApp() {
        d.setCurrent(new Alert("", "MIDlet activated...", null, AlertType.ERROR));
        d.setCurrent(f);
    }

    protected void pauseApp() {
        d.setCurrent(new Alert("", "MIDlet paused...", null, AlertType.ERROR));
    }

    protected void destroyApp(boolean b) {
        d.setCurrent(new Alert("", "MIDlet finishing.", null, AlertType.ERROR));
    }

    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (co == cc) {
            n++;
            si.setText("Counter = " + n);
        } else {
            d.setCurrent(new Alert("", "MIDlet active...", null,
                    AlertType.ERROR));
        }
    }
}
