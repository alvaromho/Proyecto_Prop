package clases;

import java.util.ArrayList;

/**
 * Created by polmoyabetriu on 10/4/17.
 */
public class P_Gradual extends Pregunta {

    protected ArrayList<String> enunciado_opcion = new ArrayList<>();

    public P_Gradual() {


    }

    public P_Gradual(String enunciado, ArrayList<String> enunciado_opcion) {
        super(enunciado);
        this.enunciado_opcion = enunciado_opcion;
    }

    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }
}
