package Helloworld;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ChoiceGroupME extends MIDlet implements CommandListener {

    private Display d;
    private Form f;
    private TextField tf;
    private ChoiceGroup cg;
    private ChoiceGroup ch;
    private Command cs;

    public ChoiceGroupME() {
        d = Display.getDisplay(this);
        tf = new TextField("Name:", "", 10, TextField.ANY);
        cg = new ChoiceGroup("Gender:", ChoiceGroup.EXCLUSIVE);
        cg.append("Man", null);
        cg.append("Woman", null);
        ch = new ChoiceGroup("Languages", ChoiceGroup.MULTIPLE);
        ch.append("Java", null);
        ch.append("C++", null);
        ch.append("Prolog", null);
        ch.append("Other", null);
        f = new Form("ChoiceGroup");
        f.append(tf);
        f.append(cg);
        f.append(ch);
        cs = new Command("Exit", Command.EXIT, 3);
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
        } else {
            d.setCurrent(new Alert("", "Other command .. ", null,
                    AlertType.ERROR));
        }
    }
}
