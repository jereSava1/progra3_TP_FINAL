package model.ticket.pretensionSalarial;

public class MenosV1 extends PretensionSalarial {
  
	public MenosV1(int peso,float remuneracionPretendida){ 
	  super("MENOS_V1", peso,remuneracionPretendida); 
   }

  @Override
  public float match1() {
    return 1F;
  }

  @Override
  public float match2() {
    return -0.5F;
  }

  @Override
  public float match3() {
    return -1F;
  }

  @Override
  public float calculaPuntaje(PretensionSalarial pretencionSalarial) {
    return pretencionSalarial.match1() * this.getPeso();
  }
}
