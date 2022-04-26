package model.ticket.cargaHoraria;

public class Completa extends CargaHoraria{
  public Completa() {
    super("COMPLETA");
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

  float calculaPuntaje(CargaHoraria cargaHoraria, int peso) {
    return cargaHoraria.match2() * peso;
  }
}
