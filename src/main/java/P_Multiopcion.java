import java.util.*;
import java.lang.*;

/**
 * Paula Alemany i Vergé
 */

public class P_Multiopcion extends Pregunta {

    /**
     * Atributos
     */
    private int min_alternativas;
    private int max_alternativas;
    private ArrayList<String> enunciado_opcion = new ArrayList<>();

    /**
     * Constructora interactiva, a partir de los pasos que se mostraran en pantalla vamos a ir introduciendo los datos para asi asignar a cada atributo de la clase un valor.
     */
    public P_Multiopcion() {
        System.out.println("Introduce el numero de opciones que quiere poner:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Introduce las posibles respuestas:");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
        System.out.println("Introduce el numero maximo de alternativas que se pueden responder:");
        int maximo = scanner.nextInt();
        this.max_alternativas = maximo;
        if(maximo < 0){
            System.out.println("Error! El numero introducido es negativo.");
        }
        if(maximo > n){
            System.out.println("Error! El valor maximo de respuestas que puedes marcar no puede ser mayor al numero de opciones que tienes para responder. ");
        }
        System.out.println("Introduce el numero minimo de alternativas que se pueden responder:");
        int minimo = scanner.nextInt();
        if(minimo < 0){
            System.out.println("Error! El numero introducido es negativo.");
        }
        if(minimo > maximo){
            System.out.println("Error! El valor minimo de respuestas que puedes marcar no puede ser mayor que el valor maximo. ");
        }
        this.min_alternativas = minimo;
        System.out.println("Introduce las posibles respuestas: ");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
    }

    /**
     * Contructora, a partir de los parametros que se passan en la funcion.
     * @param enunciado
     * @param min_alternativas
     * @param max_alternativas
     * @param enunciado_opcion
     */
    public P_Multiopcion(String enunciado, int min_alternativas, int max_alternativas, ArrayList<String> enunciado_opcion) {
        super(enunciado);
        this.min_alternativas = min_alternativas;
        this.max_alternativas = max_alternativas;
        this.enunciado_opcion = enunciado_opcion;
    }

    /**
     * Devuelve el valor que tenemos guardado en el atributo min_alternativas.
     * @return int
     */
    public int getMin_alternativas() {
        return min_alternativas;
    }

    /**
     * Modifica el valor que tenemos en el atributo min_alternativas por el que se pasa como parametro.
     * @param min_alternativas
     */
    public void setMin_alternativas(int min_alternativas) {
        this.min_alternativas = min_alternativas;
    }

    /**
     * Devuelve el valor que tenemos guardado en el atributo max_alternativas.
     * @return int
     */
    public int getMax_alternativas() {
        return max_alternativas;
    }

    /**
     * Modifica el valor que tenemos en el atributo max_alternativas por el que se pasa como parametro.
     * @param max_alternativas
     */
    public void setMax_alternativas(int max_alternativas) {
        this.max_alternativas = max_alternativas;
    }

    /**
     * Devuelve la lista que tenemos guardada en el atributo enunciado_opcion.
     * @return ArrayList<String>
     */
    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    /**
     * Modifica la lista que tenemos en el atributo enunciado_opcion por la que se pasa como parametro.
     * @param enunciado_opcion
     */
    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }

