import java.util.*;

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
     * creadora interactiva
     */
    public P_Numerico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero maximo que se puede responder: ");
        int max = scanner.nextInt();
        this.max = max;
        System.out.println("Introduce el numero minimo que se puede responder: ");
        int min = scanner.nextInt();
        this.min = min;
        if(max < min or max < 0 or min < 0){
            System.out.println("Error! Los valores introducidos no son correctos. Recuerda: Los valores deben ser positivos y el valor minimo debe ser mas pequeño o igual que el maximo.\n Por favor, vuelve a introducir el valor maximo: ");
            max = scanner.nextInt();
            this.max = max;
            System.out.println("Ahora introduzca el valor minimo: ");
            min = scanner.nextInt();
            this.min = min;

        }
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
     * Devuelve el valor minimo que se puede responder.
     * @return min
     */
    public int getMin() {
        return min;
    }

    /**
     * Devuelve el valor maximo que se puede responder.
     * @return max
     */
    public int getMax() {
        return max;
    }

    /**
     * modificamos el valor minimo que teniamos como atributo min por el que pasamos como parametro.
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
