package model.ticket.pretensionSalarial;

import interfaces.Puntajes;

public abstract class PretensionSalarial implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(PretensionSalarial pretencionSalarial);

  public PretensionSalarial(String valor){ this.valor = valor; this.peso=peso }
}
