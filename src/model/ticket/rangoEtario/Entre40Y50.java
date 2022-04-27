package model.ticket.rangoEtario;

public class Entre40Y50 extends RangoEtario{

  public Entre40Y50(int peso){
    super("ENTRE_40_Y_50", peso);
  }

  public float match1() {
    return -0.5F;
  }

  public float match2() {
    return 1F;
  }

  public float match3() {
    return -0.5F;
  }

  public float calculaPuntaje(RangoEtario rango) {
    return rango.match2() * this.getPeso();
  }
}
