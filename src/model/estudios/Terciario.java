package model.estudios;

public class Terciario extends Estudios {
  public Terciario() {
    super("TERCIARIO");
  }

  public float match1() {
    return -2F;
  }

  public float match2() {
    return -1.5F;
  }

  public float match3() {
    return 1F;
  }

  public float calculaPuntaje(Estudios estudios, int peso) {
    return estudios.match3() * peso;
  }
}
