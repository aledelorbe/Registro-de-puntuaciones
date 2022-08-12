
package negocio;

// Interface en la que se declaran los metodos pertienentes que debera tener
// la clase puntuaciones.
public interface IPuntuaciones {
    
    void iniciarArchivo(String nombreArchivo);
    
    void agregarJugador();
    
    void cargarJugadores(String nombreArchivo);
    
    void ordenarJugadores();
    
    void mostrarJugadores();
    
    void guardarPuntuaciones(String nombreArchivo);
}
