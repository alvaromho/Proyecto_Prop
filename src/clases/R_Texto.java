package clases;

import java.util.ArrayList;
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

        //Crear diccionario
        ArrayList<String> diccionario = new ArrayList<>();
        for (Encuesta_Respondida encuesta_respondida : muestra){
            agregar_al_diccionario(diccionario,(String)encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor());
        }
        for (String s : diccionario)
            System.out.println(s);


    }
    // Agrega palabras al diccionario
    public void agregar_al_diccionario(ArrayList<String> diccionario, String string){
        for (String s : string.split("\\s+"))
            if (!diccionario.contains(s)) diccionario.add(s);
    }

    // borra caracteres especiales y cambia las mayusculas por minusculas
    public String limpiar_string(String string){
        return  string.replaceAll("[^a-zA-Z]+"," ").toLowerCase();
    }

}
