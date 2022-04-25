package model.estudios;

import interfaces.Puntajes;
import types.Atributo;

public abstract class Estudios implements Puntajes {
  private String valor;
  public abstract float calculaPuntaje(Estudios estudios, int peso);

  public Estudios(String valor){
    this.valor = valor;
  }
}
