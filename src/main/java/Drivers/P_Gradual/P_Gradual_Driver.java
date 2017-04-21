package Drivers.P_Gradual;

import Preguntes.P_Gradual;

import java.util.ArrayList;

/**
 * Created by polmoyabetriu on 21/4/17.
 */
public class P_Gradual_Driver {

    public static void main(String[] args) {
        //Driver para Provar la clase Preguntes.P_Gradual
        P_Gradual p1 = new P_Gradual();
        System.out.println("Id de la pregunta 1: " + p1.getId_pregunta());
        System.out.println("Enunciado" + p1.getEnunciado());
        System.out.println("Se imprimiran las opciones de respuesta graduales: ");
        ArrayList<String> enunciado_opcion = p1.getEnunciado_opcion();
        for (String s : enunciado_opcion) System.out.println(s);

        P_Gradual p2 = new P_Gradual();
        System.out.println("Id de la pregunta 2: " + p2.getId_pregunta());
        System.out.println("Enunciado" + p2.getEnunciado());
        System.out.println("Se imprimiran las opciones de respuesta graduales: ");
        enunciado_opcion = p2.getEnunciado_opcion();
        for (String s : enunciado_opcion) System.out.println(s);

        P_Gradual p3 = new P_Gradual("encunciado", enunciado_opcion);
        System.out.println("Id de la pregunta 3: " + p3.getId_pregunta());
        System.out.println("Enunciado" + p3.getEnunciado());
        System.out.println("Se imprimiran las opciones de respuesta graduales: ");
        for (String s : enunciado_opcion) System.out.println(s);
    }
}
