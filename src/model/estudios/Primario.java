package model.estudios;


public class Primario extends Estudios {

  public Primario(){
    super("PRIMARIO");
  }

  public float match1(){
    return 1F;
  }

  public float match2(){
    return 1.5F;
  }

  public float match3(){
    return 2F;
  }

  public float calculaPuntaje(Estudios estudios, int peso) {
      return estudios.match1() * peso;
  }
}
