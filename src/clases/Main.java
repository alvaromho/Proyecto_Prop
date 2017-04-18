package clases;
import java.io.*;
import java.util.*;
import java.util.Calendar.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here


        //ArrayList<Encuesta> ll_encuestas = new ArrayList<Encuesta>();


        /*System.out.println("Introduce un numero para escoger la opción que quiere realizar:");
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


        }*/

  /*      Encuesta e = new Encuesta();
        e.responder_interactivo();
        int n_encuesta_respondida = 0, n_respuesta = 0;
        System.out.println(e.getLl_encuestas_respondidas().get(n_encuesta_respondida).getLl_respuesta().get(n_respuesta).getValor());
*/
        /*P_Numerico p = new P_Numerico("enunciado", 0, 10);
        R_Numerico r1 = new R_Numerico(p, false, 0);
        R_Numerico r2 = new R_Numerico(p, false, 10);
        */
/*
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("muy mal");
        opciones.add("mal");
        opciones.add("neutro");
        opciones.add("bien");
        opciones.add("muy bien");

        P_Gradual p = new P_Gradual("enunciado", opciones);
        R_Gradual r1 = new R_Gradual(p, false, 2);
        R_Gradual r2 = new R_Gradual(p, false, 4);
*/
/*
        boolean [] valor_1 = {true, false, false, false, false};
        boolean [] valor_2 = {true, false, false, false, false};
        boolean [] valor_3 = {false, false, true, false, true};



        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("a");
        opciones.add("b");
        opciones.add("c");
        opciones.add("d");
        opciones.add("e");


        P_Multiopcion p = new P_Multiopcion("enunciado", 1,3,opciones);
        R_Multiopcion r1 = new R_Multiopcion(p, false, valor_1);
        R_Multiopcion r2 = new R_Multiopcion(p, false, valor_2);
        R_Multiopcion r3 = new R_Multiopcion(p, false, valor_3);

        System.out.println(r1.getValor());
        System.out.println(r2.getValor());
        System.out.println(r3.getValor());
        System.out.println(r1.distancia(r2));
        System.out.println(r2.distancia(r3));*/


        Analisis a = new Analisis("analisis",1);

        ArrayList<Respuesta> array_respuesta_1= new ArrayList<Respuesta>();
        ArrayList<Respuesta> array_respuesta_2= new ArrayList<Respuesta>();

        ArrayList<Encuesta_Respondida> ler1 = new ArrayList<Encuesta_Respondida>();
        ArrayList<Pregunta> array_pregunta_1 = new ArrayList<Pregunta>();

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("bien");
        opciones.add("medio");
        opciones.add("mal");
        ArrayList<String> alternativas = new ArrayList<String>();
        opciones.add("a");
        opciones.add("b");
        opciones.add("c");
        opciones.add("d");
        opciones.add("e");
        boolean [] bool_array1 = {true,false, false, false, false};
        boolean [] bool_array2 = {true,false, false, false, false};


        /*
        *
        *
        */
        P_Numerico p1 = new P_Numerico("enunciado 1", 0, 10);
        P_Numerico p2 = new P_Numerico("enunciado 2", 0, 10);
        P_Gradual p3 = new P_Gradual("enunciado 3",opciones);
        P_Multiopcion p4 = new P_Multiopcion("enunciado 3",1,1,alternativas);
        P_Texto p5 = new P_Texto("enunciado 5", 50);



        array_pregunta_1.add(p1);
        array_pregunta_1.add(p2);
        array_pregunta_1.add(p3);
        array_pregunta_1.add(p4);
        array_pregunta_1.add(p5);


        array_respuesta_1.add(new R_Numerico(p1, false, 1));
        array_respuesta_2.add(new R_Numerico(p1, false, 10));

        array_respuesta_1.add(new R_Numerico(p2, false, 2));
        array_respuesta_2.add(new R_Numerico(p2, false, 8));

        array_respuesta_1.add(new R_Gradual(p3, false, 1));
        array_respuesta_2.add(new R_Gradual(p3, false, 2));

        array_respuesta_1.add(new R_Multiopcion(p4, false, bool_array1));
        array_respuesta_2.add(new R_Multiopcion(p4, false, bool_array2));

        array_respuesta_1.add(new R_Texto(p5, false, "hola"));
        array_respuesta_2.add(new R_Texto(p5, false, "hola chao"));



        Encuesta e = new Encuesta(1,"encuesta",Calendar.getInstance(),array_pregunta_1,ler1);

        Encuesta_Respondida er1 = new Encuesta_Respondida(e,"asd",Calendar.getInstance(),array_respuesta_1);
        Encuesta_Respondida er2 = new Encuesta_Respondida(e,"asd2",Calendar.getInstance(),array_respuesta_2);

        ler1.add(er1);
        ler1.add(er2);

        System.out.println(a.distancia(er1,er2));



        Cluster c = new Cluster(ler1);
        c.Calcular_Centride(ler1);




        /*P_Texto p = new P_Texto("enunciado", 50);
        R_Texto r1 = new R_Texto(p,false, "hola");
        R_Texto r2 = new R_Texto(p,false, "respuesta2");
        R_Texto r3 = new R_Texto(p,false, "halos");
        R_Texto r4 = new R_Texto(p,false, "");*/







    }


}
