package clases;
import java.util.*;

/**
 * 
 */
public class Encuesta_Respondida {


    private int id_encuesta;
    private String nombre;
    private Calendar date;
    private int[]  llista_respuestas;



    public Encuesta_Respondida() {}

    public Encuesta_Respondida(String nombre, int[] llista_respuestas) {
        this.nombre = nombre;
        this.llista_respuestas = llista_respuestas;
    }

    public int getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(int id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int[] getLlista_respuestas() {
        return llista_respuestas;
    }

    public void setLlista_respuestas(int[] llista_respuestas) {
        this.llista_respuestas = llista_respuestas;
    }


}




