package clases;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *  Clase responsable de realizar y manejar los analisis realizados sobre una muestra de encuestas respondidas
 */
public class Analisis {

    private static ArrayList<String> lista_nombres = new ArrayList<String>(); // Lista de todos los nombres, se actualiza cada vez que se genera un nuevo nombre
    /**
     *  Atributos
     */
    private String nombre_analisis;             // Atributo nombre  {Clave Primaria}
    private int tipo_analisis;                  // Dice a que tipo de analisis se realizó
    //private File detalle_analisis;
    //public ArrayList<Cluster> lista_clusters;   // Lista de Clusters resultados del analisis

    /**
     *  Constructor vacio/inicializa
     */
    public Analisis() {
        this.nombre_analisis = "sin_nombre";
        this.tipo_analisis = 0;
        //this.lista_clusters = new ArrayList<Cluster>();
    }

    /**
     *  Constructor simple
     */
    public Analisis( String nombre_analisis, int tipo_analisis) {
        // Comprobar que el nombre sea único.
        if (!Comprobar_nombre_unico(nombre_analisis)){
            System.out.println("\nnombre utilizado ");
            throw new IllegalArgumentException("El nombre ingresado ya existe.");
        }

        this.nombre_analisis = nombre_analisis;
        this.tipo_analisis = tipo_analisis;
        //this.lista_clusters = lista_clusters;

        // Añadir nombre a la lista
        lista_nombres.add(nombre_analisis);
    }

    /**
     *  Getters & Setters
     */
    // nombre_analisis: String
    public String getNombre_analisis() {
        return nombre_analisis;
    }
    public void setNombre_analisis(String nombre_analisis) {
        this.nombre_analisis = nombre_analisis;
    }
    // tipo_analisis
    public int getTipo_analisis() {
        return tipo_analisis;
    }
    public void setTipo_analisis(int tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
    }


    /*
    *  @param nuevo_nombre: String
    *  Retorna TRUE si el nombre que se quiere usar no se ha utilizado antes
    *
     */
    public boolean Comprobar_nombre_unico(String nuevo_nombre) {
        System.out.println("Ejecutando: Comprobar_nombre_unico_analisis");

        for(String nombre : lista_nombres) {
            if(nombre.compareTo(nuevo_nombre) == 0 ) return false;
        }

        return true;
    }

    public void print_nombres(){
        for(String nombre : lista_nombres) {
            System.out.println(nombre);
        }
    }

    public float distancia(Encuesta_Respondida encuesta_respondida_1, Encuesta_Respondida encuesta_respondida_2){

        // Comprobar que ambas encuestas_respondidas sean de la misma encuesta
        if (encuesta_respondida_1.getEncuesta().equals(encuesta_respondida_2.getEncuesta()) == false) {
            System.out.println("Las encuestas_respondidas no pertenecen a la misma encuesta.");
            return -1;
        }

        float sumatoria = 0, distancia = 0;
        int numero_de_preguntas = encuesta_respondida_2.getEncuesta().getLlista_preguntes().size();

        // por cada pregunta calcular la distancia local
        float arreglo_distancias[] = new float[numero_de_preguntas];


        Iterator<Respuesta> i1 = encuesta_respondida_1.getLl_respuesta().iterator();
        Iterator<Respuesta> i2 = encuesta_respondida_2.getLl_respuesta().iterator();


        while (i1.hasNext() && i2.hasNext()){
            Respuesta r1 = i1.next();
            Respuesta r2 = i2.next();

            float d = r1.distancia(r2);
//            System.out.println(d);
            sumatoria += d;
        }

        distancia = sumatoria/(float)numero_de_preguntas;
        //System.out.println(numero_de_preguntas);
        return distancia;
    }



}