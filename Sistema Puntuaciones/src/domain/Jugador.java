
package domain;

public class Jugador implements Comparable<Jugador>{
    
    private String nickname;
    private long puntuacion;
    private final int idJugador;
    
    public final static int MAX_JUGADORES=10;
    public static int contadorJugadores;
    
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
