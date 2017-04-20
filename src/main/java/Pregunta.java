import java.util.Scanner;

public class Pregunta {

    protected int id;
    protected String enunciado;

    protected static int id_count = 1;

    //Constructor
    public Pregunta() {
        this.id = id_count;
        ++id_count;
        System.out.println("Introduce el enunciado para la Pregunta:");
        Scanner scanner = new Scanner(System.in);
        this.enunciado = scanner.next();
    }

    //Constructor
    public Pregunta(String enunciado) {
        this.id = id_count;
        ++id_count;
        this.enunciado = enunciado;
    }

    public int getId_pregunta() {
        return id;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id = id_pregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

}