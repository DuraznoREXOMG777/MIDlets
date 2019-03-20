/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAgenda;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class Registros {

    private RecordStore rs;

    public Registros() {

    }

    public boolean abrir(String zona) {
        try {
            rs = RecordStore.openRecordStore(zona, true);
            return true;
        } catch (RecordStoreException rse) {
            rse.toString();
            return false;
        }
    }

    public boolean alta(String s) {
        byte[] m;
        m = s.getBytes();
        try {
            rs.addRecord(m, 0, m.length);
            return true;
        } catch (RecordStoreException rse) {
            rse.toString();
            return false;
        }
    }

    public String[] consulta(int n) {
        byte[] r = new byte[100];
        ByteArrayInputStream bais;
        DataInputStream dis;
        String[] datos = new String[4];
        try {
            bais = new ByteArrayInputStream(r);
            dis = new DataInputStream(bais);
            datos[0] = dis.readUTF();
            datos[1] = dis.readUTF();
            datos[2] = dis.readUTF();
            datos[3] = dis.readUTF();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return datos;
    }

    public String[] cargarDatos() {
        String[] datos = null;
        try {
            datos = new String[rs.getNumRecords()];
            byte[] recData = new byte[rs.getNumRecords()];
            int len;
            for (int i = 0; i < rs.getNumRecords(); i++) {
                if (rs.getRecordSize(i) > recData.length) {
                    recData = new byte[rs.getRecordSize(i)];
                }
                len = rs.getRecord(i, recData, 0);
                datos[i] = new String(recData, 0, len);
            }

        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    public String[] readRecords() {
        String datos[] = null;
        try {
            byte[] recData = new byte[rs.getNumRecords()];
            datos = new String[rs.getNumRecords()];
            int len;

            for (int i = 1; i <= rs.getNumRecords(); i++) {
                // Re-allocate if necessary
                if (rs.getRecordSize(i) > recData.length) {
                    recData = new byte[rs.getRecordSize(i)];
                }

                len = rs.getRecord(i, recData, 0);
                datos[i-1] = new String(recData, 0, len);
                
            }
        } catch (Exception e) {
            db(e.toString());
        }
        return datos;
    }

    public boolean fin() {
        try {
            rs.closeRecordStore();
            return true;
        } catch (RecordStoreException rse) {
            return false;
        }
    }

    private void db(String str) {
        System.err.println("Msg: " + str);
    }
    
    public int getRecordNumber(){
        try {
            return rs.getNumRecords();
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
