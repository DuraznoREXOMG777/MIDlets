package Agenda;

import java.io.*;
import javax.microedition.lcdui.*;

public class Forma extends Form implements CommandListener {

    Command g, s, lista, select;
    TextField nom, ape, tel, cel, dom;
    AgendaME p;
    Alert a;
    String foto;

    public Forma(AgendaME mid) {
        super("AgendaME");
        p = mid;
        foto = "Resources/0.png";
        nom = new TextField("Nombre:", "", 30, TextField.ANY);
        ape = new TextField("Apellido:", "", 30, TextField.ANY);
        tel = new TextField("Telefono:", "", 30, TextField.ANY);
        cel = new TextField("Celular:", "", 30, TextField.ANY);
        dom = new TextField("Domicilio:", "", 30, TextField.ANY);
        s = new Command("Salir", Command.EXIT, 1);
        g = new Command("Guardar", Command.EXIT, 1);
        lista = new Command("Contactos", Command.EXIT, 1);
        select = new Command("Seleccionar Foto", Command.EXIT, 1);
        append(nom);
        append(ape);
        append(tel);
        append(cel);
        append(dom);
        addCommand(g);
        addCommand(s);
        addCommand(lista);
        addCommand(select);
        setCommandListener(this);
    }

    public void commandAction(Command co, Displayable di) {
        if (co == s) {
            p.destroyApp(true);
        } else if (co == g) {
            RMSOps rmso = new RMSOps();
            rmso.abrir("AgendaME");
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                System.out.println();
                dos.writeUTF(foto);
                dos.writeUTF(nom.getString());
                dos.writeUTF(ape.getString());
                dos.writeUTF(tel.getString());
                dos.writeUTF(cel.getString());
                dos.writeUTF(dom.getString());
                System.out.println(foto+", "+ nom.getString()+", "+ape.getString()+", "+tel.getString()+", "+cel.getString()+", "+dom.getString());
                Image img = Image.createImage(foto);
                dos.close();
                rmso.adicionarRegistro(baos);
                rmso.cerrar();
            } catch (Exception ioe) {
                ioe.printStackTrace();
            }
            a = new Alert("NOTA", "Guardado", null, AlertType.CONFIRMATION);
            a.setTimeout(5000);
//            p.d.setCurrent(a, this);
//            p.lc.constructList();
//            p.d.setCurrent(p.lc);
            nom.setString("");
            ape.setString("");
            tel.setString("");
            cel.setString("");
            dom.setString("");
        } else if (co == lista) {
            p.lc.constructList();
            p.d.setCurrent(p.lc);
        } else if (co == select) {
            p.d.setCurrent(p.lf);
        }
    }

}
