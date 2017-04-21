package Preguntes;

import Preguntes.Pregunta;

import java.util.*;
import java.lang.*;


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
        System.out.println("Introduce las " + n + " posibles respuestas:");
        for (int i = 0; i < n; ++i) {
            enunciado_opcion.add(scanner.next());
        }
        int maximo = -1;
        b = false;
        while (b == false) {
            System.out.println("Introduce el numero maximo de alternativas que se pueden responder:");
            try {
                maximo = Integer.parseInt(scanner.next());
                b = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Format incorrecte");
            }
            if (b == true && maximo < 0) {
                System.out.println("Error! El numero introducido es < 0.");
                b = false;
            }
            if (b == true && maximo > n) {
                System.out.println("Error! El valor maximo de respuestas que puedes marcar no puede ser mayor > " + n + " .");
                b = false;
            }
        }
        this.max_alternativas = maximo;


        int minimo = -1;
        b = false;
        while (b == false) {
            System.out.println("Introduce el numero minimo de alternativas que se pueden responder:");
            try {
                minimo = Integer.parseInt(scanner.next());
                b = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Format incorrecte");
            }
            if (b == true && minimo < 0) {
                    System.out.println("Error! El numero introducido es negativo.");
                    b = false;
            }
            if (b == true && minimo > maximo) {
                System.out.println("Error! El valor minimo de respuestas que puedes marcar no puede ser >" + maximo + " .");
                b = false;
            }
        }
        this.min_alternativas = minimo;
    }

    /**
     * Contructora, a partir de los parametros que se passan en la funcion.
     *
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
     *
     * @return int
     */
    public int getMin_alternativas() {
        return min_alternativas;
    }

    /**
     * Modifica el valor que tenemos en el atributo min_alternativas por el que se pasa como parametro.
     *
     * @param min_alternativas
     */
    public void setMin_alternativas(int min_alternativas) {
        this.min_alternativas = min_alternativas;
    }

    /**
     * Devuelve el valor que tenemos guardado en el atributo max_alternativas.
     *
     * @return int
     */
    public int getMax_alternativas() {
        return max_alternativas;
    }

    /**
     * Modifica el valor que tenemos en el atributo max_alternativas por el que se pasa como parametro.
     *
     * @param max_alternativas
     */
    public void setMax_alternativas(int max_alternativas) {
        this.max_alternativas = max_alternativas;
    }

    /**
     * Devuelve la lista que tenemos guardada en el atributo enunciado_opcion.
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    /**
     * Modifica la lista que tenemos en el atributo enunciado_opcion por la que se pasa como parametro.
     *
     * @param enunciado_opcion
     */
    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }
}

