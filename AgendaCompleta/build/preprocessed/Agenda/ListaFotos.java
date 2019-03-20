package Agenda;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Image;

public class ListaFotos extends List implements CommandListener {

    Command ok;
    AgendaME p;

    public ListaFotos(AgendaME mid) {
        super("Galeria", Choice.EXCLUSIVE);
        p = mid;
        ok = new Command("OK", Command.OK, 1);
        addCommand(ok);
        setCommandListener(this);
        try {
            append("Foto 1", Image.createImage("Resources/1.jpg"));
            append("Foto 2", Image.createImage("Resources/2.jpg"));
            append("Foto 3", Image.createImage("Resources/3.jpg"));
            append("Foto 4", Image.createImage("Resources/4.png"));
            append("Foto 5", Image.createImage("Resources/5.png"));
            append("Foto 6", Image.createImage("Resources/6.jpg"));
            append("Foto 7", Image.createImage("Resources/7.jpg"));
            append("Foto 8", Image.createImage("Resources/8.png"));
            append("Foto 9", Image.createImage("Resources/9.png"));
            append("Foto 10", Image.createImage("Resources/10.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commandAction(Command cg, Displayable d) {
        if (cg == ok) {
            String img = "";
            int imagen = getSelectedIndex();
            switch (imagen) {
                case 0:
                    img = "Resources/1.jpg";
                    break;
                case 1:
                    img = "Resources/2.jpg";
                    break;
                case 2:
                    img = "Resources/3.jpg";
                    break;
                case 3:
                    img = "Resources/4.png";
                    break;
                case 4:
                    img = "Resources/5.png";
                    break;
                case 5:
                    img = "Resources/6.jpg";
                    break;
                case 6:
                    img = "Resources/7.jpg";
                    break;
                case 7:
                    img = "Resources/8.png";
                    break;
                case 8:
                    img = "Resources/9.png";
                    break;
                case 9:
                    img = "Resources/10.jpg";
                    break;
                default:
                    img = "Resources/5.png";
                    break;
            }
            p.f.foto = img;
            p.d.setCurrent(p.f);
        }
    }
}
