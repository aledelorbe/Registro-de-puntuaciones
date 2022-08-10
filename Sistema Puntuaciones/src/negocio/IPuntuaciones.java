
package negocio;

import domain.Jugador;
import java.util.List;


public interface IPuntuaciones {
    
    void iniciarArchivo(String nombreArchivo);
    
    void agregarJugador();
    
    void cargarJugadores(String nombreArchivo);
    
    void ordenarJugadores();
    
    void mostrarJugadores();
    
    void guardarPuntuaciones(String nombreArchivo);
}
