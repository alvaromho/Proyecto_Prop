package clases;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println(" Hola mundo!");


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
