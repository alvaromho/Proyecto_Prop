package clases;

import java.io.IOException;
import java.util.*;

/**
 *   Clase Encuesta
 */


public class Encuesta {

    private int id;
    private String name;
    private Calendar creation_date;
    private ArrayList<Pregunta> ll_preguntes;

    private static int id_count = 1;


    public Encuesta() throws IOException {
        this.id = id_count;
        ++id_count;
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.next();
        this.creation_date = Calendar.getInstance();
        int n = System.in.read();
        for (int i = 0; i < n; ++i) {
            //------------------------------------------------------------
        }
    }

    public Encuesta(String name, Calendar data,  ArrayList<Pregunta> llpreguntes) {
        this.id = id_count;
        ++id_count;
        this.name = name;
        this.creation_date = data;
        this.ll_preguntes = llpreguntes;
    }

    public int getId() {    //GetterId
        return id;
    }

    public String getName() {   //GetterName
        return name;
    }

    public void setName(String name) {  //SetterName
        this.name = name;
    }

    public Calendar getCreation_date() {    //GetCreation
        return creation_date;
    }

    public void setCreation_date(Calendar creation_date) {  //SetterCreation
        this.creation_date = creation_date;
    }

    public ArrayList<Pregunta> getLlista_preguntes() {
        return ll_preguntes;
    }

    public void setLlista_preguntes(ArrayList<Pregunta> llpreguntes) {
        this.ll_preguntes = llpreguntes;
    }


    public boolean eliminar_pregunta(Pregunta pregunta) {
    //Elimina una pregunta de la encuesta, devuelve true si la elimina, falso si no contiene la pregunta.
        return  ll_preguntes.remove(pregunta);
    }

    public void añadir_pregunta_pos(int pos, Pregunta pregunta) {
    //Añade una pregunta al final de la encuesta.
        ll_preguntes.add(pos, pregunta);
    }

    public boolean añadir_pregunta_final(Pregunta pregunta) {
    //Añade una pregunta al final de la encuesta, devuelve true si la añade, false si ya existia.
        return ll_preguntes.add(pregunta);
    }

    public boolean modificar_pregunta(Pregunta pregunta_old, Pregunta pregunta_new){
    //Se reemplaza una pregunta por otra, devuelve true si la pregunta_old se encuera en ll_preguntes, false en caso contrario
        int index = ll_preguntes.indexOf(pregunta_old);
        if (index == -1) return false;
        ll_preguntes.remove(index);
        ll_preguntes.add(index, pregunta_new);
        return true;
    }

    public void modificar_pregunta_indice(int index, Pregunta pregunta_new){
        //Se reemplaza una pregunta por otra, devuelve true si se ejecuta correctamente, false en caso contrario
        ll_preguntes.remove(index);
        ll_preguntes.add(index, pregunta_new);
    }


}