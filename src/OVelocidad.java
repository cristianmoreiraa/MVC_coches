import java.util.Observable;
import java.util.Observer;

/**
 * Clase observadora que implementa la interfaz Observer.
 * Observa cuando cambia la velocidad de un coche.
 */
public class OVelocidad implements Observer {
    View miVista = new View();

    /**
     * Método que se ejecuta cuando se actualiza el estado del objeto observable.
     * @param o el objeto observable.
     * @param arg el argumento pasado al método notifyObservers.
     */
    @Override
    public void update(Observable o, Object arg) {
        Coche obxC = (Coche) arg;
        miVista.muestraVelocidad(obxC.matricula, obxC.velocidad);
    }
}
