package model.ticket.experiencia;

public class Nada extends ExperienciaPrevia{
  public Nada() {
    super("NADA");
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

  float calculaPuntaje(ExperienciaPrevia experienciaPrevia, int peso) {
    return experienciaPrevia.match1() * peso;
  }
}
