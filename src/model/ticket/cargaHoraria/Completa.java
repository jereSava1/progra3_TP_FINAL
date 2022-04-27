package model.ticket.cargaHoraria;

public class Completa extends CargaHoraria{
  public Completa(int peso) {
    super("COMPLETA", peso);
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

  public float calculaPuntaje(CargaHoraria cargaHoraria) {
    return cargaHoraria.match2() * this.getPeso();
  }
}
