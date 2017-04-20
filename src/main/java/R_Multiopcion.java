import java.util.*;

/**
 * Created by Alvaro Muñoz.
 */
public class R_Multiopcion extends Respuesta {

    private P_Multiopcion pregunta;
    private boolean []valor;

    public R_Multiopcion(R_Multiopcion otro) {
        super(otro);
        this.pregunta = otro.pregunta;
        this.valor = otro.valor;
    }

    // Constructor interactivo
    public R_Multiopcion(P_Multiopcion pregunta) {
        super();
        this.pregunta = pregunta;


        int i = 0;
        int min = pregunta.getMin_alternativas();
        int max = pregunta.getMax_alternativas();
        int numero_de_alternativas = 0;

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

            System.out.println("¿Cuantas alternativas desea elegir? Debe elegir entre " + min + " y " + max + "");

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

        // en caso de que el usuario haya elegido responder la pregunta
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
                 } while (!opcion_valida); // Comprobar que el dato ingresado sea valido
             }

             boolean[] valor = new boolean[alternativas.size()];

             for (i = 1; i <= alternativas.size(); i++) {
                 if (alternativas_escogidas.contains("" + i )) {
                     valor[i-1] = true;
                 } else {
                     valor[i-1] = false;
                 }
             }
             super.setNo_contesta(false);
             this.valor = valor;

         } else {
            super.setNo_contesta(true);
            for (boolean v : this.valor) {
                v = false;
            }
         }
    }

    public R_Multiopcion(P_Multiopcion pregunta, boolean no_contesta, boolean valor[]) {
        super(no_contesta);
        this.pregunta = pregunta;
        this.valor = valor;
    }


    @Override
    public Object getValor() {return valor;}
    @Override
    public void setValor(Object valor) {this.valor = (boolean[])valor;}

    public P_Multiopcion getPregunta() {return pregunta;}

    public void setPregunta(P_Multiopcion pregunta) {this.pregunta = pregunta;}


    @Override
    public float distancia(Respuesta respuesta) {
        // conseguir  valores
        boolean []valor_1 =  this.valor;
        boolean []valor_2 = (boolean[]) respuesta.getValor();

        // calcular # respuesta iguales
        int interseccion_conjuntos_iguales = 0;
        int union_conjuntos_respuesta = 0;
        for (int i = 0; i < valor_1.length; i++) {
            if (valor_1[i] == valor_2[i] && valor_1[i] == true)
                interseccion_conjuntos_iguales++;

            if (valor_1[i] == true || valor_2[i] == true)
                union_conjuntos_respuesta++;

        }
        return (float) 1 - (float) (interseccion_conjuntos_iguales) / (float) (union_conjuntos_respuesta);
    }

    public boolean [] calcular_moda_uniopcion( ArrayList<Encuesta_Respondida> lista_encuesta_respondida, int index_respuesta){
        // Cantidad de alternativas en la pregunta
        boolean[] valor = (boolean[]) lista_encuesta_respondida.get(0).getLl_respuesta().get(index_respuesta).getValor();
        int cantidad_alternativas = valor.length;
        // contador de repeticiones por alternativa
        int [] contador_repeticiones = new int[cantidad_alternativas];
        for (int a :contador_repeticiones) a = 0; //llenar de ceros

        for ( Encuesta_Respondida encuesta_respondida : lista_encuesta_respondida){
            valor = (boolean[]) encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor();
            for (int i = 0; i < cantidad_alternativas; i++)
                contador_repeticiones[i] += (valor[i])? 1:0;
        }

        int alternativa_moda = max_int_de_lista(contador_repeticiones);
        boolean [] moda = crear_array_boolean(cantidad_alternativas);
        moda[alternativa_moda] = true;

//        System.out.println("alt_moda "+ alternativa_moda);
//        for (int a :contador_repeticiones) System.out.println("!"+a+"!"); //llenar de ceros

        return moda;

    }


    @Override
    public void Calcular_Centroide(ArrayList<Encuesta_Respondida> muestra, int index_respuesta) {


        // 1- crear arraylist solo con una instancia de cada respuesta existente
        ArrayList<boolean[]> respuestas = new ArrayList<>();
        ArrayList<boolean[]> respuestas_filtradas = new ArrayList<>();

        for (Encuesta_Respondida encuesta_respondida : muestra) {

            respuestas.add((boolean[]) encuesta_respondida.getLl_respuesta().get(index_respuesta).getValor());
        }

        for (boolean[] b : respuestas) {
            if (!respuestas_filtradas.contains(b)) {
//                System.out.println("agregado");
                respuestas_filtradas.add(b);
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

    public static boolean[] crear_array_boolean(int largo){
        boolean[] array = new boolean[largo];
        for (int i = 0; i < largo; i++){
            array[i] = false;
        }
        return array;
    }
}
