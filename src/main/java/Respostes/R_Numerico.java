package Respostes;

import GestionEncuestas.Encuesta_Respondida;
import Preguntes.P_Numerico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Numerico extends Respuesta {

    private P_Numerico pregunta;
    private int valor;

    public R_Numerico(R_Numerico otro) {
        super(otro);
        this.pregunta = otro.pregunta;
        this.valor = otro.valor;
    }

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
    @Override
    public void setValor(Object valor) {this.valor = (int)valor;}

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

    @Override
    public void Calcular_Centroide (ArrayList<Encuesta_Respondida> muestra, int index_respuesta) {

        int sumatoria  = 0;

        for (Encuesta_Respondida encuesta_respondida : muestra)
            sumatoria += (int) encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor();

        int centroide= Math.round((float)sumatoria/(float)muestra.size());
        this.valor =  centroide;

    }
}
