# Arquitectura MVC

Esta aplicación trabaja con objetos de coche, permite modificar y mostrar la velocidad, así como también la posibilidad de mostrar toda la información del coche.

---

En esta rama se han añadido los eventos en la interfaz de usuario (IU).


### Diagrama de Clases:

````mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
          +crearCoche(String, String)
          +subirVelocidad(String)
          +bajarVelocidad(String)
          +buscarCoche(String)
      }
      class View {
        +muestraVelocidad(String, Integer) 
        +muestraCoche(Coche, String)
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
  
      class IU { mostrarVentana()}
  
      class Dialog { 
        +mostrarVelocidad(String, Integer) 
        +mostrarCoche(Coche, String)  
      }
    Controller "1" *-- "1" Model : asociación
    Controller "1" *-- "1" View : asociación
    Model "1" *-- "1..n" Coche : asociación
    View "1" *-- "1" IU : asociación
    View "1" *-- "1" Dialog : asociación
```
````

```## Evento en la Vista

Cuando ocurre un evento en la vista, el controlador debe ser notificado. Es importante tener en cuenta que en el MVC estricto, la vista no se comunica directamente con el modelo.

En el listener del botón, llamamos al controlador y este, a su vez, llama al modelo. Después de recibir los datos del modelo, el controlador llama a la vista.

````mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant Model
  
    usuario->>View: ¡Click! Crear coche
    View->>Controller: El usuario quiere crear un coche
    activate Controller
    Controller->>Model: Crea un coche, por favor
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ¡OK, coche creado!
    deactivate Controller
    View-->>usuario: ¡Tu coche se creó!
```
````

Lo mismo ocurre con los métodos para subir velocidad, bajar velocidad y ver coche, cambiando el texto por el correspondiente a cada método.

Ahora, en la parte de la arquitectura de la vista, hay tres clases:

````mermaid
sequenceDiagram
    autonumber
    actor usuario
    box gray Vista con JFrame
        participant IU
        participant Dialog
        participant View
        end
      
    participant Controller
    participant Model

    usuario->>IU: ¡Click! Crear coche
    IU->>Controller: crearCoche()
    activate Controller
    Controller->>Model: crearCoche()
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: mostrarVelocidad()
    deactivate Controller
    View-->>-Dialog: mostrarVelocidad()

```
````

Aquí, al igual que en el otro esquema, ocurre exactamente lo mismo con los otros métodos, pero con las llamadas correspondientes a cada método.

Cerrando el issue #1

En esta rama, se ha implementado la funcionalidad de buscar coches. Para ello, se ha creado un método estático llamado "buscarCoche", el cual recibe la matrícula del coche del que se desea mostrar la información.

Este método obtiene el coche mediante un auxiliar del método "getCoche" del modelo. A continuación, llama a la vista para mostrar el coche.

En la vista, se ha creado un método llamado "muestraCoche" que recibe el auxiliar del coche del controlador y la matrícula. Aquí se verifica si el auxiliar es nulo, y en caso de ser así, muestra un mensaje a través del diálogo indicando que no existe ningún coche con esa matrícula. En caso de que el coche exista, se muestra toda la información del coche mediante el diálogo.

---

## Pasos para crear el observador

1. Modelo
   * Extender de `Observable`
   * En el método donde se produce el cambio (en este caso, en "subirVelocidad" y "bajarVelocidad"):
     * Llamar a `setChanged()`
     * Notificar al observador mediante `notifyObservers(valor)`, en este caso: `notifyObservers(getCoche(matricula))`
2. Crear una clase que actúe como observador, implementando la interfaz `Observer` (ObsExceso en este ejemplo)
   * Definir el método `update()`
3. Controlador
   * Instanciar el observador definido en el punto anterior
   * Agregar este observador al objeto observado mediante `addObserver()`

---

## Evento en la Vista con el Observador

Este sería el diagrama de secuencia explicado de forma general:

````mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant Model
    participant ObsExceso
  
    usuario->>View: ¡Click! Crear coche
    View->>Controller: El usuario quiere crear un coche
    activate Controller
    Controller->>Model: Crea un coche, por favor
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ¡OK, coche creado!
    deactivate Controller
    View-->>usuario: ¡Tu coche se creó!
  
    usuario->>View: ¡Click! Subir velocidad
    View->>Controller: El usuario quiere subir la velocidad
    activate Controller
    Controller->>Model: Sube la velocidad, por favor
    activate Model
    Model-->>ObsExceso: Sube la Velocidad
    activate ObsExceso
    ObsExceso-->>View: Cambio en la velocidad
    View-->usuario: ¡Tu coche ha cambiado de velocidad! (si la velocidad supera los 120 km/h, se muestra una advertencia)

```
````

## Evento con Observador pero con los nombres de los métodos

Este es el diagrama de secuencia explicado de forma más específica:

````mermaid
sequenceDiagram
    autonumber
    actor usuario  
    participant Controller
    participant Model
    participant ObsExceso

    usuario->>IU: ¡Click! Crear coche
    IU->>Controller: crearCoche()
    activate Controller
    Controller->>Model: crearCoche()
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: mostrarVelocidad()
    deactivate Controller
    View-->>-Dialog: mostrarVelocidad()
  
    usuario->>IU: ¡Click! Subir velocidad
    IU->>Controller: subirVelocidad()
    activate Controller
    Controller->>Model: subirVelocidad()
    deactivate Controller
    activate Model
    Model-->>ObsExceso: Se ha cambiado la Velocidad
    deactivate Model
    activate ObsExceso
    ObsExceso->>+View: mostrarVelocidad() o mostrarExceso()
    deactivate ObsExceso
    View-->>-Dialog: mostrarVelocidad()

```
````
