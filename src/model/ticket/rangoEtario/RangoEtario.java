package model.ticket.rangoEtario;

import interfaces.Puntajes;

public abstract class RangoEtario implements Puntajes {
  private final String valor;

  abstract float calculaPuntaje(RangoEtario rango, int peso);

  public RangoEtario(String dato){
    this.valor = dato;
  }
}
