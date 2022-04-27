package model.ticket.Locacion;

public class Indistinto extends Locacion{
  public Indistinto(int peso) {
    super("INDISTINTO", peso);
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
  public float calculaPuntaje(Locacion locacion) {
    return locacion.match3() * this.getPeso();
  }
}
