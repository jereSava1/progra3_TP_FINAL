package model.ticket.experiencia;

public class Media extends ExperienciaPrevia{
  public Media() {
    super("MEDIA");
  }

  public float match1() {
    return -0.5F;
  }

  public float match2() {
    return 1F;
  }

  public float match3() {
    return 1.5F;
  }

  public float calculaPuntaje(ExperienciaPrevia experienciaPrevia, int peso) {
    return experienciaPrevia.match2() * peso;
  }
}
