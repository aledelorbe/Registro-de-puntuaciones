
package datos;

import domain.Jugador;
import excepciones.*;
import java.io.*;
import java.util.*;


public class AccesoDatosImp implements IAccesoDatos{

       
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Jugador> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Jugador> listaJugador = new ArrayList();
        File archivo = new File(nombreArchivo);
        Jugador juga;
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea=lector.readLine())!=null)
            {
                String atributos[] = linea.split(",");
                juga = new Jugador( atributos[0], Long.parseLong(atributos[1]) );
                listaJugador.add(juga);
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar jugadores: "+ ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return listaJugador;
    }

    @Override
    public void escribir(Jugador jugador, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter escritor = new PrintWriter(new FileWriter(archivo, anexar));
            escritor.println(jugador);
            escritor.close();
            System.out.println("Se ha escrito correctamenta informacion en el archivo.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir jugador: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir jugador: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        int coincidencia=0;
        int numeroLinea=0;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea=lector.readLine())!=null)
            {
                numeroLinea++;
                if(linea.equalsIgnoreCase(buscar))
                {
                    coincidencia=1;
                    break;
                }
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar jugador: "+ ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar jugador: "+ ex.getMessage());
        }
        
        if(coincidencia==1)
            return "Se encontro la jugador \"" + buscar + "\" en la linea "+numeroLinea;
        else
            return "No se encontro la jugador. ";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escritor = new PrintWriter(archivo);
            escritor.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx ("Excepcion al crear archivo: "+ ex.getMessage());
        }
    }


    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        
        if(archivo.exists())
        {
           if(archivo.delete())
            System.out.println("El archivo pudo ser borrado correctamente.");
           else
            System.out.println("El archivo no pudo ser borrado"); 
        }
    }
    
}
