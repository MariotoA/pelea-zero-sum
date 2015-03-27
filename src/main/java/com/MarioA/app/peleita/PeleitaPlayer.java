package com.MarioA.app.peleita;

public class PeleitaPlayer {
	private String nombre;
	private int num;
	
	public PeleitaPlayer(String nombre, int num){
		this.nombre = nombre;
		this.num=num;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getNumPlayer(){
		return num;
	}
}
