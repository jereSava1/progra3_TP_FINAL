package model.ticket.rangoEtario;

import interfaces.Puntajes;

public abstract class RangoEtario implements Puntajes {
  private final String valor;
  private int peso;
  public abstract float calculaPuntaje(RangoEtario rango);

  public RangoEtario(String dato){
    this.valor = dato;
    this.peso=peso;
  }
}
