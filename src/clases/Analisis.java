package clases;

import java.io.File;

/**
 *  Clase responsable de realizar y manejar los analisis realisados sobre una muestra de encuestas respondidas
 */
public class Analisis {

    /**
     *  Atributos
     */
    private int id_analsis;              // ID Key
    private String nombre_analisis;      // Name
    private int tipo_analisis;           // Dice a que tipo de analisis correponde
    private File detalle_analisis;




    public Analisis() {
    }


    public Analisis(int id_analsis, String nombre_analisis, int tipo_analisis) {
        this.id_analsis = id_analsis;
        this.nombre_analisis = nombre_analisis;
        this.tipo_analisis = tipo_analisis;
    }


    public int getId_analsis() {
        return id_analsis;
    }

    public void setId_analsis(int id_analsis) {
        this.id_analsis = id_analsis;
    }

    public String getNombre_analisis() {
        return nombre_analisis;
    }

    public void setNombre_analisis(String nombre_analisis) {
        this.nombre_analisis = nombre_analisis;
    }

    public int getTipo_analisis() {
        return tipo_analisis;
    }

    public void setTipo_analisis(int tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
    }


}