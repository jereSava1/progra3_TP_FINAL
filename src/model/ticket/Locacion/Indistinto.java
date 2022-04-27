package model.ticket.Locacion;

public class Indistinto extends Locacion{
  public Indistinto() {
    super("INDISTINTO");
  }

  @Override
  public float match1() {
    return 1F;
  }

  @Override
  public float match2() {
    return 1F;
  }

  @Override
  public float match3() {
    return 1F;
  }

  @Override
  public float calculaPuntaje(Locacion locacion, int peso) {
    return locacion.match3() * peso;
  }
}
