package model.ticket.pretensionSalarial;

import interfaces.Puntajes;

public abstract class PretensionSalarial implements Puntajes {
  private final String valor;
  private float remuneracion;
  private int peso;

  public abstract float calculaPuntaje(PretensionSalarial pretencionSalarial);

  public PretensionSalarial(String valor, int peso,float remuneracionPretendida){
    this.valor = valor;
    this.peso = peso;
    this.remuneracion=remuneracionPretendida;
  }
  //GETTERS Y SETTERS

public String getValor() {
	return valor;
}

public int getPeso() {
	return peso;
}

public float getRemuneracion() {
	return remuneracion;
}

  
}
