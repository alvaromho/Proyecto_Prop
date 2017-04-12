package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Texto extends Respuesta {

    private P_Texto pregunta;
    private String valor;


    public R_Texto(P_Texto pregunta) {
        super();
        this.pregunta = pregunta;


        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());
        System.out.println("Ingrese su respuesta: ( '-'es igual a no contestar):");

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();

        if (n.compareTo("-") == 0){
            this.valor = "-";
            super.setNo_contesta(true);
        } else {
            this.valor = n;
            super.setNo_contesta(false);
        }

    }

    public R_Texto(P_Texto pregunta, boolean no_contesta, String valor) {
        super(no_contesta);
        this.pregunta = pregunta;
        this.valor = valor;

    }
    @Override
    public Object getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}

    public P_Texto getPregunta() {
        return pregunta;
    }

    public void setPregunta(P_Texto pregunta) {
        this.pregunta = pregunta;
    }


    @Override
    public float distancia(Respuesta respuesta) {
        return super.distancia(respuesta);
    }
}
