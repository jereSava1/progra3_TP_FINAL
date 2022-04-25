package model.Locacion;

public class Presencial extends Locacion{
  public Presencial() {
    super("PRESENCIAL");
  }

  @Override
  public float match1() {
    return -1F;
  }

  @Override
  public float match2() {
    return 1F;
  }

  @Override
  public float match3() {
    return -1F;
  }

  @Override
  float calculaPuntaje(Locacion locacion, int peso) {
    return locacion.match2() * peso;
  }
}
