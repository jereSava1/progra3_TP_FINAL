package model.experiencia;

public class Mucha extends ExperienciaPrevia{
  public Mucha() {
    super("MUCHA");
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

  float calculaPuntaje(ExperienciaPrevia experienciaPrevia, int peso) {
    return experienciaPrevia.match3() * peso;
  }
}
