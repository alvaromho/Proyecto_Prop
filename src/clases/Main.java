package clases;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write your code here


        ArrayList<Encuesta> ll_encuestas = new ArrayList<Encuesta>();

        Scanner scanner = new Scanner(System.in);
        int opcio = Integer.parseInt(scanner.next());
        while(opcio != 0) {
            Encuesta e;
            switch (opcio) {
                case 1:
                    e = new Encuesta();
                    ll_encuestas.add(e);
                    break;
                case 2:
                    e = ll_encuestas.get(0);
                    e.responder();
                    break;

                default:

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
