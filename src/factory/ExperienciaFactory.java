package factory;

import exception.ConstructorInvalidoException;
import model.ticket.experiencia.ExperienciaPrevia;
import model.ticket.experiencia.Media;
import model.ticket.experiencia.Mucha;
import model.ticket.experiencia.Nada;

public class ExperienciaFactory {

  public ExperienciaPrevia getExperiencia(String tipo) throws ConstructorInvalidoException {
    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("NADA")){
      return new Nada();
    }

    if (tipo.equalsIgnoreCase("MEDIA")){
      return new Media();
    }

    if (tipo.equalsIgnoreCase("MUCHA")){
      return new Mucha();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
