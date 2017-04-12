package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by polmoyabetriu on 10/4/17.
 */

public class P_Gradual extends Pregunta {

    protected ArrayList<String> enunciado_opcion = new ArrayList<>();

    public P_Gradual() {
        System.out.println("Introduce el numero de opciones que quiere poner");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Introduce las posibles respuestas graduales: ");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
    }

    public P_Gradual(String enunciado, ArrayList<String> enunciado_opcion) {
        super(enunciado);
        this.enunciado_opcion = enunciado_opcion;
    }

    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }
}