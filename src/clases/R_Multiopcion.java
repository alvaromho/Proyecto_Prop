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

        boolean cantidad_de_alternativas_correcta = false;


        ArrayList<String> alternativas = pregunta.getEnunciado_opcion();
        String alternativas_escogidas = "";

        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());

        //System.out.println("Ingrese las alternativas a escoger. Debe elegir entre "+min+" y "+max+" alternativas.");

        for (String opcion : alternativas){
            System.out.println( "("+ ++i +") - "+ opcion);
        }
        while (cantidad_de_alternativas_correcta) {

            System.out.println("¿Cuantas alternativas desea elegir? Debe elegir entre " + min + " y " + max + ".");

            numero_de_alternativas = scanner.nextInt();
            if (numero_de_alternativas < min || numero_de_alternativas > max) {
                System.out.println("Numero ingresado no pertenece al rango");
            } else {
                cantidad_de_alternativas_correcta = true;
            }
        }
         if (numero_de_alternativas != 0) {
             System.out.println("Ingrese las alternativas a escoger.");
             for (String opcion : alternativas) {
                 System.out.println("(" + ++i + ") - " + opcion);
             }

             System.out.println("Ingresar numero de alternativa a elegir.");

             for (i = 1; i <= numero_de_alternativas; i++) {

                 boolean opcion_valida = false;
                 do {

                     System.out.println("Eleccion numero " + ++i + ":");

                     int opcion = scanner.nextInt();
                     if (opcion < 0 || opcion > alternativas.size() || alternativas_escogidas.contains("" + opcion + "")) {
                         opcion_valida = true;
                     }
                     alternativas_escogidas += opcion + " ";
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
        return super.distancia(respuesta);
    }
}
