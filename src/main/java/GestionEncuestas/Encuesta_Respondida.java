package GestionEncuestas;

import Preguntes.*;
import Respostes.*;

import java.util.*;

/**
 * Pol Moya Betriu
 */
    public class Encuesta_Respondida {


    private int id;
    private Encuesta encuesta;
    private String name;
    private Calendar creation_date;
    private ArrayList<Respuesta> ll_respuesta = new ArrayList<>();

    private static int id_count = 0;


    /**
     * Constructor Encuesta_Respondida interactivo
     * @param e
     */
    public Encuesta_Respondida(Encuesta e) {
        Scanner scanner = new Scanner(System.in);
        this.id = id_count;
        ++id_count;
        this.encuesta = e;
        System.out.println("Introduce tu nombre:");
        this.name = scanner.next();
        this.creation_date = Calendar.getInstance();
    }

    /**
     * Constructor Encuesta_Respondida
     * @param e
     * @param name
     */
    public Encuesta_Respondida(Encuesta e, String name) {
        this.id = id_count;
        ++id_count;
        this.encuesta = e;
        System.out.println("Introduce tu nombre:");
        this.name = name;
        this.creation_date = Calendar.getInstance();
    }



    /*public Encuesta_Respondida(String nombre, Calendar creation_date, ArrayList<Respuesta> ll_respuesta, int id_encuesta) {
        this.id = id_count;
        ++id_count;
        this.name = nombre;
        this.creation_date = creation_date;
        this.ll_respuesta = ll_respuesta;
    }*/

    /**
     * Constructor Encuesta_Respondida
     * @param e
     * @param nombre
     * @param creation_date
     * @param ll_respuesta
     */
    public Encuesta_Respondida(Encuesta e, String nombre, Calendar creation_date, ArrayList<Respuesta> ll_respuesta) {
        this.id = id_count;
        ++id_count;
        this.encuesta = e;
        this.name = nombre;
        this.creation_date = creation_date;
        this.ll_respuesta = ll_respuesta;
    }

    // TODO constructor copiar para generar/inciar centroide a partir de una encuesta_respondida de la nis

    /**
     * Constructor Encuesta Respondida(dubplica la encuesta Respondida para el centroide)
     * @param otro
     */
    public Encuesta_Respondida(Encuesta_Respondida otro) {
        this.id = id_count;
        id_count++;
         this.encuesta = otro.encuesta;
         this.name = otro.name;
         this.creation_date = otro.creation_date;

         //  Copiar ll_respusta
        int i = 0;
        this.ll_respuesta = new ArrayList<>();
        for ( Respuesta respuesta : otro.getLl_respuesta()){

            if (respuesta instanceof R_Gradual){
                this.getLl_respuesta().add(new R_Gradual((R_Gradual)respuesta));
            } else if (respuesta instanceof R_Multiopcion){
                this.getLl_respuesta().add(new R_Multiopcion((R_Multiopcion)respuesta));
            } else if (respuesta instanceof R_Numerico){
                this.getLl_respuesta().add(new R_Numerico((R_Numerico)respuesta));
            } else if (respuesta instanceof R_Texto){
                this.getLl_respuesta().add(new R_Texto((R_Texto) respuesta));
            }
        }
    }

    /**
     * Getter Id
     * @return id
     */
    public int getId() {    //Getter id
        return id;
    }

    /**
     * Setter Id
     * @param id
     */
    public void setId(int id) {     //Setter id
        this.id = id;
    }

    /**
     * Getter Name
     * @return name
     */
    public String getName() {     //Getter Nombre
        return name;
    }

    /**
     * Setter Name
     * @param nombre
     */
    public void setName(String nombre) {      //Setter Nombre
        this.name = nombre;
    }

    /**
     * Getter Date
     * @return creation_date
     */
    public Calendar getDate() {     //Getter Date
        return creation_date;
    }

    /**
     * Setter Date
     * @param date
     */
    public void setDate(Calendar date) {        //Setter Date
        this.creation_date = date;
    }

    /**
     * Getter ll_respuesta
     * @return ll_respuesta
     */
    public ArrayList<Respuesta> getLl_respuesta() {     //Getter ll_respuesta
        return ll_respuesta;
    }

    /**
     * Setter ll_respuesta
     * @param ll_respuesta
     */
    public void setLl_respuesta(ArrayList<Respuesta> ll_respuesta) {        //Setter ll_respuesta
        this.ll_respuesta = ll_respuesta;
    }

    /**
     * Getter Encuesta
     * @return encuesta
     */
    public Encuesta getEncuesta() {
        return encuesta;
    }

    /**
     * Setter Encuesta
     * @param encuesta
     */
    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    /**
     * Se responde una pregunta
     * @param p
     */
    public void añadir_respuesta_interactivo(Pregunta p){

        //System.out.println(p.getEnunciado());
        if (p instanceof P_Gradual) {
            //System.out.println("Gradual");
            R_Gradual rg = new R_Gradual((P_Gradual) p);
            this.ll_respuesta.add(rg);
        }
        else if (p instanceof P_Multiopcion) {
            //System.out.println("MultiOpcion");
            R_Multiopcion rm = new R_Multiopcion((P_Multiopcion) p);
            this.ll_respuesta.add(rm);
        }
        else if (p instanceof P_Numerico) {
            //System.out.println("Numerico");
            R_Numerico rn = new R_Numerico((P_Numerico) p);
            this.ll_respuesta.add(rn);
        }
        else if (p instanceof P_Texto) {
            //System.out.println("Texto");
            R_Texto rt = new R_Texto((P_Texto) p);
            this.ll_respuesta.add(rt);
        }
        else {
            System.out.println("Normal");
            System.out.println(p.getEnunciado());
        }
    }

    /*
    public void añadir_respuesta(Preguntes.P_Gradual p) {
        System.out.println("Gradual");
    }

    public void añadir_respuesta(Preguntes.P_Multiopcion p) {
        System.out.println("MultiOpcion");
    }

    public void añadir_respuesta(Preguntes.P_Numerico p) {
        System.out.println("Numerico");
    }

    public void añadir_respuesta(Preguntes.P_Texto p) {
        System.out.println("Texto");
    }*/

    /*Comentado por importar Respostes.Respuesta
    public void añadir_respuesta_importar(Preguntes.Pregunta p, String nom_ficher, BufferedReader bf) throws IOException {
        String nombre_encuesta = bf.readLine();
        if (p instanceof Preguntes.P_Gradual) {
            //System.out.println("Gradual");
            int valor = Integer.parseInt(bf.readLine());
            boolean nc = false;
            if (valor == -1) nc = true;
            Respostes.R_Gradual rg = new Respostes.R_Gradual((Preguntes.P_Gradual) p, nc, valor);
            this.ll_respuesta.add(rg);
        }
        else if (p instanceof Preguntes.P_Multiopcion) {
            //System.out.println("MultiOpcion");
            boolean nc = true;
            int n = ((Preguntes.P_Multiopcion) p).getSizeEncunciado_Opcion();
            boolean[] respuesta_bool = new boolean[n];
            for (int i = 0; i < n; ++i) {
                boolean aux = (Integer.parseInt(bf.readLine()) == 1);
                respuesta_bool[i] = aux;
                if (aux) nc = false;
            }
            Respostes.R_Multiopcion rm = new Respostes.R_Multiopcion((Preguntes.P_Multiopcion) p, nc, respuesta_bool);
            this.ll_respuesta.add(rm);
        }
        else if (p instanceof Preguntes.P_Numerico) {
            //System.out.println("Numerico");
            int valor = Integer.parseInt(bf.readLine());
            boolean nc = false;
            if (valor == -1) nc = true;
            Respostes.R_Numerico rn = new Respostes.R_Numerico((Preguntes.P_Numerico) p, nc, valor);
            this.ll_respuesta.add(rn);
        }
        else if (p instanceof Preguntes.P_Texto) {
            //System.out.println("Texto");
            String texto = bf.readLine();
            boolean nc = false;
            if (texto == "-") nc = true;
            Respostes.R_Texto rt = new Respostes.R_Texto((Preguntes.P_Texto) p, nc, texto);
            this.ll_respuesta.add(rt);
        }
        else System.out.println("Normal");
        System.out.println(p.getEnunciado());
    }


    public void modificar_respuesta(int index, Respostes.Respuesta respuesta_new) {
    //Se modifica la respuesta situada en la posicio index por respuesta_new.
        ll_respuesta.set(index, respuesta_new);

    }*/




}




