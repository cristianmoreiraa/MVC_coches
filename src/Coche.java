public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    /**
     * Constructor de la clase Coche.
     * Inicializa las propiedades del coche.
     * @param modelo el modelo del coche.
     * @param matricula la matrícula del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
