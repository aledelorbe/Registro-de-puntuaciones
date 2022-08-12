
package negocio;

import datos.*;
import domain.Jugador;
import excepciones.*;
import java.util.*;


public class PuntuacionesImp implements IPuntuaciones{

    // Declaracion del atributo de tipo IAccesoDatos, de esta forma podemos
    // utilizar todos los metodos definidos en la clase Acceso Datos.
    IAccesoDatos datos;
    List<Jugador> lista;

    public PuntuacionesImp() {
        this.datos = new AccesoDatosImp();
        this.lista = new ArrayList();
    }
    
    // Metodo para iniciar con la creacion de un archivo. Si este existe, se 
    // borrar y se crea uno nuevo, en caso contrario se creara el archvo. Este
    // metodo podria arrojar una excepcion pero no de escritura o lectura, lo que
    // podria ocurrir es que no se encuentre la ruta del archivo.
    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(this.datos.existe(nombreArchivo))
            {
                this.datos.borrar(nombreArchivo);
                this.datos.crear(nombreArchivo);
            }
            else
                this.datos.crear(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso a Datos.");
            ex.printStackTrace(System.out);
        }
    }
    
    // Metodo que solicita los datos de un jugador, validando que el usuario
    // no deje en blanco alguno de estos datos. Al agregar correctamente los 
    //datos de un jugador, este sera agregado a una lista.
    @Override
    public void agregarJugador() {
        Scanner lect = new Scanner(System.in);
        Jugador jugador = null;
        long puntuacion = 0;
        String nickname = null;
        int bandera = 1;
        
        while(bandera == 1)
        {
            System.out.print("\nIngresa el nombre del jugador: ");
            nickname = lect.nextLine();
            System.out.print("Ingresa su puntuacion: ");
            String puntuacionS = lect.nextLine();

            if (nickname.isEmpty() || puntuacionS.isEmpty()) {
                System.out.println("Error. No debe dejar alguno de estos campos vacio. Intente de nuevo.\n");
                continue;
            }
            bandera--;
            puntuacion = Long.parseLong(puntuacionS); 
        }
        
        jugador = new Jugador(nickname, puntuacion );
        this.lista.add(jugador);
        System.out.println("\nJugador agregado.");
    }

    // Metodo que se encarga de leer toda la informacion que se encuentra en 
    // el archivo. Esta informacion se pasara a una lista. Puede ocurrir una 
    // excepcion a la hora de leer.
    @Override
    public void cargarJugadores(String nombreArchivo) {
        List<Jugador> jugadores = null;
        
        try {
            jugadores = this.datos.listar(nombreArchivo);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de Lectura de Datos.");
            ex.printStackTrace(System.out);
        }
        
        jugadores.forEach(elemento->{
            this.lista.add(elemento);
        });
    }
    
    // Metodo el cual se encarga de ordenar una serie de objetos que se encuentran
    // en la lista, con base al valor de cierto atributo.
    @Override
    public void ordenarJugadores(){
        
        Collections.sort(this.lista);
    }

    // Metodo que imprime la informacion de todos los jugadores que hay registrados 
    // en el sistema junto con sus respectivas puntuaciones, ordenados de mayor a menor.
    @Override
    public void mostrarJugadores( ) {
        
        if(Jugador.contadorJugadores > Jugador.MAX_JUGADORES){
            System.out.println("\n\t   Jugador     Puntuacion");
            for (int i = 0; i < 10; i++) 
                System.out.println( "\t" + (i+1) + ". " + this.lista.get( this.lista.size()-1-i ).getNickname() +
                        "\t\t" + this.lista.get( this.lista.size()-1-i ).getPuntuacion());
        }
        else{
            System.out.println("\n\t   Jugador    Puntuacion");
            for (int i = 0; i < Jugador.contadorJugadores; i++) 
                System.out.println( "\t" + (i+1) + ". " + this.lista.get( this.lista.size()-1-i ).getNickname() +
                        "\t\t" + this.lista.get( this.lista.size()-1-i ).getPuntuacion());
        }
    }
    
    // Metodo el cual almacenara en el archivo toda la informacion que hay 
    // guardada en la lista.
    @Override
    public void guardarPuntuaciones(String nombreArchivo){
        
        if(Jugador.contadorJugadores>Jugador.MAX_JUGADORES){
            for (int i = 0; i < 10; i++) 
            {
               try {
                    this.datos.escribir(this.lista.get( this.lista.size()-1-i ), nombreArchivo, true);
                } catch (EscrituraDatosEx ex) {
                    System.out.println("Error de Escritura de Datos.");
                    ex.printStackTrace(System.out);
                } 
            }
        }
        else{
            for (int i = 0; i < Jugador.contadorJugadores; i++) 
            {
               try {
                    this.datos.escribir(this.lista.get( this.lista.size()-1-i ), nombreArchivo, true);
                } catch (EscrituraDatosEx ex) {
                    System.out.println("Error de Escritura de Datos.");
                    ex.printStackTrace(System.out);
                } 
            }
        }
    }
}
