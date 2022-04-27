import factory.EstudiosFactory;
import model.ticket.estudios.Estudios;

public class main {

  public static void main(String[] args){

    EstudiosFactory estudiosFactory = new EstudiosFactory();

    try {
      Estudios primario = estudiosFactory.getEstudios("primario", 10);
      Estudios secundario = estudiosFactory.getEstudios("Secundario", 20);
      System.out.println("PRIMARIO ==> SECUNDARIO\n");
      System.out.println(primario.calculaPuntaje(secundario));
      System.out.println("SECUNDARIO ==> PRIMARIO\n");
      System.out.println(secundario.calculaPuntaje(primario));

    } catch (Exception ignored) {

    }


  }
}
