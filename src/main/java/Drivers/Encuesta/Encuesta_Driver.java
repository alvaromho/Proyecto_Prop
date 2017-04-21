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
        System.out.println("Creemos nueva ");
        Pregunta p1 = new Pregunta();
        alp.add(p1);
        Pregunta p2 = new Pregunta();
        Pregunta p3 = new Pregunta();

        Pregunta p4 = new Pregunta();

        ArrayList<Encuesta_Respondida> aler = new ArrayList<>();
         e1 = new Encuesta(0, "Encuesta_Test", creation_date, alp, aler);
        System.out.println("Id de la encuesta 1: " + e1.getId());
        System.out.println("Nombre de la encuesta: " + e1.getName());
        System.out.println("Fecha de creacion: " + e1.getCreation_date());  //nose si es correcto

        //Comprovar eliminar_pregunta
        e1.eliminar_pregunta(p1);

        //Comprovar Añadir Pregunta_pos
        e1.añadir_pregunta_pos(0, p1);

        //Comprovar Añadir Pregunta_final
        e1.añadir_pregunta_final(p2);

        //Comprovar Modificar Preguntes.Pregunta
        e1.modificar_pregunta(p1, p3);

        //Comprovar Modificar Preguntes.Pregunta Indice
        e1.modificar_pregunta_indice(0, p4);

        //Comprovar Responder_interactivo
        e1.responder_interactivo();

    }
}
