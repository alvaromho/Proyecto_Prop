package clases;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *  Clase responsable de realizar y manejar los analisis realizados sobre una muestra de encuestas respondidas
 */
public class Analisis {

    private static ArrayList<String> lista_nombres = new ArrayList<String>(); // Lista de todos los nombres, se actualiza cada vez que se genera un nuevo nombre
    /**
     * Atributos
     */
    private String nombre_analisis;                           // Atributo nombre  {Clave Primaria}
    private int tipo_analisis;
    // Dice a que tipo de analisis se realizó
    private Clustering_jerarquico_aglomerativo CJA;
    private Muestra M1 = new Muestra();

    ArrayList<Cluster> lista_perfiles_validos = new ArrayList<Cluster>();
    ArrayList<Encuesta_Respondida> lista_representates_delos_perfiles = new ArrayList<Encuesta_Respondida>();

    /**
     * Privadas
     * repasa las distancias del centroide calculado, con todas las respuestas existentes de la enquesta para encontrar el representante
     */
    private Encuesta_Respondida Busca_representante(Cluster cluster1) {

        Encuesta_Respondida ER1 = new Encuesta_Respondida();
        ArrayList<Encuesta_Respondida> Enq_R;
        Enq_R = this.M1.get_Lista_todas_Respuestas_Enquesta();
        Float distancia_min = (float) -1;

        for (int i = 0; i < Enq_R.size(); i++) {

            ER1 = new Encuesta_Respondida(cluster1.getCentroide());
            if (distancia_min > this.distancia(ER1, Enq_R.get(i)) || distancia_min == -1) {
                distancia_min = this.distancia(ER1, Enq_R.get(i));
                ER1 = Enq_R.get(i);
            }
        }

        return ER1;
    }

    /**
     * Publicas
     * Constructor vacio/inicializa
     */
    public Analisis() {
        nombre_analisis = "sin_nombre";
        tipo_analisis = 0;
    }

    /**
     * Constructor simple
     */
    public Analisis(String nombre_analisis, int tipo_analisis, Muestra Muestra1) {
        this.nombre_analisis = nombre_analisis;
        this.tipo_analisis = tipo_analisis;
        this.M1 = Muestra1;
        ArrayList<Encuesta_Respondida> EResp;
        EResp = this.M1.get_lista_respuesta();
        this.CJA = new Clustering_jerarquico_aglomerativo(this.Transforma_vectdeFLoats(EResp), EResp);

        // Comprobar que el nombre sea único.
        if (!this.Comprobar_nombre_unico(nombre_analisis)) {
            System.out.println("\nombre utilizado");
            throw new IllegalArgumentException("El nombre ingresado ya existe.");
        }
        Analisis.lista_nombres.add(nombre_analisis);


    }


    /**
     * Getters & Setters
     */

    public String getNombre_analisis() {
        return this.nombre_analisis;
    }

    public void setNombre_analisis(String nombre_analisis) {
        this.nombre_analisis = nombre_analisis;
    }

    public int getTipo_analisis() {
        return this.tipo_analisis;
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

        for (String nombre : Analisis.lista_nombres) {
            if (nombre.compareTo(nuevo_nombre) == 0) return false;
        }

        return true;
    }

    public void print_nombres() {
        for (String nombre : Analisis.lista_nombres)
            System.out.println(nombre);
    }

    public void print_representantes() {
        for (int i = 0; i < this.lista_representates_delos_perfiles.size(); i++)
            System.out.println(this.lista_representates_delos_perfiles.get(i).getId());
    }

    public void print_Lista_perfiles_validos() {
        for (int i = 0; i < this.lista_representates_delos_perfiles.size(); i++) {
            System.out.println(this.lista_perfiles_validos.get(i).getCentroide());
            System.out.println(this.lista_perfiles_validos.get(i).getNombre());
        }
    }

    //Dadas 2 Enquestas_respondidas nos devuelve el valor distancia calculado

    public float distancia(Encuesta_Respondida encuesta_respondida_1, Encuesta_Respondida encuesta_respondida_2) {

        // Comprobar que ambas encuestas_respondidas sean de la misma encuesta
        if (!encuesta_respondida_1.getEncuesta().equals(encuesta_respondida_2.getEncuesta())) {
            System.out.println("Las encuestas_respondidas no pertenecen a la misma encuesta.");
            return -1;
        }

        float sumatoria = 0, distancia = 0;
        int numero_de_preguntas = encuesta_respondida_2.getEncuesta().getLlista_preguntes().size();

        // por cada pregunta calcular la distancia local
        float arreglo_distancias[] = new float[numero_de_preguntas];

        Iterator<Respuesta> i1 = encuesta_respondida_1.getLl_respuesta().iterator();
        Iterator<Respuesta> i2 = encuesta_respondida_2.getLl_respuesta().iterator();

        while (i1.hasNext() && i2.hasNext()) {
            Respuesta r1 = i1.next();
            Respuesta r2 = i2.next();

            float d = r1.distancia(r2);
//            System.out.println(d);
            sumatoria += d;
        }

        distancia = sumatoria / (float) numero_de_preguntas;
        //System.out.println(numero_de_preguntas);
        return distancia;
    }

    // transforma el vector de Enquestas_respondidas en un vector de vectores<float>
    public ArrayList<ArrayList<Float>> Transforma_vectdeFLoats(ArrayList<Encuesta_Respondida> ER) {
        ArrayList<ArrayList<Float>> Enq_resp = new ArrayList<>();
        for (int i = 0; i < ER.size(); i++) Enq_resp.add(ER.get(i).Traducir_Respuesta_ArrayListFloat());
        return Enq_resp;
    }


    /**
     * Calcula las distancias entre todos los clusters existentes, i retorna la id de los 2 con menor distancia
     */

    public ArrayList<Integer> Clusters_con_menor_distancia() {
        ArrayList<Integer> vectResp;
        vectResp = new ArrayList<Integer>();

        Cluster clu1, clu2, clust1Fi, clust2Fi;

        clust1Fi = new Cluster();
        clust2Fi = new Cluster();

        Float distancia_min = (float) -1;
        ArrayList<Cluster> lista_perfiles1;
        lista_perfiles1 = this.CJA.getLista_perfiles();

        int j;

        for (int i = 0; i < lista_perfiles1.size(); i++) {
            while (!this.CJA.perfil_valido(lista_perfiles1.get(i).getId_cluster())) {
                i++;
            }

            clu1 = lista_perfiles1.get(i);

            for (j = i + 1; j < lista_perfiles1.size(); j++) {
                while (!this.CJA.perfil_valido(lista_perfiles1.get(j).getId_cluster())) j++;

                clu2 = lista_perfiles1.get(j);

                if (distancia_min > this.distancia(clu1.getCentroide(), clu2.getCentroide()) || distancia_min == -1) {
                    distancia_min = this.distancia(clu1.getCentroide(), clu2.getCentroide());
                    clust1Fi = clu1;
                    clust2Fi = clu2;
                }
            }
        }

        vectResp.set(0, clust1Fi.getId_cluster());
        vectResp.set(1, clust2Fi.getId_cluster());

        return vectResp;
    }

    /**
     * Genera el arbol, teniendo en cuenta el numero de clusters que queremos si <= 0 se genera
     * all the tree
     * luego saca los perfiles resultantes, los guarda en la clase Analisis i les assigna su correspondiente representante
     */

    public void Genera_arbre_concret(int num_clusters_def)         //num_clusters_def 1 si queremos generar toodd el arbol , el num de Clusters/perfiles en los quales queremos dividirlos
    {
        ArrayList<Integer> Clusters_mas_cercanos = new ArrayList<Integer>();

        while (this.CJA.getnum_clusters_validos() > num_clusters_def) {
            Clusters_mas_cercanos = this.Clusters_con_menor_distancia();

            System.out.println(Clusters_mas_cercanos.get(0));
            System.out.println(Clusters_mas_cercanos.get(1));         //CHivato Driver

            this.CJA.Avansa_Clustering(Clusters_mas_cercanos.get(0), Clusters_mas_cercanos.get(1));

        }
        this.lista_perfiles_validos = CJA.getListaPerfilesValidos();
        this.Assignar_representantes();
    }


    /**
     * Encuentra el representante de cada perfil, los guarda en un vector de Analisis
     */

    public void Assignar_representantes() {
        for (int i = 0; i < this.lista_perfiles_validos.size(); i++) {
            this.lista_representates_delos_perfiles.set(i, this.Busca_representante(this.lista_perfiles_validos.get(i)));
        }

    }
}
