public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        IU.crearVentana();
    }


    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * Método bajar velocidad de un coche
     * @param matricula -> matricula del coche a disminuir su velocidad
     */
    public static void bajarVelocidad(String matricula){
        int aux = miModelo.bajarVelocidad(matricula);
        miVista.muestraVelocidad(matricula, aux);
    }

    public static void aumentarVelocidad(String matricula){
        //Recoge la velocidad del metodo subir velocidad del model y lo guarda en una auxiliar
        int aux = miModelo.subirVelocidad(matricula);
        //llama a la vista para que muestre su velocidad
        miVista.muestraVelocidad(matricula,aux);
    }

    /**
     * Método buscar en el garaje que muestre el coche, a noser que no exista
     * @param matricula -> matricula del coche
     */
    public static void mostrarGaraje(String matricula){
        //recoge el coche del modelo
        Coche aux = miModelo.getCoche(matricula);
        //llama a la vista para que muestre el coche
        miVista.mostrarGaraje(aux, matricula);
    }
}