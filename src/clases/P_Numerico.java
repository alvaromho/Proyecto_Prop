package clases;
import java.util.*;
import java.io.*;

/**
 *Paula Alemany
 */
public class P_Numerico extends Pregunta {
    /**
     * Atributos
     */
    private int min;
    private int max;

    /**
     *contr
     */
    public P_Numerico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero maximo que se puede responder: ");
        int max = scanner.nextInt();
        this.max = max;
        System.out.println("Introduce el numero minimo que se puede responder: ");
        int min = scanner.nextInt();
        this.min = min;
    }

    /**
     * CREADORA
     * @param enunciado
     * @param min
     * @param max
     */
    public P_Numerico(String enunciado, int min, int max) {
        super(enunciado);
        this.min = min;
        this.max = max;
    }

    /**
     * CONSULTORAS
     * @return
     */
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    /**
     * MODIFICADORAS
     * @param
     */
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
