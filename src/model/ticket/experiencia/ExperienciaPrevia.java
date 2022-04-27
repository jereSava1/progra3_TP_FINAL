package model.ticket.experiencia;

import interfaces.Puntajes;
import lombok.Getter;

@Getter
public abstract class ExperienciaPrevia implements Puntajes {
  private final String valor;

  public abstract float calculaPuntaje(ExperienciaPrevia experienciaPrevia, int peso);

  public ExperienciaPrevia(String valor) {
    this.valor = valor;
  }
}
