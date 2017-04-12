package clases;

/**
 * 
 */
public class P_Texto extends Pregunta {

    /**1
     * Atributos
     */
    public int max_length;

    public P_Texto() {
    }

    public P_Texto(String enunciado) {
        super(enunciado);
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}