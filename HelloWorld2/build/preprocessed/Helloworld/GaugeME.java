package Helloworld;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class GaugeME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private Gauge g;
    private Command c;

    public GaugeME() {
        d = Display.getDisplay(this);
        g = new Gauge("Amplitud", true, 10, 5); //slider, can set to true or false 
        f = new Form("Gauge");
        f.append(g);
        c = new Command("Exit", Command.EXIT, 3);
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
            d.setCurrent(new Alert("", "Other command .. ", null,
                    AlertType.ERROR));
        }
    }
}
