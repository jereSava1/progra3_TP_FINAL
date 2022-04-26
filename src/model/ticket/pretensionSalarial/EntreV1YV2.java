package model.ticket.pretensionSalarial;

public class EntreV1YV2 extends PretensionSalarial{
  public EntreV1YV2(){
    super("ENTRE_V1_Y_V2");
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
    return -0.5F;
  }

  @Override
  float calculaPuntaje(PretensionSalarial pretencionSalarial, int peso) {
    return pretencionSalarial.match2() * peso;
  }
}
