package model.ticket.experiencia;

public class Mucha extends ExperienciaPrevia{
  public Mucha(int peso) {
    super("MUCHA", peso);
  }

  public float match1() {
    return -2F;
  }

  public float match2() {
    return -1.5F;
  }

  public float match3() {
    return 1F;
  }

  public float calculaPuntaje(ExperienciaPrevia experienciaPrevia) {
    return experienciaPrevia.match3() * this.getPeso();
  }
}
