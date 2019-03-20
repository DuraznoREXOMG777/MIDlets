package EjercicioAgenda;

import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class AgendaME extends MIDlet implements CommandListener {

    Command c;
    Command ventanaVer, ventanaNuevo, ventanaInicio, ventanaLista, guardar;
    Display d;
    Form f, ingresar;
    List lista;
    String sel, contacto[];
    TextField nombre, edad, email;
    Image img;
    ImageItem imgI;
    DateField df;
    ChoiceGroup cg;
    Registros r;
    int i, j;

    String leerContactos[];
    String nombres[], correos[];
    int edades[], sexo[];

    public AgendaME() {
        i = 0;
        d = Display.getDisplay(this);
        c = new Command("Salir", Command.EXIT, 3);

        r = new Registros();
        r.abrir("Agenda");
        leerContactos = r.readRecords();
        
        for (int k = 0; k < leerContactos.length; k++) {
            System.out.println(leerContactos[k]);
            
        }
        Contacto[] ccs = new Contacto[leerContactos.length];
        
        for (int k = 0; k < ccs.length; k++) {
            ccs[k] = new Contacto(leerContactos[k]);            
        }

        ventanaNuevo = new Command("Nvo contacto", Command.SCREEN, 2);
        guardar = new Command("Guardar", Command.SCREEN, 2);
        ventanaInicio = new Command("Regresar", Command.SCREEN, 3);
        ventanaVer = new Command("Ver", Command.OK, 0);
        ventanaLista = new Command("Mi agenda", Command.SCREEN, 0);

        try {
            img = Image.createImage("/java.jpg");
        } catch (IOException ioe) {
            System.err.println("Error" + ioe);
        }

        imgI = new ImageItem("HOLA", img, 1, "hola");

        f = new Form("Mi Agenda");
        ingresar = new Form("Nuevo contacto");
        contacto = new String[5];

        for (j = 0; j < 5; j++) {
            contacto[j] = "";
        }

        df = new DateField("creado", DateField.DATE_TIME);
        String sexo[] = {"Hombre", "Mujer"};

        cg = new ChoiceGroup("", List.EXCLUSIVE, sexo, null);
        nombre = new TextField("Nombre", "", 30, TextField.ANY);
        edad = new TextField("Edad", "", 30, TextField.NUMERIC);
        email = new TextField("E-mail", "", 30, TextField.EMAILADDR);

        ingresar.addCommand(ventanaInicio);
        ingresar.addCommand(guardar);
        ingresar.append(nombre);
        ingresar.append(edad);
        ingresar.append(email);
        ingresar.append(cg);
        ingresar.setCommandListener(this);

        f.addCommand(ventanaLista);
        f.addCommand(c);
        f.addCommand(ventanaNuevo);

        f.setCommandListener(this);
    }

    protected void destroyApp(boolean b) {
    }

    protected void pauseApp() {
    }

    protected void startApp() throws MIDletStateChangeException {
        d.setCurrent(f);
    }

    public void commandAction(Command co, Displayable disp) {
        if (co == ventanaNuevo) {
            d.setCurrent(ingresar);
        }
        if (co == ventanaLista) {
            d.setCurrent(lista);
        }
        if (co == guardar) {

            //RecordStore
            String alta = nombre.getString() + "," + edad.getString() + "," + email.getString() + "," + cg.getSelectedIndex();
            if (r.alta(alta)) {
                d.setCurrent(new Alert("Correcto", "Se ha ingresado correctamente a la lista", null, AlertType.CONFIRMATION));
            }
            r.readRecords();

            contacto[i] = nombre.getString();
            lista = new List("Contactos", List.IMPLICIT, contacto, null);
            lista.addCommand(c);
            lista.addCommand(ventanaNuevo);
            lista.addCommand(ventanaVer);
            lista.setCommandListener(this);
            Alert alerta = new Alert("", "contacto guardado", img, AlertType.INFO);
            d.setCurrent(alerta);
            alerta.setTimeout(2000);
            i++;
        }
        if (co == ventanaInicio) {
            if (cg.getSelectedIndex() == 0) {
                sel = "Hombre";
            } else {
                sel = "Mujer";
            }
            StringItem si = new StringItem("", "Nombre: " + nombre.getString() + "\nEdad: " + edad.getString() + "\nE-mail: " + email.getString() + "\n" + "Sexo: " + sel + "\n");
            f.append(si);
            d.setCurrent(lista);
        }
        if (co == ventanaVer) {
            System.out.println("OPCION" + lista.getSelectedIndex());
            d.setCurrent(f);
        }
        if (co == c) {
            destroyApp(false);
            notifyDestroyed();
            r.fin();
        }
    }
}
