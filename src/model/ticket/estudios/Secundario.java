package model.ticket.estudios;


public class Secundario extends Estudios {
  public Secundario(){
    super("SECUNDARIO");
  }

  public float match1(){
    return -0.5F;
  }

  public float match2(){
    return 1F;
  }

  public float match3(){
    return 1.5F;
  }


  public float calculaPuntaje(Estudios estudios){
    return estudios.match2() * this.getPeso();
  }
}
