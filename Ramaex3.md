# Trabajamos desde la Rama x3

- Hacemos que la Interfaz y el Dialogo se muestren en el medio de la pantalla
- Añadimos el método para poder buscar el coche en el Garaje en caso de que exista

En esta rama básicamente he agregado la función de búsqueda de coches. Para lograrlo, creamos un método estático llamado "buscarCoche" que recibe la matrícula del automóvil del cual queremos mostrar la información. Este método obtiene el automóvil utilizando un auxiliar del método "getCoche()" del *modelo*. Luego, llama a la *vista* para mostrar el automóvil. En la View, he creado un método llamado "mostrarGaraje()" que recibe el auxiliar de automóvil del controlador y la matrícula. Aquí se verifica si el auxiliar es nulo. Si es así, se muestra un mensaje en el diálogo indicando que no existe un automóvil con esa matrícula. En caso de que el automóvil exista, se muestra toda la información del automóvil a través del diálogo.
