/**
 * Clase View que representa la vista del modelo MVC para el sistema de coches.
 */
public class View {
    /**
     * Método para mostrar la velocidad actual del coche.
     *
     * @param matricula matrícula del coche
     * @param v         velocidad del coche
     */
    void muestraVelocidad(String matricula, Integer v) {
        Dialog.vDialogo("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }

    /**
     * Método para mostrar la información del coche o indicar que no existe el coche.
     *
     * @param aux       objeto Coche que representa el coche a mostrar
     * @param matricula matrícula del coche (en caso de no existir)
     */
    void muestraCoche(Coche aux, String matricula) {
        if (aux == null) {
            Dialog.vDialogo("No existe el coche con la matrícula: " + matricula);
        } else {
            Dialog.vDialogo("El " + aux.modelo + " con la matrícula: " + aux.matricula + " tiene una velocidad de: " + aux.velocidad + "km/h");
        }
    }

    /**
     * Método para mostrar una alerta de exceso de velocidad.
     *
     * @param matricula matrícula del coche
     * @param v         velocidad del coche
     */
    void muestraExceso(String matricula, Integer v) {
        Dialog.vDialogo("Alerta: el coche " + matricula + " ha superado los 120km/h, circula a: " + v + "km/h");
    }
}
