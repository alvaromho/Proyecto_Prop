package clases;

/**
 *
 */
public class P_Numerico extends Pregunta {

    private int min;
    private int max;

    public P_Numerico(int id_pregunta, String enunciado, boolean no_sabe) {
        super(id_pregunta, enunciado, no_sabe);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
