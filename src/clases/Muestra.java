package clases;
import java.util.*;
import java.lang.*;
import
/**
 * Paula Alemany
 */
public class Muestra {
    /*Atributos*/
    private int id_muestra;
    private static int contador = 1;
    private ArrayList<Encuesta_Respondida> lista_respuestas = new ArrayList();
    private Encuesta encuesta;

    public Muestra(Encuesta e) {
        this.encuesta = e;
        encuesta
        this.id_muestra = contador++;
    }

    public String consultar_nom_encuesta(int id){
        return lista_respuestas.get(id).getName(); //cal accedir al nom de l'enquesta que responc
    }

    public ArrayList<Encuesta_Respondida> get_lista_respuesta(){
        return this.lista_respuestas;
    }

    public void set_lista_respuestas(ArrayList<Encuesta_Respondida> EncuestasRespondidas){
        this.lista_respuestas = EncuestasRespondidas;
    }

}