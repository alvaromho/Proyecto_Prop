import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Pol Moya Betriu.
 */



public class    Encuesta {

    private int id;
    private String name;
    private Calendar creation_date;
    private ArrayList<Pregunta> ll_preguntes = new ArrayList<>();
    private ArrayList<Encuesta_Respondida> ll_encuestas_respondidas = new ArrayList<>();

    private static int id_count = 0;


    public Encuesta() {
        //Crea una encuesta interactivamente
        this.id = id_count;
        ++id_count;
        System.out.println("Introduce un nombre para la encuesta:");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.next();
        this.creation_date = Calendar.getInstance();
        System.out.println("Introduce un numero para escoger el tipo de pregunta que quieres crear: ");
        System.out.println("1: Tipo Gradual");
        System.out.println("2: Tipo Multiopcion");
        System.out.println("3: Tipo Numerico");
        System.out.println("4: Tipo Texto(respuesta libre)");
        System.out.println("5: Consultar encuesta");
        System.out.println("0: Fi");
        int tipus_pregunta = 0;
        try {
            tipus_pregunta = Integer.parseInt(scanner.next());
        } catch (NumberFormatException nfe) {
            System.out.println("Format incorrecte");
        }
        while (tipus_pregunta != 0) {
                switch (tipus_pregunta) {
                    case 1:
                        P_Gradual pg = new P_Gradual();
                        ll_preguntes.add(pg);
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
                        break;
                }
            System.out.println("Introduce un numero para escoger el tipo de pregunta que quieres crear: ");
            System.out.println("1: Tipo Gradual");
            System.out.println("2: Tipo Multiopcion");
            System.out.println("3: Tipo Numerico");
            System.out.println("4: Tipo Texto(respuesta libre)");
            System.out.println("5: Consultar encuesta");
            System.out.println("0: Fi");
            try {
                tipus_pregunta = Integer.parseInt(scanner.next());
            } catch (NumberFormatException nfe) {
                System.out.println("Format incorrecte");
            }
        }
    }

    public Encuesta(int id, String name, Calendar creation_date, ArrayList<Pregunta> ll_preguntes, ArrayList<Encuesta_Respondida> ll_encuestas_respondidas) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.ll_preguntes = ll_preguntes;
        this.ll_encuestas_respondidas = ll_encuestas_respondidas;
    }

    /*Parte de Importar Encuesta
    public Encuesta(String nom_ficher) throws IOException {
        //Dado un txt importa una encuesta
        FileReader fr = new FileReader(nom_ficher);
        BufferedReader bf = new BufferedReader(fr);
        this.id = id_count;
        ++id_count;
        System.out.println("Id:" + this.id);
        //Leemos el nombre de la encuesta
        //Scanner scanner = new Scanner(System.in);
        this.name = bf.readLine();
        this.creation_date = Calendar.getInstance();
        //Leemos el tipo de pregunta que se quiere crear
        int tipus_pregunta = Integer.parseInt(bf.readLine());
        while (tipus_pregunta != 0) {
            String enunciado = bf.readLine();
            ArrayList<String> opciones;
            switch (tipus_pregunta) {
                case 1:
                    opciones = new ArrayList<>();
                    int n = Integer.parseInt(bf.readLine());
                    for (int i = 0; i < n; ++i) {
                        opciones.add(bf.readLine());
                    }
                    P_Gradual pg = new P_Gradual(enunciado, opciones);
                    ll_preguntes.add(pg);
                    break;
                case 2:
                    opciones = new ArrayList<>();
                    //Leemos el numero de opciones
                    int m = Integer.parseInt(bf.readLine());
                    for (int i = 0; i < m; ++i) {
                        //Leemos una opcion
                        opciones.add(bf.readLine());
                    }
                    //Leemos el minimo i el maximo de alternativas a escoger
                    int min_alternativas = Integer.parseInt(bf.readLine());
                    int max_alternativas = Integer.parseInt(bf.readLine());
                    P_Multiopcion pm = new P_Multiopcion(enunciado, min_alternativas, max_alternativas, opciones);
                    ll_preguntes.add(pm);
                    break;

                case 3:
                    //Leemos valor minimo y maximo posible
                    int min = Integer.parseInt(bf.readLine());
                    int max = Integer.parseInt(bf.readLine());
                    P_Numerico pn = new P_Numerico(enunciado, min, max);
                    ll_preguntes.add(pn);
                    break;

                case 4:
                    //Leemos el max de chars k tendra la respuesta
                    int max_length = Integer.parseInt(bf.readLine());
                    P_Texto pt = new P_Texto(enunciado, max_length);
                    ll_preguntes.add(pt);
                    break;
                default:
                   // System.out.println("Encuesta no correcta");
                    break;
            }
            //System.out.println("Seguent Pregunta a introduir: ");
            //Volvemos a leer el tipo de pregunta que se quiere crear
            tipus_pregunta = Integer.parseInt(bf.readLine());
        }
        //Cerramos el fichero
        bf.close();
        System.out.println("Encuesta creada correctamente");
    }*/

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

    public ArrayList<Encuesta_Respondida> getLl_encuestas_respondidas() {
        return ll_encuestas_respondidas;
    }

    public void setLl_encuestas_respondidas(ArrayList<Encuesta_Respondida> ll_encuestas_respondidas) {
        this.ll_encuestas_respondidas = ll_encuestas_respondidas;
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

    //Retorna el ll_preguntes donat un id_encuesta
    public Pregunta ll_preguntes(int id_encuesta) {
        return ll_preguntes.get(id_encuesta);
    }

    public void responder_interactivo() {
        Encuesta_Respondida er = new Encuesta_Respondida(this);
        for (Pregunta p : ll_preguntes) {
            er.añadir_respuesta_interactivo(p);
        }
        ll_encuestas_respondidas.add(er);
        System.out.println("Encuesta Respondida Correctamente");
    }

    /*public void responder_importar(String nom_ficher, BufferedReader bf) throws IOException {
        String name = bf.readLine();
        Encuesta_Respondida er = new Encuesta_Respondida(this, name);
        for (Pregunta p : ll_preguntes) {
            er.añadir_respuesta_importar(p, nom_ficher, bf);
        }
        ll_encuestas_respondidas.add(er);
        System.out.println("Encuesta Respondida Correctamente");
    }*/
}