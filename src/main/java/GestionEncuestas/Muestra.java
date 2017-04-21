package GestionEncuestas;

import GestionEncuestas.Encuesta;
import Preguntes.Pregunta;
import Respostes.Respuesta;

import java.util.*;
import java.lang.*;

/**
 * Paula Alemany i Vergé
 */

public class Muestra {
    /**
     * Atributos
     */
    private int id_muestra;
    private static int contador = 1;
    private ArrayList<Encuesta_Respondida> lista_respuestas = new ArrayList();
    private Encuesta encuesta;

    /**
     * Constructora, se crea a partir de pasar como parametro una encuesta que a partir de ella podremos obtener la lista de encuestas respondidas de esa misma encuesta.
     * @param e
     */
    public Muestra (Encuesta e){
        this.setId_muestra();
        this.lista_respuestas = e.getLl_encuestas_respondidas();
    }

    /**
     * Constructora, se crea a partir de una encuesta y una lista de encuestas respondidas de la cual sacaremos las que tengan el mimso nombre de encuesta.
     * @param e
     * @param lista_encuestas_respondida
     */
    public Muestra(Encuesta e, ArrayList<Encuesta_Respondida> lista_encuestas_respondida ) {
        this.setId_muestra();
        this.encuesta = e;
        for(Encuesta_Respondida er : lista_encuestas_respondida){
            if(encuesta.getName() == er.getName()){
                this.lista_respuestas.add(er);
            }
            else{
                System.out.println("Error! La encuesta respondida de la lista no coincide con la encuesta que queremos analizar.");
            }
        }
    }

    /**
     * Constructora con filtro, se crea a partir de una pregunta y el valor de su respuesta.
     * @param e
     * @param lista_encuestas_respondida
     * @param pregunta
     * @param valor
     */
    public Muestra(Encuesta e, ArrayList<Encuesta_Respondida> lista_encuestas_respondida, Pregunta pregunta, Object valor) {
        for (Encuesta_Respondida er : lista_encuestas_respondida){
            for (Respuesta r : er.getLl_respuesta()) {
                if (r.getPregunta() == pregunta) {
                    if (r.getValor() == valor) {
                        lista_respuestas.add(er);
                    }
                }
            }
        }
    }

    /**
     * Devuelve el nombre de la encuesta a la que corresponde la encuestas respondidas que tomamos como muestra
     * @return El nombre de la GestionEncuestas.Encuesta.
     */
    public String consultar_nombre_encuesta(){
        return this.encuesta.getName();
    }

    /**
     * Devuelve la lista de encuestas respondidas que tenemos en esta muestra.
     * @return lista de encuestas respondidas
     */
    public ArrayList<Encuesta_Respondida> get_lista_respuesta(){
        return this.lista_respuestas;
    }

    /**
     * Modifica la lista de respuestas que tenemos como atributo de la clase GestionEncuestas.Muestra por una que pasamos como parametro.
     * @param EncuestasRespondidas
     */
    public void set_lista_respuestas(ArrayList<Encuesta_Respondida> EncuestasRespondidas){
        this.lista_respuestas = EncuestasRespondidas;
    }

    /**
     * Devuelve el atributo id_muestra de esta clase.
     * @return id_muestra
     */
    public int getId_muestra() {
        return id_muestra;
    }

    /**
     * Modifica el valor del atributo id_muestra a partir de un contador que inicializamos a 1 y al assignar el valor al id automaticamente el valor del contador se incrementa.
     */
    public void setId_muestra() {
        this.id_muestra = contador++;
    }

    /**
     * Devuelve la encuesta que tenemos en esta clase.
     * @return GestionEncuestas.Encuesta
     */
    public Encuesta getEncuesta() {
        return encuesta;
    }

    /**
     * Modifica la encuesta que tenemos en esta clase a partir de otra clase que pasamos como parametro.
     * @param encuesta
     */
    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}