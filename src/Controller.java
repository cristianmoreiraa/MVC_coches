public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();

    /**
     * Método principal que inicia la aplicación.
     * Crea un objeto de tipo ObsExceso y lo añade como observador al modelo.
     * Crea la ventana de la interfaz de usuario.
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        ObsExceso miObserver = new ObsExceso();
        miModelo.addObserver(miObserver);
        IU.crearVentana();
    }

    /**
     * Método para crear un nuevo coche.
     * Crea un coche en el modelo y muestra la velocidad en la vista.
     * @param modelo el modelo del coche.
     * @param matricula la matrícula del coche.
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo, matricula);
        if(aux != null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * Método para disminuir la velocidad de un coche.
     * Llama al método bajarVelocidad del modelo.
     * @param matricula la matrícula del coche.
     */
    public static void bajarVelocidad(String matricula){
        miModelo.bajarVelocidad(matricula);
    }

    /**
     * Método para aumentar la velocidad de un coche.
     * Llama al método subirVelocidad del modelo.
     * @param matricula la matrícula del coche.
     */
    public static void aumentarVelocidad(String matricula){
        miModelo.subirVelocidad(matricula);
    }

    /**
     * Método para buscar un coche y mostrarlo en la vista.
     * Llama al método getCoche del modelo y al método muestraCoche de la vista.
     * @param matricula la matrícula del coche.
     */
    public static void buscarCoche(String matricula){
        Coche aux = miModelo.getCoche(matricula);
        miVista.muestraCoche(aux, matricula);
    }
}
