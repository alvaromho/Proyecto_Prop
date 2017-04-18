package clases;
import java.lang.reflect.Array;
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


    public Muestra (){
        /*this.id_muestra = contador;
        ++contador;
        System.out.println("Introduce el nombre de la encuesta que se quiere para la muestra: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.next();
        Encuesta_Respondida er = new Encuesta_Respondida();
        while(nombre == er.get(cont_id).getEncuesta.getName()){ //mirar quin és el ultim id dencuesta respondida
            this.lista_respuestas.add(Encuesta_Respondida);
            ++cont_id;
        }*/

    }

    public Muestra(Encuesta e, ArrayList<Encuesta_Respondida> lista_encuestas_respondida ) {
        this.setId_muestra();
        this.encuesta = e;
        this.lista_respuestas = lista_encuestas_respondida;
        /*
        int cont_id = 1;
        this.encuesta = e;
       Encuesta_Respondida er = new Encuesta_Respondida();
        while(encuesta.getName() == er.get(cont_id).getEncuesta.getName()){ //mirar quin és el ultim id dencuesta respondida
            this.lista_respuestas.add(er);
            ++cont_id;
        }
        */
        //añadir opciones de filtro+
    }

    public Muestra(Encuesta e, ArrayList<Encuesta_Respondida> lista_encuestas_respondida, Pregunta pregunta, Object valor){
/*TODO
 public void añadir_respuesta_interactivo(Pregunta p){
 FOR(tipolista variableauxiliar : lalista){}
        System.out.println(p.getEnunciado());
        if (p instanceof P_Gradual) {
            System.out.println("Gradual");
            R_Gradual rg = new R_Gradual((P_Gradual) p);
            this.ll_respuesta.add(rg);
        }
        else if (p instanceof P_Multiopcion) {
            System.out.println("MultiOpcion");
            R_Multiopcion rm = new R_Multiopcion((P_Multiopcion) p);
            this.ll_respuesta.add(rm);
        }
        else if (p instanceof P_Numerico) {
            System.out.println("Numerico");
            R_Numerico rn = new R_Numerico((P_Numerico) p);
            this.ll_respuesta.add(rn);
        }
        else if (p instanceof P_Texto) {
            System.out.println("Texto");
            R_Texto rt = new R_Texto((P_Texto) p);
            this.ll_respuesta.add(rt);
        }
        else System.out.println("Normal");
        System.out.println(p.getEnunciado());
    }
 */
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