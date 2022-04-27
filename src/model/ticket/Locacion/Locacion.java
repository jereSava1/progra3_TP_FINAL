package model.ticket.Locacion;

import interfaces.Puntajes;
import lombok.Getter;


@Getter
public abstract class Locacion implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(Locacion locacion);

  public Locacion(String valor,int peso){
    this.valor = valor;
    this.peso=peso;
  }
}
