package model.ticket.experiencia;

import interfaces.Puntajes;
import lombok.Getter;

@Getter
public abstract class ExperienciaPrevia implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(ExperienciaPrevia experienciaPrevia, int peso);

  public ExperienciaPrevia(String valor,int peso) {
    this.valor = valor;
    this.peso=peso;
  }
}
