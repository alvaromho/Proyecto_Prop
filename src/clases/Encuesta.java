package clases;

import java.util.*;

/**
 *   Clase Encuesta
 */


public class Encuesta {

    private int id;
    private String name;
    private Calendar creation_date;
    private Set<Pregunta> ll_preguntes;

    private static int id_count = 1;


    public Encuesta() {}

    public Encuesta(String name, Calendar data,  Set<Pregunta> llpreguntes) {
        this.name = name;
        this.id = id_count;
        ++id_count;
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

    public Set<Pregunta> getLlista_preguntes() {
        return ll_preguntes;
    }

    public void setLlista_preguntes(Set<Pregunta> llpreguntes) {
        this.ll_preguntes = llpreguntes;
    }


    public boolean eliminar_pregunta(Pregunta pregunta) {
    //Elimina una pregunta de la encuesta, devuelve true si la elimina, falso si no contiene la pregunta.
        boolean b =  ll_preguntes.remove(pregunta);
    }


    public boolean modificar_enunciado_pregunta(Pregunta pregunta_old, Pregunta pregunta_new) {
    //Reemplaza una pregunta por otra, devuelve true si la modifica, false en caso contrario.
    }


    public boolean añadir_pregunta(Pregunta pregunta) {
    //Añade una pregunta al final de la encuesta, devuelve true si la añade, false si ya existia.
        return ll_preguntes.add(pregunta);
    }

    public boolean modificar_pregunta(Pregunta pregunta_old, Pregunta pregunta_new){}





}