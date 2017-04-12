package clases;
import java.util.*;
import java.lang.*;
import
/**
 * Paula Alemany
 */
public class Muestra {


    private int id_muestra;
    private ArrayList<Encuesta_Respondida> lista_respuestas = new ArrayList();
    private Encuesta encuesta;
    /*
     * Default constructor
     */
    public Muestra() {

    }

    public String consultar_nom_encuesta(int id){
        return lista_respuestas.get(id).getName(); //cal accedir al nom de l'enquesta que responc
    }

    public ArrayList<Encuesta_Respondida> get_lista_respuesta(){
        return lista_respuestas;
    }

    public void set_lista_respuestas(ArrayList<Encuesta_Respondida> EncuestasRespondidas){
        this.lista_respuestas = EncuestasRespondidas;
    }

}