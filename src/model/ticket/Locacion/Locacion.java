package model.ticket.Locacion;

import interfaces.Puntajes;
import lombok.Getter;


@Getter
public abstract class Locacion implements Puntajes {
  private final String valor;

  public abstract float calculaPuntaje(Locacion locacion, int peso);

  public Locacion(String valor){
    this.valor = valor;
  }
}
