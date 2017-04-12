package clases;
import java.util.*;
import java.lang.*;
/*Paula*/

public class P_Multiopcion extends Pregunta {

    private int min_alternativas;
    private int max_alternativas;
    private ArrayList<String> enunciado_opcion;


    public P_Multiopcion() {
        System.out.println("Introduce el numero de opciones que quiere poner: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Introduce las posibles respuestas: ");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
        System.out.println("Introduce el numero maximo de alternativas que se pueden responder: ");
        int maximo = scanner.nextInt();
        this.max_alternativas = maximo;
        System.out.println("Introduce el numero minimo de alternativas que se pueden responder: ");
        int minimo = scanner.nextInt();
        this.min_alternativas = minimo;
    }

    public P_Multiopcion(String enunciado, int min_alternativas, int max_alternativas, ArrayList<String> enunciado_opcion) {
        super(enunciado);
        this.min_alternativas = min_alternativas;
        this.max_alternativas = max_alternativas;
        this.enunciado_opcion = enunciado_opcion;
    }

    public int getMin_alternativas() {
        return min_alternativas;
    }

    public void setMin_alternativas(int min_alternativas) {
        this.min_alternativas = min_alternativas;
    }

    public int getMax_alternativas() {
        return max_alternativas;
    }

    public void setMax_alternativas(int max_alternativas) {
        this.max_alternativas = max_alternativas;
    }

    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }

    public int getSizeEncunciado_Opcion() {
        return this.enunciado_opcion.size();
    }
}