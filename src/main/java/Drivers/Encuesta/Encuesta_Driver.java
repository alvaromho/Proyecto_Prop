package Drivers.Encuesta;

import GestionEncuestas.Encuesta;
import GestionEncuestas.Encuesta_Respondida;
import Preguntes.Pregunta;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by polmoyabetriu on 21/4/17.
 */
public class Encuesta_Driver {

    public static void main(String[] args) {
        //Driver para Provar la clase GestionEncuestas.Encuesta

        //Entrar encuesta normal
        Encuesta e1 = new Encuesta();
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getCreation_date());  //nose si es correcto

        //Entrar encuesta normal
        e1 = new Encuesta();
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getCreation_date());  //nose si es correcto

        //Entrar encuesta pasando todo
        Calendar creation_date = Calendar.getInstance();
        ArrayList<Pregunta> alp = new ArrayList<>();
        ArrayList<Encuesta_Respondida> aler = new ArrayList<>();
         e1 = new Encuesta(0, "Encuesta_Test", creation_date, alp, aler);
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getCreation_date());  //nose si es correcto

        //Comprovar eliminar_pregunta

        //Comprovar Añadir Pregunta_pos

        //Comprovar Añadir Pregunta_final

        //Comprovar Modificar Preguntes.Pregunta

        //Comprovar Modificar Preguntes.Pregunta Indice

        //Comprovar Responder_interactivo

    }
}
