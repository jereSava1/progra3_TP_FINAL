import factory.EstudiosFactory;
import model.estudios.Estudios;

public class main {

  public static void main(String[] args){

    EstudiosFactory estudiosFactory = new EstudiosFactory();

    try {
      Estudios primario = estudiosFactory.getEstudios("primario");
      Estudios secundario = estudiosFactory.getEstudios("Secundario");
      System.out.println("PRIMARIO ==> SECUNDARIO\n");
      System.out.println(primario.calculaPuntaje(secundario, 0));
      System.out.println("SECUNDARIO ==> PRIMARIO\n");
      System.out.println(secundario.calculaPuntaje(primario, 10));

    } catch (Exception ignored) {

    }


  }
}
