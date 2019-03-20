package Helloworld;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class AlertME extends MIDlet implements CommandListener, ItemStateListener {

    private Display d;
    private Alert a;
    private Form f;
    private TextField tt;
    private TextField tx;
    private ChoiceGroup ct;
    private ChoiceGroup cg;
    private Gauge g;
    private Command cc;
    private Command cs;
    private int s = 2;

    public AlertME() {
        s = 2;
        d = Display.getDisplay(this);
        tt = new TextField("Title:", "A title", 10, TextField.ANY);
        tx = new TextField("", "... Enter text ...", 50, TextField.ANY);
        ct = new ChoiceGroup("Select type :", ChoiceGroup.EXCLUSIVE);
        ct.append("ALARM", null);
        ct.append("CONFIRMATION", null);
        ct.append("ERROR", null);
        ct.append("INFO", null);
        ct.append("WARNING", null);
        ct.setSelectedIndex(0, true);
        cg = new ChoiceGroup("Weather:", ChoiceGroup.EXCLUSIVE);
        cg.append("Forever", null);
        cg.append("Temporary", null);
        cg.setSelectedIndex(0, true);
        g = new Gauge("Gauge (min=0 max=20)", true, 20, s);
        f = new Form("Example Alert");
        f.append(tt);
        f.append(tx);
        f.append(ct);
        f.append(cg);
        f.append(g);
        cc = new Command("Continue", Command.OK, 0);
        cs = new Command("Exit", Command.EXIT, 3);
        f.addCommand(cc);
        f.addCommand(cs);
        f.setCommandListener(this);
        f.setItemStateListener(this);
    }

    protected void startApp() {
        d.setCurrent(new Alert("", "In Active state" , null, AlertType.ERROR));
        d.setCurrent(f);
    }

    protected void pauseApp() {
        d.setCurrent(new Alert("", "In a quiet state ...", null,
                AlertType.ERROR));
    }

    protected void destroyApp(boolean b) {
        d.setCurrent(new Alert("", "In the finished state", null, AlertType.ERROR));
    }

    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (co == cc) {
            switch (ct.getSelectedIndex()) {
                case 0:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.ALARM);
                    break;
                case 1:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.CONFIRMATION);
                    break;
                case 2:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.ERROR);
                    break;
                case 3:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.INFO);
                    break;
                case 4:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.WARNING);
                    break;
                default:
                    a = new Alert(tt.getString(), tx.getString(), null,
                            AlertType.INFO);
            }
            if ((cg.getSelectedIndex() == 0) || (g.getValue() == 0)) {
                a.setTimeout(Alert.FOREVER);
            } else {
                a.setTimeout(g.getValue() * 1000);
            }
            d.setCurrent(a);
        } else {
            d.setCurrent(new Alert("", "Another command ...", null,
                    AlertType.ERROR));
        }
    }

    public void itemStateChanged(Item item) {
        if (item == cg) {
            if (cg.getSelectedIndex() == 0) {
                s = g.getValue();
                g.setValue(0);
            } else {
                g.setValue(s);
            }
        } else if (item == g) {
            if (g.getValue() == 0) {
                cg.setSelectedIndex(0, true);
            } else {
                cg.setSelectedIndex(1, true);
            }
        } else {
            d.setCurrent(new Alert("", " Another item selected ...", null, AlertType.ERROR));
        }
    }
}
