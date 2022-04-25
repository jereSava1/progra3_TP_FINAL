package model.estudios;

import interfaces.Puntajes;
import lombok.Getter;
import types.Atributo;
@Getter
public abstract class Estudios implements Puntajes {
  private final String valor;
  public abstract float calculaPuntaje(Estudios estudios, int peso);

  public Estudios(String valor){
    this.valor = valor;
  }
}
