import java.util.*;

public class P_Texto extends Pregunta {

    /**
     * Atributos
     */
    public int max_length;

    /**
     * Constructora interactiva, se crea a partir de los datos que se introducen al seguir los pasos que se van mostrando en pantalla.
     */
    public P_Texto() {
        Scanner scanner = new Scanner(System.in);
        int max_length = -1;
        boolean b = false;
        while (b == false) {
            System.out.println("Introduce el tamaño maximo del texto:");
            try {
                max_length = Integer.parseInt(scanner.next());
                b = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Format incorrecte");
            }
        }
        this.max_length = max_length;
        if(max_length < 0){
            System.out.println("Error, el nombre de caracters del text no pot ser un valor negatiu.");
        }
    }

    /**
     * Constructora,se crea a partir del enunciado de la pregunta y el tamaño maximo del texto de la respuesta.
     * @param enunciado
     * @param max_length
     */
    public P_Texto(String enunciado, int max_length) {
        super(enunciado);
        this.max_length = max_length;
    }

    /**
     * Devuelve el tamaño maximo del Texto.
     * @return max_length
     */
    public int getMax_length() {
        return max_length;
    }

    /**
     * Modificamos el tamaño maximo que teniamos por el tamaño que pasamos como parametro.
     * @param max_length
     */
    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}