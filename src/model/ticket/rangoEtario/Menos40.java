package model.ticket.rangoEtario;

public class Menos40 extends RangoEtario{
  public Menos40(int peso){
    super("MENOS_40", peso);
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

  public float calculaPuntaje(RangoEtario rango) {
    return rango.match1() * this.getPeso();
  }
}