package model.ticket.cargaHoraria;

import interfaces.Puntajes;
import lombok.Getter;

@Getter
public abstract class CargaHoraria implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(CargaHoraria cargaHoraria);

  protected CargaHoraria(String valor,int peso) {
    this.valor = valor;
    this.peso=peso; 
  }
}
