package clases;
import java.util.*;

/**
 * 
 */
public class Encuesta_Respondida {



    public String nombre_encuesta_respondida;
    public String fecha_encuesta_respondida;
    public int[]  vector_encuesta_respondida;
    public int id_encuesta;


    public Encuesta_Respondida() {
    }

    public Encuesta_Respondida(String nombre_encuesta_respondida, String fecha_encuesta_respondida, int[] vector_encuesta_respondida, int id_encuesta) {
        this.nombre_encuesta_respondida = nombre_encuesta_respondida;
        this.fecha_encuesta_respondida = fecha_encuesta_respondida;
        this.vector_encuesta_respondida = vector_encuesta_respondida;
        this.id_encuesta = id_encuesta;
    }

    public String getNombre_encuesta_respondida() {
        return nombre_encuesta_respondida;
    }

    public void setNombre_encuesta_respondida(String nombre_encuesta_respondida) {
        this.nombre_encuesta_respondida = nombre_encuesta_respondida;
    }

    public String getFecha_encuesta_respondida() {
        return fecha_encuesta_respondida;
    }

    public void setFecha_encuesta_respondida(String fecha_encuesta_respondida) {
        this.fecha_encuesta_respondida = fecha_encuesta_respondida;
    }

    public int[] getVector_encuesta_respondida() {
        return vector_encuesta_respondida;
    }

    public void setVector_encuesta_respondida(int[] vector_encuesta_respondida) {
        this.vector_encuesta_respondida = vector_encuesta_respondida;
    }

    public int getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(int id_encuesta) {
        this.id_encuesta = id_encuesta;
    }
}