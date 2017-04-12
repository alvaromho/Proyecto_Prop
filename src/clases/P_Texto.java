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
        System.out.println("Introduce el tamaño maximo del texto");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        this.max_length = n;
    }

    public P_Texto(String enunciado, int max_length) {
        super(enunciado);
        this.max_length = max_length;
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}