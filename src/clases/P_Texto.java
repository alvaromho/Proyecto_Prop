package clases;

/**
 * 
 */
public class P_Texto extends Pregunta {

    /**
     * Atributos
     */
    public int max_length;

    public P_Texto(int id_pregunta, String enunciado, boolean no_sabe) {
        super(id_pregunta, enunciado, no_sabe);
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}