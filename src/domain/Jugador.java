
package domain;

public class Jugador implements Comparable<Jugador>{
    
    public final static int MAX_JUGADORES = 10; // Para almcenar solo las 10 puntuaciones mas altas.
    public static int contadorJugadores;
    
    private String nickname;
    private long puntuacion;
    private final int idJugador;
    
    public Jugador(String nickname, long puntuacion) {
        this.nickname = nickname;
        this.puntuacion = puntuacion;
        this.idJugador = ++Jugador.contadorJugadores;
    }
       
    public long getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIdJugador() {
        return this.idJugador;
    }

    @Override
    public String toString() {
        return this.nickname + "," + this.puntuacion;
    }

    // Metodo que permite ordenar de menor a mayor una lista de objetos de este tipo
    // con base al valor de determinado atributo, en este caso con base al atributo
    // puntuacion.
    @Override
    public int compareTo(Jugador o) {
        if(o.getPuntuacion()>puntuacion)
            return -1;
        else if(o.getPuntuacion()>puntuacion)
            return 0;
        else
            return 1;
    }
    
}
