/**
 * @author Enric F D
 */
package clases;
import java.util.ArrayList;
import java.util.HashMap;

public class Clustering_jerarquico_aglomerativo extends Analisis{


    private int num_clusters_validos, num_cluster_siguiente, Numero_enq_res;
    private ArrayList<Cluster> lista_perfiles;
    private HashMap<Integer,Integer> rutas;

    private void inicialitzar_cluster_vect(ArrayList<Encuesta_Respondida> ER)                                //Inicializamos el vector de clusters assignando cada questionario respondido a 1 cluster nuevo creamos n clusters mas vacios
    {
        this.num_clusters_validos = this.Numero_enq_res;
        this.num_cluster_siguiente = this.Numero_enq_res;                                                                    // donde n es el num de questionarios respon
        for( int i=0; i < this.Numero_enq_res *2 ; i++)
            if (i < this.Numero_enq_res) {
                Cluster c_v = new Cluster();
                ArrayList<Encuesta_Respondida> Arrayauxiliar = new ArrayList<Encuesta_Respondida>();
                Arrayauxiliar.add(ER.get(i));
                c_v.agregar_enquestas_respondidas(Arrayauxiliar);
                c_v.setId_cluster(i);
                this.lista_perfiles.add(c_v);
            }
    }

    private void inicialitzar_hashmap()
    {
        for(int i = 0; i < this.Numero_enq_res *2 ; i++)				    //inicializamos elementos de rutas (cardinal, -2)
        {
            if(i >= this.Numero_enq_res) this.rutas.put(i, -2);               //los espacios destinados a los nuevos clusters incializ a -2
            else this.rutas.put(i, -1);                                         //los i elementos generan un cluster cada uno incializamos a -1
        }
    }

    //Constructora
    public Clustering_jerarquico_aglomerativo(ArrayList<ArrayList<Float>> conj_respuestas, ArrayList<Encuesta_Respondida> ER1)
    {
        this.Numero_enq_res = ER1.size();
        this.lista_perfiles = new ArrayList<Cluster>();
        this.rutas = new HashMap<Integer,Integer>();
        this.inicialitzar_cluster_vect(ER1);
        this.inicialitzar_hashmap();
    }

// GETERS
    public ArrayList<Cluster> getLista_perfiles() {
        return this.lista_perfiles;
    }

    public int getnum_clusters_validos() {
        return this.num_clusters_validos;
    }

    //dado un cluster nos dice si este pertenece a uno mayor, es valido si no hay ningun otro que lo agrupe a el i a otros
    public boolean perfil_valido(int IDCLuster) {
        if(this.rutas.get(IDCLuster).hashCode() == -1) return true;
        else return false;
    }

    //Dados las ids de los 2 clusters mas cercanos, en el momento actual, se crea el nuevo cluster que agrupa los que se nos dan
    //actualiza la lista de perfiles, crea i define el nuevo Cluster
    //Actualiza el vector de rutas de los clusters
    public void Avansa_Clustering(int idCluster1, int idCluster2)
    {
        Cluster aux;
        aux = new Cluster();
        aux = aux.Combina_clusters(this.lista_perfiles.get(idCluster1), this.lista_perfiles.get(idCluster2));
        aux.setId_cluster(this.num_cluster_siguiente);
        aux.Calcular_Centroide();

        this.lista_perfiles.set(this.num_cluster_siguiente, aux);

        this.rutas.put(idCluster1, aux.getId_cluster());
        this.rutas.put(idCluster2, aux.getId_cluster());
        this.rutas.put(aux.getId_cluster(), -1);

        this.num_cluster_siguiente++;
        this.num_clusters_validos--;

        System.out.println(aux.getId_cluster());            //chivatos Driver
        System.out.println(this.num_cluster_siguiente);
        System.out.println(this.num_clusters_validos);

    }

    //nos devuelve la lista de Perfiles que son validos (valor en rutas de -1), sera 1 perfil solo si Pedimos 1 Cluster,

    public ArrayList<Cluster> getListaPerfilesValidos()
    {
        ArrayList<Cluster> LPV1 = new ArrayList<Cluster>();
        for (int i = 0; i < this.lista_perfiles.size(); i++) {
            if (this.rutas.get(i).hashCode() == -1) {
                LPV1.add(this.lista_perfiles.get(i));
                System.out.println(LPV1.get(i).getNombre() );  //chivato
            }
        }
        return LPV1;
    }

 }

