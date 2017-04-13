package clases;

import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Numerico extends Respuesta {

    private P_Numerico pregunta;
    private int valor;


    public R_Numerico(P_Numerico pregunta) {
        super();
        this.pregunta = pregunta;

        int min = pregunta.getMin();
        int max = pregunta.getMax();


        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());
        System.out.println("Ingrese un número entre ["+min+ " y "+max+"] ( -1 es igual a no contestar):");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == -1){
            this.valor = 0;
            super.setNo_contesta(true);
        } else {
            this.valor = n;
            super.setNo_contesta(false);
        }

    }

    public R_Numerico(P_Numerico pregunta, boolean no_contesta, int valor) {
        super( no_contesta);
        this.pregunta = pregunta;
        this.valor = valor;
    }


    @Override
    public Object getValor() {return valor;}

    public void setValor(int valor) {this.valor = valor;}

    public P_Numerico getPregunta() {return pregunta;}

    public void setPregunta(P_Numerico pregunta) {this.pregunta = pregunta;}

    /*
            Calculo de distancia para respuestas de tipo númerico
     */
    @Override
    public float distancia(Respuesta respuesta) {
        // conseguir  primer valor (this)
        int valor_1  = (int) this.getValor();
        // conseguir segundo valor
        int valor_2 = (int) respuesta.getValor();

        // conseguir min y max
        int min = this.pregunta.getMin();
        int max = this.pregunta.getMax();

        // formula de distancia


        float distancia = 0;
        distancia = (float) Math.abs(valor_1 - valor_2) /(float)(max - min);
        return distancia;
    }
}
