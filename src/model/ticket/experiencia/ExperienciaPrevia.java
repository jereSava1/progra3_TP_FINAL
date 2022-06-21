package model.ticket.experiencia;

import interfaces.Puntajes;

public abstract class ExperienciaPrevia implements Puntajes {
  private final String valor;
  private int peso;

  public abstract float calculaPuntaje(ExperienciaPrevia experienciaPrevia);

  public ExperienciaPrevia(String valor,int peso) {
    this.valor = valor;
    this.peso=peso;
  }

  public String getValor() {
    return valor;
  }

  public int getPeso() {
    return peso;
  }
}
