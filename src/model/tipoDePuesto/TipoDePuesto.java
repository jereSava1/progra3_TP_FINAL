package model.tipoDePuesto;

import interfaces.Puntajes;
import lombok.Getter;

@Getter
public abstract class TipoDePuesto implements Puntajes {
  private String valor;


  public abstract float calculaPuntaje(TipoDePuesto puesto, int valor);

  public TipoDePuesto(String valor){
    this.valor = valor;
  }
}
