package model.ticket.pretensionSalarial;

import interfaces.Puntajes;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class PretensionSalarial implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(PretensionSalarial pretencionSalarial);

  public PretensionSalarial(String valor, int peso){
    this.valor = valor;
    this.peso = peso;
  }
}
