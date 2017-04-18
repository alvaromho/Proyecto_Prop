package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Texto extends Respuesta {


    private static ArrayList<String> diccionario = new ArrayList<>();

    private P_Texto pregunta;
    private String valor;

    public R_Texto(R_Texto otro) {
        super(otro);
        this.pregunta = otro.pregunta;
        this.valor = otro.valor;
    }

    public R_Texto(P_Texto pregunta) {
        super();
        this.pregunta = pregunta;

        System.out.println("Enunciado:\n\t"+ this.pregunta.getEnunciado());
        System.out.println("Ingrese su respuesta: ( '-'es igual a no contestar):");

        boolean input_correcto = false;
        Scanner scanner = new Scanner(System.in);
        do {
            String n = scanner.next();

            if (n.length() <= pregunta.getMax_length()) {

                input_correcto = true;
                if (n.compareTo("-") == 0) {
                    this.valor = "-";
                    super.setNo_contesta(true);
                } else {
                    this.valor = n;
                    super.setNo_contesta(false);
                }
            }
            else {
                System.out.println("Error, largo de respuesta excede el maximo de "+ pregunta.getMax_length() +" caracteres." );
            }

        }while(!input_correcto);

    }

    public R_Texto(P_Texto pregunta, boolean no_contesta, String valor) {
        super(no_contesta);
        this.pregunta = pregunta;
        this.valor = valor;

    }
    @Override
    public Object getValor() {return valor;}
    @Override
    public void setValor(Object valor) {this.valor = valor.toString();}

    public P_Texto getPregunta() {
        return pregunta;
    }

    public void setPregunta(P_Texto pregunta) {
        this.pregunta = pregunta;
    }


    @Override
    public float distancia(Respuesta respuesta) {
        String valor_1 =this.valor;
        String valor_2 = (String) respuesta.getValor();

        return (float) Lev(valor_1,valor_2) / (float) max(valor_1.length(), valor_2.length());
    }


    public static int Lev(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        // Si alguno de los strings esta vacio retornar 0
        if (i == 0 || j == 0){
            return (i >= j) ? i : j;
        }
        return Levenshtein(s1.toCharArray(),s2.toCharArray());
    }

    private static int Levenshtein(char [] s1, char [] s2) {
        int [][]distance = new int[s1.length+1][s2.length+1];
        for(int i=0;i<=s1.length;i++){
            distance[i][0]=i;
        }
        for(int j=0;j<=s2.length;j++){
            distance[0][j]=j;
        }
        for(int i=1;i<=s1.length;i++){
            for(int j=1;j<=s2.length;j++){
                distance[i][j]= min(distance[i-1][j]+1,
                                    distance[i][j-1]+1,
                                    distance[i-1][j-1]+ ((s1[i-1]==s2[j-1])?0:1));
            }
        }
        return distance[s1.length][s2.length];

    }

    public static int min(int a, int b, int c){
        return (a <= b) ? (a <= c ) ? a : c : (b <= c) ? b : c;
    }

    public  static int max(int a, int b) {
        return (a >= b) ? a : b;
    }


    @Override
    public void Calcular_Centroide (ArrayList<Encuesta_Respondida> muestra, int index_respuesta) {

        // 1- crear arraylist solo con una instancia de cada palabra con sentido semantico //TODO SENTIDO SEMANTICO
        ArrayList<String> respuestas = new ArrayList<>();
        ArrayList<String> respuestas_filtradas = new ArrayList<>();

        for (Encuesta_Respondida encuesta_respondida : muestra) {

            String valor = (String) encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor();
            String[] valores = valor.split("\\s+");

            for (String s : valores) {
                respuestas.add(s);
            }
        }
        for (String s : respuestas) {
            if (!respuestas_filtradas.contains(s)) {
//                System.out.println("agregado");
                respuestas_filtradas.add(s);
            }
        }

        // 2 - crear int[] para almacenar la frecuencia de cada posible respuesta
        int[] frecuencias = new int[respuestas_filtradas.size()];


        for (int i = 0; i < respuestas_filtradas.size(); i++) {
            frecuencias[i] = Collections.frequency(respuestas, respuestas_filtradas.get(i));
//            System.out.println("f: "+frecuencias[i]);
        }
        // 3 - Encontrar maximo (frecuencia)
        int index_frecuencia_maxima = max_int_de_lista(frecuencias);
        // 5 - retornar valor con el mayor numero de frecuencias
//        System.out.println("index " + index_frecuencia_maxima);
//        System.out.println("palabra " + respuestas_filtradas.get(index_frecuencia_maxima));
        this.setValor(respuestas_filtradas.get(index_frecuencia_maxima));

    }


    public static int max_int_de_lista(int[] lista){
        int max = 0;
        int max_index = 0;
        for (int i = 0; i < lista.length; i++ ) {
            if (max <= lista[i]){
                max = lista[i];
                max_index = i;
            }
        }
        return max_index;
    }
}
