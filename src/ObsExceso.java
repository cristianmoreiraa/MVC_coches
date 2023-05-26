import java.util.Observable;
import java.util.Observer;

/**
 * Clase que implementa la interfaz Observer y se utiliza para controlar
 * el exceso de velocidad de un coche.
 */
public class ObsExceso implements Observer {
    View miVista = new View();

    /**
     * Método que se llama cuando se produce un cambio en el objeto observado.
     * @param o   el objeto observable.
     * @param arg el argumento pasado al método notifyObservers(...).
     *            En este caso, se espera que sea un objeto de tipo Coche.
     *            Si la velocidad del coche es superior a 120km/h, se muestra un aviso.
     *            Si la velocidad es menor o igual a 120km/h, se muestra la velocidad.
     */
    @Override
    public void update(Observable o, Object arg) {
        Coche obxC = (Coche) arg;
        if (obxC.velocidad > 120) {
            miVista.muestraExceso(obxC.matricula, obxC.velocidad);
        } else {
            miVista.muestraVelocidad(obxC.matricula, obxC.velocidad);
        }
    }
}
