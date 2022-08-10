
package negocio;

import datos.*;
import domain.Jugador;
import excepciones.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PuntuacionesImp implements IPuntuaciones{

    IAccesoDatos datos;
    List<Jugador> lista;

    public PuntuacionesImp() {
        this.datos = new AccesoDatosImp();
        this.lista = new ArrayList();
    }
    
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
    
    @Override
    public void agregarJugador() {
        Scanner lect = new Scanner(System.in);
        Jugador jugador = null;
        long puntuacion = 0;
        String nickname = null;
        int bandera=1;
        
        while(bandera==1)
        {
            System.out.print("Ingresa el nombre del jugador: ");
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
        System.out.println("Jugador agregado.");
    }

  
    @Override
    public void cargarJugadores(String nombreArchivo) {
        List<Jugador> jugadores=null;
        
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
    
    @Override
    public void ordenarJugadores(){
        
        Collections.sort(this.lista);
    }
    
    @Override
    public void mostrarJugadores( ) {
        
        if(Jugador.contadorJugadores>Jugador.MAX_JUGADORES){
            for (int i = 0; i < 10; i++) 
                System.out.println( "\t"+(i+1)+"- "+this.lista.get( this.lista.size()-1-i ));
        }
        else{
            for (int i = 0; i < Jugador.contadorJugadores; i++) 
                System.out.println( "\t"+(i+1)+"- "+this.lista.get( this.lista.size()-1-i ));
        }
    }
    
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
