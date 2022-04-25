package factory;

import exception.ConstructorInvalidoException;
import interfaces.Puntajes;
import model.estudios.Estudios;
import model.estudios.Primario;
import model.estudios.Secundario;
import model.estudios.Terciario;

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
