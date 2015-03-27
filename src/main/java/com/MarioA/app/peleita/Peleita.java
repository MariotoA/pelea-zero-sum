package com.MarioA.app.peleita;

import java.util.ArrayList;
import java.util.List;

import com.MarioA.app.peleita.PeleitaAction.Punch;

import aima.core.search.adversarial.Game;

public class Peleita implements Game<PeleitaState, PeleitaAction, PeleitaPlayer>{
	private PeleitaPlayer jugador1, jugador2;
	
	public List<PeleitaAction> getActions(PeleitaState state) {
		List<PeleitaAction> movimientos = new ArrayList<PeleitaAction>();
		int turno = state.getTurno();
		for(Punch p : Punch.values())
			movimientos.add(new PeleitaAction(turno,p));
		
		return movimientos;
	}

	public PeleitaState getInitialState() {
		return new PeleitaState();
	}
	/**
	 * Devuelve el jugador al que le toca.
	 */
	public PeleitaPlayer getPlayer(PeleitaState state) {
		
		return state.getTurno()==this.jugador1.getNumPlayer()? 
			this.jugador1 :
				this.jugador2 ;
	}
	/**
	 * Devuelve los jugadores de la partida.
	 */
	public PeleitaPlayer[] getPlayers() {
		PeleitaPlayer[] jugs = {jugador1,jugador2};
		return jugs;
	}

	public PeleitaState getResult(PeleitaState state, PeleitaAction move) {
		PeleitaState aux = new PeleitaState(state);
		aux.decreaseVidaJugador(move.damage());
		return aux;
	}
	public double getUtility(PeleitaState state, PeleitaPlayer player) {
		return state.getTurno() == player.getNumPlayer() ? 1: -1;
	}

	public boolean isTerminal(PeleitaState state) {
		return state.getVidaJugadorUno()==0 || state.getVidaJugadorDos()==0;
	}

}
