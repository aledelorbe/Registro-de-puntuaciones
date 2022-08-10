
package test;

import domain.Jugador;
import java.util.Scanner;
import negocio.*;

public class Main {
    public static void main(String[] args) {

        final String NOMBRE_ARCHIVO = "Puntuaciones.txt";
        Scanner lect = new Scanner(System.in);
        int opcion = -1;
        IPuntuaciones puntu = new PuntuacionesImp();
        
        do{
            System.out.println("\n1. Nuevas Puntuaciones.");
            System.out.println("2. Cargar Puntuaciones.");
            System.out.println("0. Salir.");

            System.out.print("\nSeleccione una opcion: ");
            String opcionS = lect.nextLine();
            
            if(opcionS.isEmpty())
            {
                System.out.println("Error. Opcion Invalida. Intente de nuevo.");
                continue;
            }
            opcion=Integer.parseInt(opcionS);
            
            switch(opcion)
            {
                case 1:
                    puntu.iniciarArchivo(NOMBRE_ARCHIVO);
                    menu(puntu,NOMBRE_ARCHIVO);
                    break;
                case 2:
                    puntu.cargarJugadores(NOMBRE_ARCHIVO);
                    menu(puntu,NOMBRE_ARCHIVO);
                    break;
                case 0:
                    System.out.println("Gracias por su preferencia.");
                    break;
                default:
                    System.out.println("Opcion Invalida. Intentelo otra vez.");
            }
            
        }while(opcion!=0);
    }
    
    
    public static void menu( IPuntuaciones puntu, String NOMBRE_ARCHIVO ){
        
        Scanner lect = new Scanner(System.in);
        int opcion = -1;
        
        do{
            System.out.println("\n1. Agregar Nuevo Jugador.");
            System.out.println("2. Mostrar Jugadores.");
            System.out.println("0. Salir.");

            System.out.print("\nSeleccione una opcion: ");
            String opcionS = lect.nextLine();
            
            if(opcionS.isEmpty())
            {
                System.out.println("Error. Opcion Invalida. Intente de nuevo.");
                continue;
            }
            opcion=Integer.parseInt(opcionS);
            
            switch(opcion)
            {
                case 1:
                    puntu.agregarJugador();
                    break;
                case 2:
                    puntu.ordenarJugadores();
                    puntu.mostrarJugadores();
                    break;
                case 0:
                    puntu.iniciarArchivo(NOMBRE_ARCHIVO);
                    puntu.ordenarJugadores();
                    puntu.guardarPuntuaciones(NOMBRE_ARCHIVO);
                    System.out.println("\nGracias por su preferencia.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida. Intentelo otra vez.");
            }
        }while(opcion!=0);
    }
}
