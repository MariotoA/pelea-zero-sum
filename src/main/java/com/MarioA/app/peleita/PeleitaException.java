package com.MarioA.app.peleita;

public class PeleitaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PeleitaException(){
		super();
	}
	
	public PeleitaException(String msg){
		super(msg);
	}
	
	public PeleitaException(int i){
		super(Integer.toString(i));
	}

}
