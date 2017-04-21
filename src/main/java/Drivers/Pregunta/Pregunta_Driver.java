package Drivers.Pregunta;

import Preguntes.Pregunta;

/**
 * Created by polmoyabetriu on 21/4/17.
 */

public class Pregunta_Driver {

    public static void main(String[] args) {
        //Driver para Provar la clase Preguntes.Pregunta
        Pregunta p1 = new Pregunta();
        System.out.println("Id de la pregunta 1: " + p1.getId_pregunta());
        System.out.println("Enunciado" + p1.getEnunciado());
        String s = "Enunciado Preguntes.Pregunta 2";
        Pregunta p2 = new Pregunta(s);
        System.out.println("Id de la pregunta 1: " + p2.getId_pregunta());
        System.out.println("Enunciado" + p2.getEnunciado());
    }
}