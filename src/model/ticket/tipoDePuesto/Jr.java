package model.ticket.tipoDePuesto;

public class Jr extends TipoDePuesto{
  public Jr() {
    super("JR");
  }

  public float match1() {
    return 1F;
  }

  public float match2() {
    return -0.5F;
  }

  public float match3() {
    return -1F;
  }


  @Override
  public float calculaPuntaje(TipoDePuesto puesto, int valor) {
    return puesto.match1() * valor;
  }
}
