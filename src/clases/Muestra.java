package clases;
import java.util.*;
import java.lang.*;
import
/**
 * Paula Alemany
 */
public class Muestra {


    private int id_muestra;
    private ArrayList<Encuesta_Respondida> lista_respuestas;

    /*
     * Default constructor
     */
    public Muestra() {

    }

    public String consultar_nom_encuesta(int id){
        return lista_respuestas.get(id).getName();
        }
    }

    public ArrayList<Encuesta_Respondida> get_lista_respuesta(){

    }

    public void set_lista_respuesta(ArrayList<Encuesta_Respondida> EncuestasRespondida){

    }
    /**
     * 
     */



}
/*Iterator<Encuesta_Respondida> it1 = lista_respuestas.iterator();*/
        /*while(it1.hasnext()){
            Encuesta_Respondida er = it1.next();
            if(er.getId())*/