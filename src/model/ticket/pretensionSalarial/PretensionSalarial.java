package model.ticket.pretensionSalarial;

import interfaces.Puntajes;

public abstract class PretensionSalarial implements Puntajes {
  private final String valor;

  abstract float calculaPuntaje(PretensionSalarial pretencionSalarial, int peso);

  public PretensionSalarial(String valor){ this.valor = valor; }
}
