package clases;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.IOException;
import java.util.*;

/**
 *   Clase Encuesta
 */


public class Encuesta {

    private int id;
    private String name;
    private Calendar creation_date;
    private ArrayList<Pregunta> ll_preguntes = new ArrayList<>();
    private ArrayList<Encuesta_Respondida> ll_encuestas_respondidas = new ArrayList<>();

    private static int id_count = 1;


    public Encuesta() {
        this.id = id_count;
        ++id_count;
        System.out.println("Introduce un nombre para la encuesta:");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.next();
        this.creation_date = Calendar.getInstance();
        /*int n = System.in.read();
        for (int i = 0; i < n; ++i) {
    ¡
        }*/
        System.out.println("Introduce un numero para escoger el tipo de pregunta que quieres crear: ");
        System.out.println("1: Tipo Gradual");
        System.out.println("2: Tipo Multiopcion");
        System.out.println("3: Tipo Numerico");
        System.out.println("4: Tipo Texto(respuesta libre)");
        System.out.println("0: Fi");
        int tipus_pregunta = Integer.parseInt(scanner.next());
        while (tipus_pregunta != 0) {
            switch (tipus_pregunta) {
                case 1:
                    P_Gradual pg = new P_Gradual();
                    ll_preguntes.add(pg);
                  /*  p.id = p.id_count;
                    p.enunciado = scanner.next();
                    p.no_sabe = (System.in.read() == 1);
                    System.out.println("Inserta el nombre de opcions que vols tenir:");
                    int n = System.in.read();
                    for (int i = 0; i < n; ++i) {
                        String s = scanner.next();
                        p.enunciado_opcion.add(s);
                    } */

                    break;
                case 2:
                    P_Multiopcion pm = new P_Multiopcion();
                    ll_preguntes.add(pm);
                    break;

                case 3:
                    P_Numerico pn = new P_Numerico();
                    ll_preguntes.add(pn);
                    break;

                case 4:
                    P_Texto pt = new P_Texto();
                    ll_preguntes.add(pt);
                    break;
                default:
                    System.out.println("Opcio no vàlida");
            }
            System.out.println("Seguent Pregunta a introduir: ");
            tipus_pregunta = Integer.parseInt(scanner.next());
        }
    }

    public Encuesta(String name, Calendar data,  ArrayList<Pregunta> llpreguntes) {
        this.id = id_count;
        ++id_count;
        this.name = name;
        this.creation_date = data;
        this.ll_preguntes = llpreguntes;
    }

    public int getId() {    //GetterId
        return id;
    }

    public String getName() {   //GetterName
        return name;
    }

    public void setName(String name) {  //SetterName
        this.name = name;
    }

    public Calendar getCreation_date() {    //GetCreation
        return creation_date;
    }

    public void setCreation_date(Calendar creation_date) {  //SetterCreation
        this.creation_date = creation_date;
    }

    public ArrayList<Pregunta> getLlista_preguntes() {
        return ll_preguntes;
    }

    public void setLlista_preguntes(ArrayList<Pregunta> llpreguntes) {
        this.ll_preguntes = llpreguntes;
    }


    public boolean eliminar_pregunta(Pregunta pregunta) {
    //Elimina una pregunta de la encuesta, devuelve true si la elimina, falso si no contiene la pregunta.
        return  ll_preguntes.remove(pregunta);
    }

    public void añadir_pregunta_pos(int pos, Pregunta pregunta) {
    //Añade una pregunta al final de la encuesta.
        ll_preguntes.add(pos, pregunta);
    }

    public boolean añadir_pregunta_final(Pregunta pregunta) {
    //Añade una pregunta al final de la encuesta, devuelve true si la añade, false si ya existia.
        return ll_preguntes.add(pregunta);
    }

    public boolean modificar_pregunta(Pregunta pregunta_old, Pregunta pregunta_new){
    //Se reemplaza una pregunta por otra, devuelve true si la pregunta_old se encuera en ll_preguntes, false en caso contrario
        int index = ll_preguntes.indexOf(pregunta_old);
        if (index == -1) return false;
        ll_preguntes.set(index, pregunta_new);
        return true;
    }

    public void modificar_pregunta_indice(int index, Pregunta pregunta_new){
        //Se reemplaza una pregunta por otra, devuelve true si se ejecuta correctamente, false en caso contrario
        ll_preguntes.set(index, pregunta_new);
    }

    public Pregunta ll_preguntes(int id_encuesta) {
        //Retorna el ll_preguntes donat un id_encuesta
        return ll_preguntes.get(id_encuesta);
    }

    public void responder(){
        Encuesta_Respondida er = new Encuesta_Respondida(this);
        for (Pregunta p : ll_preguntes) {
            er.añadir_respuesta(p);
        }
        ll_encuestas_respondidas.add(er);
    }


}