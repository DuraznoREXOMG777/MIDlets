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
public class Utilidad {

    public static String getColumnAt(String csv, int column) {
        int fromIndex = 0;
        int col = 0;
        while (col < column) {
            fromIndex = csv.indexOf(",", fromIndex) + 1;
            col++;
        }
        int toIndex = csv.indexOf(",", fromIndex);
        return csv.substring(fromIndex, toIndex);
    }
    
}
