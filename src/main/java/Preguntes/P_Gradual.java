package Preguntes;

import Preguntes.Pregunta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by polmoyabetriu.
 */

public class P_Gradual extends Pregunta {

    protected ArrayList<String> enunciado_opcion = new ArrayList<>();

    /**
     * Constructor de Pregunta Gradual interactivo
     */
    public P_Gradual() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        boolean b = false;
        while (b == false) {
            System.out.println("Introduce el numero de opciones que quiere poner:");
            try {
                n = Integer.parseInt(scanner.next());
                b = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Format incorrecte");
            }
        }
        System.out.println("Introduce las " + n + " posibles respuestas graduales: ");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
    }

    /**
     * Constructor de Pregunta Gradual
     * @param enunciado
     * @param enunciado_opcion
     */
    public P_Gradual(String enunciado, ArrayList<String> enunciado_opcion) {
        super(enunciado);
        this.enunciado_opcion = enunciado_opcion;
    }

    /**
     * Getter Enunciado_opcion
     * @return enunciado_opcion
     */
    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    /**
     * Setter enunciado_opcion
     * @param enunciado_opcion
     */
    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }
}