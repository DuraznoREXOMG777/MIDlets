package Helloworld;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class CanvasME extends MIDlet implements CommandListener {

    private Display d;
    private Command cs;
    private Canvas ca;

    public CanvasME() {
        d = Display.getDisplay(this);
        ca = new Canvas() {
            private int w;
            private int h;

            public void paint(Graphics g) {
                w = getWidth();
                h = getHeight();
                g.setColor(255, 0, 0);
                g.fillRect(0, 0, w, h);
                g.setColor(0, 0, 0);
                g.drawLine(0, 0, 50, 50);
            }
        };
        cs = new Command("Exit", Command.EXIT, 3);
        ca.addCommand(cs);
        ca.setCommandListener(this);
    }

    protected void startApp() {
        d.setCurrent(ca);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean b) {
    }

    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else {
            d.setCurrent(new Alert("", "Another command...", null, AlertType.ERROR));
        }
    }
}
