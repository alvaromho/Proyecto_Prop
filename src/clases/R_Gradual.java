package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Gradual extends Respuesta{

    private P_Gradual pregunta;
    private int valor;

    public R_Gradual(R_Gradual otro) {
        super(otro);
        this.pregunta = otro.pregunta;
        this.valor = otro.valor;
    }

    public R_Gradual(P_Gradual pregunta) {
        super();
        this.pregunta = pregunta;

        ArrayList<String> opciones = pregunta.getEnunciado_opcion();

        int i = 0;
        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());
        System.out.println("Ingrese una opción ( 0 es igual a no contestar):");
        for (String opcion : opciones){
            System.out.println( "("+ ++i +") - "+ opcion);
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0){
            this.valor = 0;
            super.setNo_contesta(true);
        } else {
            this.valor = n;
            super.setNo_contesta(false);
        }


    }

    public R_Gradual(P_Gradual pregunta, boolean no_contesta, int valor) {
        super( no_contesta);
        this.pregunta = pregunta;
        this.valor = valor;
    }
    @Override
    public Object getValor() {return valor;}
    @Override
    public void setValor(Object valor) {this.valor = (int)valor;}

    public P_Gradual getPregunta() {
        return pregunta;
    }

    public void setPregunta(P_Gradual pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public float distancia(Respuesta respuesta) {

        // conseguir  primer valor (this)
        int valor_1  = (int) this.getValor();
        // conseguir segundo valor
        int valor_2 = (int) respuesta.getValor();

        // conseguir min y max
        int numero_de_opciones= this.pregunta.enunciado_opcion.size();

        // formula de distancia


        float distancia = 0;
        distancia = (float) Math.abs(valor_1 - valor_2) /(float)(numero_de_opciones -1);
        return distancia;
    }

    @Override
    public void Calcular_Centroide (ArrayList<Encuesta_Respondida> muestra, int index_respuesta) {

        int centroide = 0;

        for (Encuesta_Respondida encuesta_respondida : muestra)
            centroide += (int) encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor();

        this.valor =  centroide/muestra.size();


    }
}
