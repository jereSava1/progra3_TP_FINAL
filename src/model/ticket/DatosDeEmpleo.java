package model.ticket;

import interfaces.Puntajes;

public abstract class DatosDeEmpleo implements Puntajes {
	  private final String valor;
	  private int peso;

	  public abstract float calculaPuntaje(DatosDeEmpleo cargaHoraria);

	  protected DatosDeEmpleo(String valor,int peso) {
	    this.valor = valor;
	    this.peso=peso; 
	  }

	public String getValor() {
		return valor;
	}

	public int getPeso() {
		return peso;
	}
	  
	  
	}
