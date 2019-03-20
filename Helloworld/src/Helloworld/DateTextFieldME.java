package Helloworld;

import java.util.Date;
import java.util.Calendar;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class DateTextFieldME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private TextField tf;
    private DateField df;
    private StringItem si;
    private Command cc;
    private Command cs;

    public DateTextFieldME() {
        d = Display.getDisplay(this);
        tf = new TextField("Name:", "", 10, TextField.ANY);
        df = new DateField("Birthday:", DateField.DATE);
        si = new StringItem("", "");
        f = new Form("TextField and DateField");
        f.append(tf);
        f.append(df);
        f.append(si);
        cc = new Command("Continue", Command.OK, 0);
        cs = new Command("Exit", Command.EXIT, 3);
        f.addCommand(cc);
        f.addCommand(cs);
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

        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (co == cc) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Date date = df.getDate();
            if ((date == null) || (tf.getString().equals(""))) {
                si.setText("Please insert your name ...");
                return;
            }
            c2.setTime(date);
            int edad = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
            f.delete(0);
            f.delete(0);
            f.removeCommand(cc);
            si.setText("Hello " + tf.getString() + "\n Your age is = " + edad + "years");

        } else {
            d.setCurrent(new Alert("", "Another command", null, AlertType.ERROR));
        }
    }
}
