
package test;

import java.util.Scanner;
import negocio.*;

public class Main {
    public static void main(String[] args) {

        final String NOMBRE_ARCHIVO = "Puntuaciones.txt";
        Scanner lect = new Scanner(System.in);
        int opcion = -1;
        IPuntuaciones puntu = new PuntuacionesImp();
        
        do{
            // Creacion del menu junto con las opciones.
            System.out.println("\n1. Nuevas Puntuaciones.");
            System.out.println("2. Cargar Puntuaciones.");
            System.out.println("0. Salir.");

            System.out.print("\nSeleccione una opcion: ");
            String opcionS = lect.nextLine();
            
            // Si el usuario no escribio nada, avisarle que debe hacerlo.
            if(opcionS.isEmpty())
            {
                System.out.println("Error. Opcion Invalida. Intente de nuevo.");
                continue;
            }
            opcion = Integer.parseInt(opcionS);
            
            switch(opcion)
            {
                case 1:
                    // si se presiono esta opcion se manda a llamar el metodo que inicia el
                    // archivo y posteriormente se despliega otro menu.
                    puntu.iniciarArchivo(NOMBRE_ARCHIVO);
                    menu(puntu, NOMBRE_ARCHIVO);
                    break;
                case 2:
                    // si se presiono esta opcion se manda a llamar el metodo que carga los 
                    // datos del archivo y posteriormente se despliega otro menu.
                    puntu.cargarJugadores(NOMBRE_ARCHIVO);
                    menu(puntu, NOMBRE_ARCHIVO);
                    break;
                case 0:
                    System.out.println("Gracias por su preferencia.");
                    break;
                default:
                    System.out.println("Opcion Invalida. Intentelo otra vez.");
            }
            
        }while(opcion != 0);
    }
    
    
    public static void menu( IPuntuaciones puntu, String NOMBRE_ARCHIVO ){
        
        Scanner lect = new Scanner(System.in);
        int opcion = -1;
        
        do{
            // Creacion del otro menu junto con otras opciones.
            System.out.println("\n1. Agregar Nueva Puntuacion.");
            System.out.println("2. Mostrar Puntuaciones.");
            System.out.println("0. Salir.");

            System.out.print("\nSeleccione una opcion: ");
            String opcionS = lect.nextLine();
            
             // Si el usuario no escribio nada, avisarle que debe hacerlo.
            if(opcionS.isEmpty())
            {
                System.out.println("Error. Opcion Invalida. Intente de nuevo.");
                continue;
            }
            opcion=Integer.parseInt(opcionS);
            
            switch(opcion)
            {
                case 1:
                    // si se presiona esta opcion se manda a llamar el metodo que
                    // solicita los datos de un jugador.
                    puntu.agregarJugador();
                    break;
                case 2:
                    // si se presiona esta opcion se manda a llamar el metodo que
                    // ordena las puntuaciones y posteriormente manda a llamar 
                    // el metodo que muestra a los jugadores con las puntuaciones
                    // ordenadas de mayor a menor.
                    puntu.ordenarJugadores();
                    puntu.mostrarJugadores();
                    break;
                case 0:
                    // si se presiona esta opcion se manda a llamar el metodo que
                    // vuelve a crear el archivo, ordena los datos que hay en la
                    // lista y dichos datos son vaciados en el archivo.
                    puntu.iniciarArchivo(NOMBRE_ARCHIVO);
                    puntu.ordenarJugadores();
                    puntu.guardarPuntuaciones(NOMBRE_ARCHIVO);
                    System.out.println("\nGracias por su preferencia.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida. Intentelo otra vez.");
            }
        }while(opcion != 0);
    }
}
