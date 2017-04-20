import java.util.*;

/**
 *Paula Alemany i Vergé
 */
public class P_Numerico extends Pregunta {
    /**
     * Atributos
     */
    private int min;
    private int max;

    /**
     * Constructora interactiva, se crea a partir de los datos que se introducen al seguir los passos que se muestran en pantalla.
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
     * Constructora a partir de los valores que se pasan como parametros.
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
     * Modificamos el valor minimo que teniamos como atributo min por el que pasamos como parametro.
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Modificamos el valor maximo que teniamos como atributo max por el que pasamos como parametro.
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }
}
