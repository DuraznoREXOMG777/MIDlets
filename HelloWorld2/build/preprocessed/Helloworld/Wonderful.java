package Helloworld;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Wonderful extends MIDlet implements CommandListener {

    public static final int CONNECT = 0;
    public static final int STATE = 1;
    public static final int INSERT = 2;
    public static final int DISCONNECT = 3;
    public static final int MENU = 4;
    private Display d;
    private List l;
    private TextBox tb;
    private Form f;
    private TextField ts;
    private TextField tf;
    private ChoiceGroup cr;
    private Command cs;
    private Command cc;
    private int n;

    public Wonderful() {
        n = MENU;
        d = Display.getDisplay(this);
        ts = new TextField("Server:", "", 10, TextField.URL);
        tb = new TextBox("State", "No connection", 400, TextField.ANY);
        tf = new TextField("Area ID", "0", 10, TextField.NUMERIC);
        cr = new ChoiceGroup("Risk:", ChoiceGroup.EXCLUSIVE);
        cr.append("Low", null);
        cr.append("Normal", null);
        cr.append("high", null);
        l = new List("Select option:", List.EXCLUSIVE);
        l.append("Connect", null);
        l.append("Request Data", null);
        l.append("Enter Data", null);
        l.append("Disconnect", null);
        f = new Form("Connect Menu ");
        cs = new Command("Exit", Command.EXIT, 3);
        cc = new Command("Continue", Command.OK, 1);
        l.addCommand(cc);
        l.addCommand(cs);
        l.setCommandListener(this);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
        tb.addCommand(cs);
        tb.setCommandListener(this);
    }

    protected void startApp() {
        d.setCurrent(l);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean b) {
    }

    public void commandAction(Command co, Displayable di) {
        if (n == MENU) {
            if (co == cs) {
                destroyApp(true);
                notifyDestroyed();
            } else if (co == cc) {
                switch ( l.getSelectedIndex() ){
                    case CONNECT: connect();break;
                    case STATE: showMenu();break;
                    case INSERT: insert();break;
                    case DISCONNECT: showMenu();

                }
            }
            d.setCurrent(new Alert("", "Another command...", null,
                    AlertType.ERROR));
        } else {
            if (co == cs) {
                showMenu();
            } else if (co == cc) {
                switch (n) {
                   


                    case CONNECT: connect();break;
                    case STATE: showMenu();break;
                    case INSERT: insert();break;
                    case DISCONNECT: showMenu();
                        break;
                }
            }
            d.setCurrent(new Alert("", "Another command...", null,
                    AlertType.ERROR));
        }
    }

    public void connect() {

        n = CONNECT;
        f.setTitle("Connect menu");
        while (f.size() > 0) {
            f.delete(0);
        }
        f.append(ts);
        d.setCurrent(f);
    }

    public void insert() {
        n = INSERT;
        f.setTitle("Insert menu");
        while (f.size() > 0) {
            f.delete(0);
        }
        f.append(tf);
        f.append(cr);
        d.setCurrent(f);
    }

    public void disconnect() {
        d.setCurrent(new Alert("Disconnecting", "It is not connected to a server.", null, AlertType.ERROR));
        n = DISCONNECT;
        n = MENU;
    }

    public void list() {
        n = INSERT;
        d.setCurrent(tb);
    }

    public void showMenu() {
        n = MENU;
        d.setCurrent(l);
    }
}
