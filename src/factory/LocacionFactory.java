package factory;

import exception.ConstructorInvalidoException;
import model.ticket.Locacion.HomeOfiice;
import model.ticket.Locacion.Indistinto;
import model.ticket.Locacion.Locacion;
import model.ticket.Locacion.Presencial;

public class LocacionFactory {

  public Locacion getLocacion(String tipo) throws ConstructorInvalidoException {

    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("HOME_OFFICE")) {
      return new HomeOfiice();
    }

    if (tipo.equalsIgnoreCase("PRESENCIAL")) {
      return new Presencial();
    }

    if (tipo.equalsIgnoreCase("INDISTINTO")) {
      return new Indistinto();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
