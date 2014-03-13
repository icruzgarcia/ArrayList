package boletín.pkg19;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author icruzgarcia
 * @since Version 1.7.4 13/03/2014
 */
public class Boletín19 {

    public static void main(String[] args) {
        ArrayList<Alumnos> clase = new <Alumnos>ArrayList();
        Alumnos prueba = new Alumnos();
        prueba.creaLista(clase);
        prueba.verFor(clase);
        prueba.verEach(clase);
        prueba.verItinerante(clase);
        prueba.buscar(clase);
        prueba.alta(clase);
        System.out.println("##################");
        prueba.verFor(clase);
        prueba.baja(clase);
        System.out.println("##################");
        prueba.verFor(clase);
        prueba.orden(clase);
        System.out.println("##################");
        prueba.verFor(clase);

    }
}
