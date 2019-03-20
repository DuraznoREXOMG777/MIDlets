package Helloworld;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Maravilloso extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private ImageItem ii;
    private Command c;

    public Maravilloso() {
        d = Display.getDisplay(this);
        f = new Form("Image Item");
        try {
            ii = new ImageItem("", Image.createImage("res/java.png"), ImageItem.LAYOUT_CENTER, "Java Logo"); //
            f.append(ii); //add the image to the form
        } catch (java.io.IOException e) {
            f.append(" Error to read the file java.png: " + e);
        }
        c = new Command("Exit", Command.EXIT, 3);
        f.addCommand(c);
        f.setCommandListener(this);
    }

    protected void startApp() {
        d.setCurrent(f); //mandatory, nothing to show
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
            d.setCurrent(new Alert("", "Other command...", null, AlertType.ERROR));
        }
    }
}
