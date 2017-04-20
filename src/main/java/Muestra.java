import java.util.*;
import java.lang.*;

/**
 * Paula Alemany
 */
public class Muestra {
    /*Atributos*/
    private int id_muestra;
    private static int contador = 1;
    private ArrayList<Encuesta_Respondida> lista_respuestas = new ArrayList();
    private Encuesta encuesta;

    /**
     * Creadora
     */

    public Muestra (Encuesta e){
        this.setId_muestra();
        this.lista_respuestas = e.getLl_encuestas_respondidas();
        /*System.out.println("Introduce el nombre de la encuesta que se quiere para la muestra:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.next();*/
    }

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


    public String consultar_nombre_encuesta(){
        return this.encuesta.getName();
    }

    public ArrayList<Encuesta_Respondida> get_lista_respuesta(){
        return this.lista_respuestas;
    }

    public void set_lista_respuestas(ArrayList<Encuesta_Respondida> EncuestasRespondidas){
        this.lista_respuestas = EncuestasRespondidas;
    }


    public int getId_muestra() {
        return id_muestra;
    }

    public void setId_muestra() {
        this.id_muestra = contador++;
    }

    public ArrayList<Encuesta_Respondida> getLista_respuestas() {
        return lista_respuestas;
    }

    public void setLista_respuestas(ArrayList<Encuesta_Respondida> lista_respuestas) {
        this.lista_respuestas = lista_respuestas;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}