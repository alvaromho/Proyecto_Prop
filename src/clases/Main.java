package clases;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
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
            String nom_ficher;
            int respondemos;
            switch (opcio) {
                case 1:
                    //Crear Encuesta Interactivo
                    e = new Encuesta();
                    ll_encuestas.add(e);
                    break;
                case 2:
                    //Importar Encuesta
                    System.out.println("Inserta el nombre del fichero");
                    nom_ficher = scanner.next();
                    e = new Encuesta(nom_ficher);
                    ll_encuestas.add(e);
                    break;
                case 3:
                    //Responder Encuesta Interactivo
                    System.out.println("Inserta el id de l'encuesta que quiere responder");
                    respondemos = Integer.parseInt(scanner.next());
                    e = ll_encuestas.get(respondemos);
                    e.responder_interactivo();
                    break;
                case 4:
                    //Importar Respuesta
                    System.out.println("Inserta el nombre del fichero");
                    nom_ficher = scanner.next();
                    FileReader fr = new FileReader(nom_ficher);
                    BufferedReader bf = new BufferedReader(fr);
                    respondemos = Integer.parseInt(bf.readLine());
                    e = ll_encuestas.get(respondemos);
                    e.responder_importar(nom_ficher);

                default:
                    System.out.println("Opcion no valida");
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
