/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAgenda;

/**
 *
 * @author Durazno
 */
public class Contacto {

    String nombre, correo;
    int sexo, edad;

    public Contacto(String nombre, String correo, int sexo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
        this.edad = edad;
    }

    public Contacto(String contact) {
        nombre = Utilidad.getColumnAt(contact, 0);
        edad = Integer.parseInt(Utilidad.getColumnAt(contact, 1));
        correo = Utilidad.getColumnAt(contact, 2);
        sexo = Integer.parseInt(Utilidad.getColumnAt(contact, 3));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
