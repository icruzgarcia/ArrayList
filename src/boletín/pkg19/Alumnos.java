package boletín.pkg19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Alumnos implements Comparable {

//Variables privadas por norma general, nota y nombre de alumnos
    private int nota = 0;
    private String nombre = "";

//Constructor vacio
    public Alumnos() {
    }

//Constructor con parametros
    public Alumnos(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

//Obtiene la nota
    public int getNota() {
        return nota;
    }

//Introduce la nota
    public void setNota(int nota) {
        this.nota = nota;
    }

//Obtiene el nombre
    public String getNombre() {
        return nombre;
    }

//Introduce el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return cadena, que devolvera el nombre y la nota. Sobrescribimos el
     * método ToString para que salga una cadena de strings (que seran la nota y
     * el nombre) por pantalla con el .get(); en vez de buscar nombre y nota por
     * separado
     */
//Probamos un toString para devolver una cadena en vez de pedir los valores 1 por 1
    public String toString() {
        String cadena = (nombre + " tiene un " + nota);
        return cadena;
    }
/**
 * 
 * @param introducir ArrayList de tipo Alumnos para comenzar la creacion de la lista
 */
//Creaos la lista del array mediante condicionantes IF y DO. .WHILE
    public void creaLista(ArrayList<Alumnos> introducir) {
        String aux = "";
        int nota = 0;
        do {
            aux = JOptionPane.showInputDialog("Introduce el nombre del alumno");
            if (aux.compareToIgnoreCase("fin") == 0) {
                break;
            }
            do {
                nota = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota entre 0 y 10"));
            } while (nota < 0 || nota > 10);
            introducir.add(new Alumnos(aux, nota));
        } while (aux.compareToIgnoreCase("fin") != 0);
    }
/**
 * 
 * @param ver ArrayList de tipo Alumnos para poder visualizar la lista con un bucle FOR
 */
//Probamos a visualizar con un bucle FOR
    public void verFor(ArrayList<Alumnos> ver) {
        System.out.println("Estamos viendo un For");
        for (int i = 0; i < ver.size(); i++) {
            System.out.println(ver.get(i));

        }
    }
/**
 * 
 * @param ver ArrayList de tipo Alumnos para poder visualizar la lista con un bucle FOR EACH
 */
//Probamos a visualizar con un bucle FOR. .EACH
    public void verEach(ArrayList<Alumnos> ver) {
        System.out.println("Estamos viendo un For Each");
        for (Alumnos i : ver) {
            System.out.println(i);
        }
    }
/**
 * 
 * @param ver ArrayList de tipo Alumnos para poder visualizar la lista con un bucle Iterator
 */
//Probamos a visualizar con un ITERATOR
    public void verItinerante(ArrayList<Alumnos> ver) {
        System.out.println("Estamos viendo un Iterator");
        Iterator<Alumnos> iterador = ver.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());

        }
    }
/**
 * 
 * @param buscar ArrayLIst de tipo Alumnos para poder buscar un alumno dependiendo de su nota.
 */
//Visualizamos un ALUMNO en concreto con su NOTA
    public void buscar(ArrayList<Alumnos> buscar) {
        int cont = 0;
        String aux = JOptionPane.showInputDialog("Introduce el nombre del alumno que buscas");
        for (Alumnos bus : buscar) {
            if (bus.getNombre().equalsIgnoreCase(aux)) {//Buscamos el ALUMNO mediante un EQUALS
                JOptionPane.showMessageDialog(null, bus);
                cont += 1;
            }
        }
        if (cont == 0) {
            JOptionPane.showMessageDialog(null, "No hay alumnos con ese nombre");
        }
    }
    /**
     * 
     * @param alta ArrayList de tipo Alumnos para buscar al alumno al que inscribir o dar de alta 
     */
    //Damos de alta a un nuevo ALUMNO con una nueva NOTA   
    public void alta(ArrayList<Alumnos> alta) {
        String aux = "";
        int nota = 0;
        int condi = 0;
        do {
            aux = JOptionPane.showInputDialog("Introduce el nombre del nuevo alumno");
            nota = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota del nuevo alumno"));
            alta.add(new Alumnos(aux, nota));
            condi = JOptionPane.showConfirmDialog(null, "¿Quieres introducir otro alumno?");
        } while (condi != 1);
    }
/**
 * 
 * @param baja ArrayList de tipo Alumnos para buscar al alumno al que dar de baja.
 */
    //Damos de baja a un ALUMNO
    public void baja(ArrayList<Alumnos> baja) {
        String aux = "";
        aux = JOptionPane.showInputDialog("Introduce el nombre del alumno a dar de baja");
        for (int i = 0; i < baja.size(); i++) {
            if (baja.get(i).getNombre().equalsIgnoreCase(aux)) {
                baja.remove(i);
            }
        }
    }
/**
 * 
 * @param orden ArrayList de tipo Alumnos que permitira ordenar con Collections.sort();
 */
    //Ordenamos la lista de ALUMNOS por NOMBRE
//Sorting using Anonymous inner class type
    public void orden(ArrayList<Alumnos> orden) {
        Collections.sort(orden);
    }
/**
 * 
 * @param i un Objeto general que transformaremos a tipo Alumnos
 * @return 0,1 o -1 dependiendo de la salida del bloque de IF
 */
    @Override
    public int compareTo(Object i) {
        Alumnos alumno = (Alumnos) i;
        if (this.nombre.compareToIgnoreCase(alumno.nombre) == 0) {
            return 0;
        } else if (this.nombre.compareToIgnoreCase(alumno.nombre) < 0) {
            return -1;
        } else {
            return 1;
        }

    }
}
