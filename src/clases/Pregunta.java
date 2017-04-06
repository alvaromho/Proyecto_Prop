package clases;


public class Pregunta {

    protected int id_pregunta;
    protected String enunciado;
    protected boolean no_sabe;

    //Constructor
    public Pregunta(int id_pregunta, String enunciado, boolean no_sabe) {
        this.id_pregunta = id_pregunta;
        this.enunciado = enunciado;
        this.no_sabe = no_sabe;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
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