package clases;

/**
 *
 */
public class P_Numerico extends Pregunta {

    private int min;
    private int max;

    public P_Numerico() {
    }

    public P_Numerico(String enunciado, int min, int max) {
        super(enunciado);
        this.min = min;
        this.max = max;
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
