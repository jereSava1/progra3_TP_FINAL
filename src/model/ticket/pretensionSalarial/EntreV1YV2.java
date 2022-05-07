package model.ticket.pretensionSalarial;

import model.ticket.DatosDeEmpleo;

public class EntreV1YV2 extends PretensionSalarial{
  public EntreV1YV2(int peso, float remuneracionPretendida){
    super("ENTRE_V1_Y_V2", peso, remuneracionPretendida);
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
  public float calculaPuntaje(DatosDeEmpleo pretensionSalarial) {
    return pretensionSalarial.match2() * this.getPeso();
  }

}
