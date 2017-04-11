package clases;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Encuesta_Respondida {


    private int id;
    private Encuesta encuesta;
    private String name;
    private Calendar creation_date;
    private ArrayList<Respuesta> ll_respuesta = new ArrayList<>();

    private static int id_count = 1;

    public Encuesta_Respondida(Encuesta e) {
        //Se crea una Encuesta_Respondida interactivamente
        Scanner scanner = new Scanner(System.in);
        this.encuesta = e;
        this.id = id_count;
        ++id_count;
        System.out.println("Introduce tu nombre:");
        this.name = scanner.next();
        this.creation_date = Calendar.getInstance();

    }

    public Encuesta_Respondida(String nombre, Calendar creation_date, ArrayList<Respuesta> ll_respuesta, int id_encuesta) {
        this.id = id_count;
        ++id_count;
        this.name = nombre;
        this.creation_date = creation_date;
        this.ll_respuesta = ll_respuesta;
    }

    public int getId() {    //Getter id
        return id;
    }

    public void setId(int id) {     //Setter id
        this.id = id;
    }

    public String getName() {     //Getter Nombre
        return name;
    }

    public void setName(String nombre) {      //Setter Nombre
        this.name = nombre;
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

    public void añadir_respuesta(Pregunta p){
        if (p instanceof P_Gradual) System.out.println("Gradual");
        else if (p instanceof P_Multiopcion) System.out.println("MultiOpcion");
        else if (p instanceof P_Numerico) System.out.println("Numerico");
        else if (p instanceof P_Texto) System.out.println("Texto");
        else System.out.println("Normal");



    }

    /*
    public void añadir_respuesta(P_Gradual p) {
        System.out.println("Gradual");
    }

    public void añadir_respuesta(P_Multiopcion p) {
        System.out.println("MultiOpcion");
    }

    public void añadir_respuesta(P_Numerico p) {
        System.out.println("Numerico");
    }

    public void añadir_respuesta(P_Texto p) {
        System.out.println("Texto");
    }*/


    public void modificar_respuesta(int index, Respuesta respuesta_new) {
    //Se modifica la respuesta situada en la posicio index por respuesta_new.
        ll_respuesta.set(index, respuesta_new);

    }


}




