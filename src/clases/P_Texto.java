package clases;

/**
 * 
 */
public class P_Texto extends Pregunta {

    /**
     * Atributos
     */
    public int max_length;

    /**
     * Creadora
     */
    public P_Texto() {
        System.out.println("Introduce el tamaño maximo del texto: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        this.max_length = n;
    }

    /**
     *Es la creadora a partir del enunciado de la pregunta y el tamaño maximo del texto de la respuesta
     * @param enunciado
     * @param max_length
     */
    public P_Texto(String enunciado, int max_length) {
        super(enunciado);
        this.max_length = max_length;
    }

    /**
     *Devuelve el tamaño maximo del Texto
     * @return max_length
     */
    public int getMax_length() {
        return max_length;
    }

    /**
     * modificamos el tamaño maximo que teniamos por el tamaño que pasamos como parametro
     * @param max_length
     */
    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}