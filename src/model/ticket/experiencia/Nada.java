package model.ticket.experiencia;

public class Nada extends ExperienciaPrevia{
  public Nada(int peso) {
    super("NADA", peso);
  }

  public float match1() {
    return 1F;
  }

  public float match2() {
    return 1.5F;
  }

  public float match3() {
    return 2F;
  }

  public float calculaPuntaje(ExperienciaPrevia experienciaPrevia) {
    return experienciaPrevia.match1() * this.getPeso();
  }
}
