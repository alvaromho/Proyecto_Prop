package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Multiopcion extends Respuesta {

    private P_Multiopcion pregunta;
    private String valor;

    // Constructor interactivo

    public R_Multiopcion(P_Multiopcion pregunta) {
        super();
        this.pregunta = pregunta;


        int i = 0;
        int min = pregunta.getMin_alternativas();
        int max = pregunta.getMax_alternativas();
        int numero_de_alternativas = 0;
        String valores = "";

        Scanner scanner = new Scanner(System.in);


        ArrayList<String> alternativas = pregunta.getEnunciado_opcion();
        String alternativas_escogidas = "";

        /*
        *   Imprimir enunciado e instrucciones
        */
        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());
        for (String opcion : alternativas){
            System.out.println( "("+ ++i +") - "+ opcion);
        }


        /*
            Pedir al usuario que elija una cantidad de alternativas a elegir
         */
        boolean cantidad_de_alternativas_correcta = false;
        do {

            System.out.println("¿Cuantas alternativas desea elegir? Debe elegir entre " + min + " y " + max + ".");

            numero_de_alternativas = scanner.nextInt();
            if (numero_de_alternativas < min || numero_de_alternativas > max) {
                System.out.println("Numero ingresado no pertenece al rango");
            } else {
                cantidad_de_alternativas_correcta = true;
            }
        } while (!cantidad_de_alternativas_correcta);


        i = 0;

        /*

         */
        System.out.println("Ingresar alternativas.");
        // Imprimir alternativas
        for (String opcion : alternativas) {
            System.out.println("(" + ++i + ") - " + opcion);
        }

        if (numero_de_alternativas != 0) {

             for (i = 1; i <= numero_de_alternativas; i++) {

                 boolean opcion_valida = false;
                 do {

                     System.out.println("Eleccion numero " + i + ":");

                     int opcion = scanner.nextInt();
                     if (opcion > 0 && opcion <= alternativas.size() && !alternativas_escogidas.contains(""+opcion)) {
                         opcion_valida = true;
                         alternativas_escogidas += opcion + " ";
                     } else {
                         System.out.println("Intente nuevamente.");
                     }
                 } while (!opcion_valida);
             }

             for (i = 1; i <= alternativas.size(); i++) {
                 if (alternativas_escogidas.contains("" + i + "")) {
                     valores += "1";
                 } else {
                     valores += "0";
                 }
             }
             super.setNo_contesta(false);
             this.valor = valores;

         } else {
            super.setNo_contesta(true);
            this.valor = "";
         }



    }

    public R_Multiopcion(P_Multiopcion pregunta, boolean no_contesta, boolean valor[]) {
        super(no_contesta);
        this.pregunta = pregunta;
        String string_valor = "";

        for (int i = 0 ; i< valor.length ; i++ ){
            if (valor[i] == true){
                string_valor += "1";
            }else {
                string_valor += "0";
            }
        }
        this.valor = string_valor;
    }


    @Override
    public Object getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}

    public P_Multiopcion getPregunta() {return pregunta;}

    public void setPregunta(P_Multiopcion pregunta) {this.pregunta = pregunta;}


    @Override
    public float distancia(Respuesta respuesta) {
        // conseguir  primer valor (this)
        String valor_1 = (String) this.getValor();
        // conseguir segundo valor
        String valor_2 = (String) respuesta.getValor();
        int numero_de_alternativas_posibles = this.pregunta.getMin_alternativas();

        float distancia = 0;


        // calcular # respuesta iguales
        int interseccion_conjuntos_iguales = 0;
        int union_conjuntos_respuesta = 0;
        for (int i = 0; i < valor_1.length(); i++) {
            if (valor_1.toCharArray()[i] == valor_2.toCharArray()[i] && valor_1.toCharArray()[i] == '1') {
                interseccion_conjuntos_iguales++;
            }
            if (valor_1.toCharArray()[i] == '1' || valor_2.toCharArray()[i] == '1') {
                union_conjuntos_respuesta++;
            }
        }

        distancia = (float) 1 - (float) (interseccion_conjuntos_iguales) / (float) (union_conjuntos_respuesta);

        return distancia;
    }
}
