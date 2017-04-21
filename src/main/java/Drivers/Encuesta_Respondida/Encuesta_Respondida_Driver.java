package Drivers.Encuesta_Respondida;

import GestionEncuestas.Encuesta;
import GestionEncuestas.Encuesta_Respondida;
import Respostes.Respuesta;

import java.util.*;

/**
 * Created by polmoyabetriu on 21/4/17.
 */
public class Encuesta_Respondida_Driver {
    //Driver para Provar la clase GestionEncuestas.Encuesta

    public static void main(String[] args) {
        //Entrar encuesta-respondida normal
        Encuesta e = new Encuesta();
        Encuesta_Respondida e1 = new Encuesta_Respondida(e);
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

        //Entrar encuesta-respondida casos limite
        e1 = new Encuesta_Respondida(e, "GestionEncuestas.Encuesta Respondida Test 2");
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

        //Entrar encuesta pasando todo
        Calendar creation_date = Calendar.getInstance();
        ArrayList<Respuesta> alr = new ArrayList<>();
        e1 = new Encuesta_Respondida("GestionEncuestas.Encuesta Respondida Test 3", creation_date, alr, e.getId());
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

        //Entrar encuesta pasando todo 2
        creation_date = Calendar.getInstance();
        alr = new ArrayList<>();
        e1 = new Encuesta_Respondida(e, "GestionEncuestas.Encuesta Respondida Test 3", creation_date, alr);
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

        //Entrar encuesta pasando todo
        creation_date = Calendar.getInstance();
        alr = new ArrayList<>();
        e1 = new Encuesta_Respondida("GestionEncuestas.Encuesta Respondida Test 3", creation_date, alr, e.getId());
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

        //Centroide
        Encuesta_Respondida e2 = new Encuesta_Respondida(e1);
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getDate());  //nose si es correcto

    }
}
