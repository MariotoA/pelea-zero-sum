package com.MarioA.app.peleita;

public class PeleitaAction {
	private int turno;
	private Punch punch;

	public enum Punch {
		Upper, Jab, Hook
	}

	public PeleitaAction(int t, Punch p) {
		this.turno = t;
		this.punch = p;
	}

	public Punch getPunch() {
		return punch;
	}

	public int getVidaContrincante() {
		return this.turno;
	}

	public int damage() {
		int res = 0;
		switch (punch) {
		case Upper:
			res = 3;
			break;
		case Jab:
			res = 1;
			break;
		case Hook:
			res = 2;
			break;
		default: 
			;
		}
		return res;
	}

	public boolean isValid(PeleitaState state) {
		return true;
	}
}
