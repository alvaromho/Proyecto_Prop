package clases;

import java.util.Objects;

/**
 * Created by Alvaro Muñoz
 */
public class Respuesta {


    private static int id_siguiente=1;
    /*
     * Atributos:
     *
     */
    protected int id;
    protected boolean no_contesta;

    public Respuesta() {
        this.id = id_siguiente;
        id_siguiente++;
    }

    public Respuesta(boolean no_contesta) {
        this.id = id_siguiente;
        id_siguiente++;
        this.no_contesta = no_contesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNo_contesta() {
        return no_contesta;
    }

    public void setNo_contesta(boolean no_contesta) {
        this.no_contesta = no_contesta;
    }

    /*
    * Se define la funcion distancia y getValor y se sobre-escriben en cada subclase
    */
    public float distancia(Respuesta respuesta){
        return 0;
    }
    public Object getValor(){return null;}
}
