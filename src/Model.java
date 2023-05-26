import java.util.ArrayList;
import java.util.Observable;

/**
 * Clase que representa el modelo de coches.
 * Extiende la clase Observable para permitir la notificación de cambios a los observadores.
 */
public class Model extends Observable {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo agrega al parking.
     * @param modelo el modelo del coche.
     * @param matricula la matrícula única del coche.
     * @return el coche creado.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Cambia la velocidad de un coche dado su matrícula.
     * @param matricula la matrícula del coche.
     * @param v la nueva velocidad.
     * @return la velocidad modificada.
     */
    public Integer cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Busca un coche en el parking según su matrícula.
     * @param matricula la matrícula del coche a buscar.
     * @return el coche correspondiente o null si no se encuentra.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Incrementa la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula la matrícula del coche.
     */
    public void subirVelocidad(String matricula) {
        getCoche(matricula).velocidad += 10;
        setChanged();
        notifyObservers(getCoche(matricula));
    }

    /**
     * Decrementa la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula la matrícula del coche.
     */
    public void bajarVelocidad(String matricula) {
        getCoche(matricula).velocidad -= 10;
        setChanged();
        notifyObservers(getCoche(matricula));
    }

    /**
     * Obtiene la velocidad de un coche según su matrícula.
     * @param matricula la matrícula del coche.
     * @return la velocidad del coche.
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
