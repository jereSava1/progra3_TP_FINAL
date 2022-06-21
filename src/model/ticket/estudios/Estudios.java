package model.ticket.estudios;

import interfaces.Puntajes;

public abstract class Estudios implements Puntajes {
  private final String valor;
  private int peso; 
  public abstract float calculaPuntaje(Estudios estudios);

  public Estudios(String valor,int peso){
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
