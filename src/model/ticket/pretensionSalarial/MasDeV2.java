package model.ticket.pretensionSalarial;

import model.ticket.DatosDeEmpleo;

public class MasDeV2 extends PretensionSalarial{

  public MasDeV2(int peso,float remuneracionPretendida) {
    super("MAS_DE_V2", peso,remuneracionPretendida);
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
  public float calculaPuntaje(PretensionSalarial pretensionSalarial) {
    return pretensionSalarial.match3() * this.getPeso();
  }
}
