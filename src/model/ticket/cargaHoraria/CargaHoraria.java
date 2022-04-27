package model.ticket.cargaHoraria;

import interfaces.Puntajes;
import lombok.Getter;

@Getter
public abstract class CargaHoraria implements Puntajes {
  private final String valor;

  public abstract float calculaPuntaje(CargaHoraria cargaHoraria, int peso);

  protected CargaHoraria(String valor) {
    this.valor = valor;
  }
}
