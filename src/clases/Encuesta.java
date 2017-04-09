package clases;

import java.util.*;

/**
 *   Clase Encuesta
 */
public class Encuesta {

    private int id;
    private String name;
    private Date data_creacio;
    private ArrayList<Pregunta>;

    public Encuesta(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData_creacio() {
        return data_creacio;
    }

    public void setData_creacio(Date data_creacio) {
        this.data_creacio = data_creacio;
    }
}