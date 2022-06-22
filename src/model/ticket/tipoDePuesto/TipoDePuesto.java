package model.ticket.tipoDePuesto;

import interfaces.Puntajes;

public abstract class TipoDePuesto implements Puntajes {
	private final String valor;
	private int peso;

	public abstract float calculaPuntaje(TipoDePuesto puesto);

	public TipoDePuesto(String valor, int peso) {
		this.valor = valor;
		this.peso = peso;
	}

	public String getValor() {
		return valor;
	}

	public int getPeso() {
		return peso;
	}
}
