
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Screen;
import javax.microedition.midlet.MIDlet;

public class Midlet
        extends MIDlet
        implements CommandListener, DiscoveryListener {

    private Display display;
    private Command conectar;
    private Command desconectar;
    private Command ok;
    private Command comenzar;
    private Form bienvenida;
    private List comandos;
    private StreamConnection con;
    private OutputStream outs;
    private InputStream ins;
    private LocalDevice localDevice = null;
    private DiscoveryAgent discoveryAgent = null;
    private ServiceRecord[] serviciosEncontrados = null;
    private String URL = "btspp://00066606BB9D:1;authenticate=false;encrypt=false;master=false";

    public void startApp() {
        this.display = Display.getDisplay(this);
        this.conectar = new Command("Conectar", 8, 1);
        this.desconectar = new Command("Desconectar", 8, 1);
        this.ok = new Command("OK", 4, 1);
        this.comenzar = new Command("Comenzar", 4, 1);

        this.bienvenida = new Form("Bienvenido");
        this.comandos = new List("Escoja una accion", 1);

        this.bienvenida.addCommand(this.comenzar);
        this.bienvenida.setCommandListener(this);

        this.comandos.addCommand(this.ok);
        this.comandos.addCommand(this.conectar);
        this.comandos.addCommand(this.desconectar);
        this.comandos.append("Encender LED", null);
        this.comandos.append("Apagar LED", null);
        this.comandos.setCommandListener(this);

        this.display.setCurrent(this.bienvenida);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == this.comenzar) {
            comenzar();
        } else if (c == this.conectar) {
            conectar();
        } else if (c == this.desconectar) {
            desconectar();
        } else if (c == this.ok) {
            enviar();
        }
    }

    public void deviceDiscovered(RemoteDevice remoteDevice, DeviceClass deviceClass) {
    }

    public void inquiryCompleted(int discType) {
    }

    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
    }

    public void serviceSearchCompleted(int transID, int respCode) {
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private void comenzar() {
        try {
            this.localDevice = LocalDevice.getLocalDevice();
            this.localDevice.setDiscoverable(10390323);
            Display.getDisplay(this).setCurrent(this.comandos);
        } catch (BluetoothStateException e) {
            e.printStackTrace();
            Alert alerta = new Alert("Error", "No se puede hacer uso de Bluetooth", null, AlertType.ERROR);
            alerta.setTimeout(-2);
            Display.getDisplay(this).setCurrent(alerta);
        }
    }

    private void conectar() {
        try {
            this.con = ((StreamConnection) Connector.open(this.URL));
            this.outs = this.con.openOutputStream();
            this.ins = this.con.openInputStream();
        } catch (IOException e) {
            mostrarAlarma(e, this.comandos, 3);
        }
    }

    private void desconectar() {
        try {
            this.ins.close();
            this.outs.close();
            this.con.close();
        } catch (IOException e) {
            mostrarAlarma(e, this.comandos, 4);
        }
    }

    private void enviar() {
        int i = this.comandos.getSelectedIndex();
        String comando_elegido = this.comandos.getString(i);
        if (comando_elegido == "Encender LED") {
            String greeting = "H";
            try {
                this.outs.write(greeting.getBytes());
                mostrarAlarma(null, this.comandos, 5);
            } catch (IOException e) {
                mostrarAlarma(e, this.comandos, 2);
            }
        } else {
            String greeting = "L";
            try {
                this.outs.write(greeting.getBytes());
                mostrarAlarma(null, this.comandos, 5);
            } catch (IOException e) {
                mostrarAlarma(e, this.comandos, 2);
            }
        }
    }

    public void mostrarAlarma(Exception e, Screen s, int tipo) {
        Alert alerta = null;
        if (tipo == 0) {
            alerta = new Alert("Excepcion", "Se ha producido la excepcion " + e.getClass().getName(), null, AlertType.ERROR);
        } else if (tipo == 1) {
            alerta = new Alert("Info", "Se completo la busqueda de servicios", null, AlertType.INFO);
        } else if (tipo == 2) {
            alerta = new Alert("ERROR", "No se pudo enviar", null, AlertType.ERROR);
        } else if (tipo == 3) {
            alerta = new Alert("ERROR", "No se pudo establecer conexion" + e.getClass().getName(), null, AlertType.ERROR);
        } else if (tipo == 4) {
            alerta = new Alert("ERROR", "No se pudo desconectar", null, AlertType.INFO);
        } else if (tipo == 5) {
            alerta = new Alert("INFO", "Se envio el comando", null, AlertType.INFO);
        }
        alerta.setTimeout(-2);
        this.display.setCurrent(alerta, s);
    }
}
