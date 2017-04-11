package clases;

import java.util.ArrayList;

/**
 * Created by polmoyabetriu on 10/4/17.
 */
public class P_Gradual extends Pregunta {

    protected ArrayList<String> enunciado_opcion;



    public P_Gradual(int id_pregunta, String enunciado, boolean no_sabe) {
        super(id_pregunta, enunciado, no_sabe);
    }

    public P_Gradual(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }

    public P_Gradual() {
        super();
    }

    public ArrayList<String> getEnunciado_opcion() {
        return enunciado_opcion;
    }

    public void setEnunciado_opcion(ArrayList<String> enunciado_opcion) {
        this.enunciado_opcion = enunciado_opcion;
    }
}
