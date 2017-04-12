package clases;

/**
 *
 */
public class P_Numerico extends Pregunta {

    private int min;
    private int max;

    public P_Numerico() {
        System.out.println("Introduce el numero maximo que se puede responder: ");
        int max = scanner.nextInt();
        this.max = max;
        System.out.println("Introduce el numero minimo que se puede responder: ");
        int min = scanner.nextInt();
        this.min = min;
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
