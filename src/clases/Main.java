package clases;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write your code here


        ArrayList<Encuesta> ll_encuestas = new ArrayList<Encuesta>();


        System.out.println("Introduce un numero para escoger la opción que quiere realizar:");
        System.out.println("1: Crear Encuesta interactivo");
        System.out.println("2: Importar Encuesta");
        System.out.println("3: Responder Encuesta interactivo");
        System.out.println("4: Importar respuesta de una encuesta");
        System.out.println("5:");
        System.out.println("0: Fi");
        Scanner scanner = new Scanner(System.in);
        int opcio = Integer.parseInt(scanner.next());
        while(opcio != 0) {
            Encuesta e;
            switch (opcio) {
                case 1:
                    e = new Encuesta();
                    ll_encuestas.add(e);
                    break;
                case 3:
                    e = ll_encuestas.get(0);
                    e.responder();
                    break;

                default:
                    System.out.println("Opció no vàlida");
                    break;
            }
            opcio = Integer.parseInt(scanner.next());
        }


        Analisis a = new Analisis("analisis a",2);

        Analisis b = new Analisis("analisis b",2);

        Analisis c = new Analisis("analisis c",2);
        try {
            Analisis d = new Analisis("analisis d",2);
        } catch( ExceptionInInitializerError e){
            System.out.println(e);
        }

        c.print_nombres();

    }


}
