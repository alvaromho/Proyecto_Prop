package clases;


public class Pregunta {

    protected int id;
    protected String enunciado;
    protected boolean no_sabe;

    protected static int id_count = 1;

    public Pregunta() {
    }

    //Constructor
    public Pregunta(int id_pregunta, String enunciado, boolean no_sabe) {
        this.id = id_pregunta;
        this.enunciado = enunciado;
        this.no_sabe = no_sabe;


    }

    public int getId_pregunta() {
        return id;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id = id_pregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isNo_sabe() {
        return no_sabe;
    }

    public void setNo_sabe(boolean no_sabe) {
        this.no_sabe = no_sabe;
    }
}