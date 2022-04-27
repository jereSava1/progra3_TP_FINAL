package model.ticket.tipoDePuesto;

public class Management extends TipoDePuesto{
  public Management() {
    super("MANAGEMENT");
  }

  public float match1() {
    return -1F;
  }

  public float match2() {
    return -0.5F;
  }

  public float match3() {
    return 1F;
  }


  @Override
  public float calculaPuntaje(TipoDePuesto puesto) {
    return puesto.match3() * this.getPeso();
  }
}
