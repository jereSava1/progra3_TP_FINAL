package model.ticket.rangoEtario;

public class Menos40 extends RangoEtario{
  public Menos40(){
    super("MENOS_40");
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

  float calculaPuntaje(RangoEtario rango, int peso) {
    return rango.match1() * peso;
  }
}
