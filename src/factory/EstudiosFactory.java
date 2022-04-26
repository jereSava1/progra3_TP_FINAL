package factory;

import exception.ConstructorInvalidoException;
import model.ticket.estudios.Estudios;
import model.ticket.estudios.Primario;
import model.ticket.estudios.Secundario;
import model.ticket.estudios.Terciario;

public class EstudiosFactory {

  public Estudios getEstudios(String tipo) throws ConstructorInvalidoException {
    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("PRIMARIO")) {
      return new Primario();
    }

    if (tipo.equalsIgnoreCase("SECUNDARIO")){
      return new Secundario();
    }

    if (tipo.equalsIgnoreCase("TERCIARIO")){
      return new Terciario();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
