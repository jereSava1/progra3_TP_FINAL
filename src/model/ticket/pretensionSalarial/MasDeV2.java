package model.ticket.pretensionSalarial;

public class MasDeV2 extends PretensionSalarial{

  public MasDeV2() {
    super("MAS_DE_V2");
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
  public float calculaPuntaje(PretensionSalarial pretencionSalarial, int peso) {
    return pretencionSalarial.match3() * peso;
  }
}
