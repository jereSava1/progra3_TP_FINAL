import factory.EstudiosFactory;
import model.Agencia;
import model.ticket.estudios.Estudios;
import negocio.RondaDeEncuentro;

public class main {

  public static void main(String[] args){


    try {

      Agencia agencia = Agencia.getAgencia();
      RondaDeEncuentro.ejecutarRondaDeEncuentros(agencia);

    } catch (Exception ignored) {

    }


  }
}
