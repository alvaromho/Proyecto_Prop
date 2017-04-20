import java.util.ArrayList;

/**
 * Created by alvaro-mac on 5/4/17.
 */
public class Cluster {

    public static int sig_id = 0;
    public static ArrayList<String> diccionario = new ArrayList<>();

    //Atributos
    private int id_cluster;                                     // ID_KEY
    private String nombre;
    private ArrayList<Encuesta_Respondida> lista_encuesta_respondida;    //Lista de Encuestas respondidas asociadas al cluster
    private Encuesta_Respondida  centroide;                               //Centroide del Cluster




    // Constructor
    public Cluster( ArrayList<Encuesta_Respondida> lista_respuestas) {
        this.setId_cluster();
        // TODO nombre único de cluster
        this.nombre = nombre;
        this.lista_encuesta_respondida = lista_respuestas;
        this.centroide = lista_respuestas.get(0);
    }


    public int getId_cluster() {
        return id_cluster;
    }
    public void setId_cluster() {
        this.id_cluster = sig_id++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Encuesta_Respondida> getLista_encuesta_respondida() {
        return lista_encuesta_respondida;
    }

    public void setLista_encuesta_respondida(ArrayList<Encuesta_Respondida> lista_respuestas) {
        this.lista_encuesta_respondida = lista_respuestas;
    }

    public Encuesta_Respondida getCentroide() {
        return centroide;
    }

    public void setCentroide(Encuesta_Respondida centroide) {

        this.centroide = centroide;
    }
    public  void setCentroide(){
        // TODO Explicar
        //TODO comprobar que la lista ya se haya inicializado

        // crear instancia de centroide con valores de respuesta igual a nulo (0,"- ", [false,false]
        Encuesta_Respondida centroide = new Encuesta_Respondida(getLista_encuesta_respondida().get(0));

        for (Respuesta respuesta : centroide.getLl_respuesta()) {
            if (respuesta instanceof R_Gradual) {
                respuesta.setValor(0);
            }
            else if (respuesta instanceof R_Multiopcion) {
                boolean[] valor = (boolean[]) respuesta.getValor();
                respuesta.setValor(crear_array_boolean(valor.length));
            }
            else if (respuesta instanceof R_Numerico) {
                respuesta.setValor(0);
            }
            else if (respuesta instanceof R_Texto) {
                respuesta.setValor("-");
            }
        }
    }




//    TODO funcion get moda de una muestra (array list Encuesta respondida)
//    public int getModa_pregunta_multipcion(ArrayList<Encuesta_Respondida> lista_encuestas_respondidas, int index_pregunta){
//        int contador =
//        for ( Encuesta_Respondida encuesta_respondida : lista_encuestas_respondidas){
//
//        }
//        return 0;
//    }

    public void Calcular_Centride(ArrayList<Encuesta_Respondida> grupo_cluster){
        // crear objeto que guarde los resultados

        System.out.println("Centroide:\n");

        Encuesta e = grupo_cluster.get(0).getEncuesta();
        Encuesta_Respondida centroide = new Encuesta_Respondida(getLista_encuesta_respondida().get(0));

//        System.out.println("antes:");
//        System.out.println(centroide.getLl_respuesta().get(0).getValor());
//        System.out.println(e.getLl_encuestas_respondidas().get(0).getLl_respuesta().get(0).getValor());
//
//        centroide.getLl_respuesta().get(0).setValor(0);
//
//        System.out.println("despues:");
//        System.out.println(centroide.getLl_respuesta().get(0).getValor());
//        System.out.println(e.getLl_encuestas_respondidas().get(0).getLl_respuesta().get(0).getValor());


//        int cantidad_preguntas= e.getLlista_preguntes().size();
        this.setCentroide();
        /*
        * TODO Explicar
        *Calcular Centroide
        *
        */

        for (Respuesta respuesta : centroide.getLl_respuesta()){
            respuesta.Calcular_Centroide(grupo_cluster, centroide.getLl_respuesta().indexOf(respuesta));
        }

        print_valores_encuesta_respondida(centroide);


    }

    public static void print_valores_encuesta_respondida(Encuesta_Respondida encuesta_respondida){
        for (Respuesta respuesta : encuesta_respondida.getLl_respuesta()){

            if (respuesta instanceof R_Multiopcion)
                    print_array_boolean((boolean[])respuesta.getValor());
             else
                 System.out.println(respuesta.getValor());
        }
    }

    public static boolean[] crear_array_boolean(int largo){
        boolean[] array = new boolean[largo];
        for (int i = 0; i < largo; i++){
            array[i] = false;
        }
        return array;
    }

    public static void print_array_boolean(boolean[] array){
        for ( int i = 0; i < array.length; i++){
            System.out.print((array[i] ? "true" : "false") + ((i != array.length-1) ? ",": ""));
        }
        System.out.println();
    }



    // Agrega palabras al diccionario
    public void agregar_al_diccionario(String string){
        for (String s : string.split("\\s+"))
            if (!diccionario.contains(s)) diccionario.add(s);
    }

    // borra caracteres especiales y cambia las mayusculas por minusculas
    // tambien llama a agregar al diccionario
    public String limpiar_string(String string){
        return  string.replaceAll("[^a-zA-Z]+"," ").toLowerCase();
    }

    public static void borrar_diccionario(){
        diccionario = new ArrayList<String>();
    }






}


