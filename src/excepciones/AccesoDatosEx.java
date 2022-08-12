
package excepciones;


public class AccesoDatosEx extends Exception{
    
    // Creacion de las excepciones (en gral) que puede haber al realizar operaciones
    // con un archivo.
    public AccesoDatosEx(String mensaje){
	super(mensaje);
    }
}
