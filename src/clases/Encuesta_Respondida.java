package clases;
import java.util.*;

/**
 * 
 */
public class Encuesta_Respondida {


    private int id;
    private String nombre;
    private Calendar creation_date;
    private ArrayList<Respuesta> ll_respuesta;

    private int id_count = 1;

    public Encuesta_Respondida() {
    }

    public Encuesta_Respondida(String nombre, Calendar creation_date, ArrayList<Respuesta> ll_respuesta) {
        this.id = id_count;
        ++id_count;
        this.nombre = nombre;
        this.creation_date = creation_date;
        this.ll_respuesta = ll_respuesta;
    }

    public int getId() {    //Getter id
        return id;
    }

    public void setId(int id) {     //Setter id
        this.id = id;
    }

    public String getNombre() {     //Getter Nombre
        return nombre;
    }

    public void setNombre(String nombre) {      //Setter Nombre
        this.nombre = nombre;
    }

    public Calendar getDate() {     //Getter Date
        return creation_date;
    }

    public void setDate(Calendar date) {        //Setter Date
        this.creation_date = date;
    }

    public ArrayList<Respuesta> getLl_respuesta() {     //Getter ll_respuesta
        return ll_respuesta;
    }

    public void setLl_respuesta(ArrayList<Respuesta> ll_respuesta) {        //Setter ll_respuesta
        this.ll_respuesta = ll_respuesta;
    }

    public void modificar_respuesta(int index, Respuesta respuesta_new) {
    //Se modifica la respuesta situada en la posicio index por respuesta_new.
        ll_respuesta.remove(index);
        ll_respuesta.add(index, respuesta_new);

    }


}




