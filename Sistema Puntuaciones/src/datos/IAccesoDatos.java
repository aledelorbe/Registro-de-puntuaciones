
package datos;

import domain.Jugador;
import excepciones.*;
import java.util.List;



public interface IAccesoDatos {
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    List<Jugador> listar(String nombre) throws LecturaDatosEx;
    
    void escribir(Jugador jugador, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
