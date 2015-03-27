package com.MarioA.app.peleita;



public class PeleitaState {
	public static final int VIDAMAXIMAESTANDAR = 20;
	private int vidaJugadorUno;
	private int vidaJugadorDos;
	private int turno; // 1 -> jugadorUno, 2 -> jugadorDos

	public PeleitaState() {
		this.vidaJugadorUno = VIDAMAXIMAESTANDAR;
		this.vidaJugadorDos = VIDAMAXIMAESTANDAR;
		this.turno = 1;
	}
	
	public PeleitaState(PeleitaState state) {
		this.vidaJugadorUno = state.vidaJugadorUno;
		this.vidaJugadorDos = state.vidaJugadorDos;
		this.turno = state.turno;
	}
	
	/**
	 * Devuelve cuánta vida le queda al jugador 1.
	 * */
	public int getVidaJugadorUno() {
		return this.vidaJugadorUno;
	}

	/**
	 * Devuelve cuánta vida le queda al jugador 2.
	 * */
	public int getVidaJugadorDos() {
		return this.vidaJugadorDos;
	}

	/**
	 * Devuelve de quién es el turno en ese momento de la partida. Un entero lo
	 * indica.
	 * 
	 * */
	public int getTurno() {
		return this.turno;
	}

	/**
	 * Pasa a turno del contrincante.
	 */
	public void cambiaTurno() {
		this.turno = this.turno == 1 ? 2 : 1;
	}

	/**
	 * 
	 */
	public void decreaseVidaJugador(int damage) {
		if (damage < 0) {
			throw new PeleitaException(
					"El parámetro vida no puede ser negativo.");
		}
		if(this.turno==1){
			this.vidaJugadorUno -= damage;
		} else{
			this.vidaJugadorDos -= damage;
		}
		
		if(this.vidaJugadorUno<0){
			this.vidaJugadorUno = 0;
		}
		if(this.vidaJugadorDos<0){
			this.vidaJugadorDos=0;
		}
	}
}
