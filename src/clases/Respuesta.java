package clases;

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
    protected  Pregunta pregunta;
    protected boolean no_sabe;
    protected boolean no_contesta;

    public Respuesta(Pregunta pregunta, boolean no_sabe, boolean no_contesta) {
        this.id = id_siguiente;
        id_siguiente++;
        this.pregunta = pregunta;
        this.no_sabe = no_sabe;
        this.no_contesta = no_contesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isNo_sabe() {
        return no_sabe;
    }

    public void setNo_sabe(boolean no_sabe) {
        this.no_sabe = no_sabe;
    }

    public boolean isNo_contesta() {
        return no_contesta;
    }

    public void setNo_contesta(boolean no_contesta) {
        this.no_contesta = no_contesta;
    }

    /*
    * Se define la funcion distancia y se sobreescribe en cada subclase
    */
    public float distancia(Respuesta respuesta){
        return 0;
    }
}
