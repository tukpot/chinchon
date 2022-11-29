package proyectos.poo2022.chinchon.principal;

import java.util.ArrayList;

import proyectos.poo2022.chinchon.enumerados.Evento;

public class Ronda {
    private int					turno		= 1;
    private Mazo 				mazo 		= new Mazo();
    private PilaDescarte 			pilaDescarte	= new PilaDescarte();
    private int					jugadorActual;
    private ArrayList<Jugador> 			jugadores;
    
    
    public Ronda(int jugadorMano, ArrayList<Jugador> jugadores) {
	this.jugadorActual = jugadorMano;
	this.jugadores = jugadores;
	this.resetManos();
	//this.mazo.barajar(); Comentado para pruebas
	this.mazo.repartir(this.jugadores, 7, false);
	this.pilaDescarte.añadirCarta(this.mazo.tomarCartaTope());
	    
    }
    
    private void resetManos() {
	for (int i=0; i<this.jugadores.size();i++) {
	    this.jugadores.get(i).resetMano();
	}
    }
	
    public Jugador getJugadorActual() {
	return this.jugadores.get(jugadorActual);
    }
	
    public void siguienteTurno() {
	if (this.jugadorActual<this.jugadores.size()-1) {
	    this.jugadorActual = this.jugadorActual +1;
	}
	else {
	    this.jugadorActual = 0;
	}
	this.turno++;
    }
    
    public Carta getTopePila() {
	return this.pilaDescarte.getTope();
    }

    public void tomarTopePilaDescarte(Jugador jugadorQueToma) {
	jugadorQueToma.tomarCartaPilaDescarte(this.pilaDescarte); //Añadir que no pueda tomar la carta que recién descartó
    }

    public void tomarTopeMazo(Jugador jugadorQueToma) {
	jugadorQueToma.tomarCartaMazo(this.mazo);
    }

    public void descartar(int cartaElegida, Jugador jugadorQueDescarta) {
	jugadorQueDescarta.descartarCarta(cartaElegida, this.pilaDescarte);
    }

    public void sumarPuntos() {
	for (int i = 0; i<this.jugadores.size();i++) {
	    jugadores.get(i).añadirPuntosMano();
	}
	
    }
	
	
	
	
}
