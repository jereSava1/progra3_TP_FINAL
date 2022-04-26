package factory;

import exception.ConstructorInvalidoException;
import model.ticket.tipoDePuesto.Jr;
import model.ticket.tipoDePuesto.Management;
import model.ticket.tipoDePuesto.Sr;
import model.ticket.tipoDePuesto.TipoDePuesto;

public class TipoDePuestoFactory {

  public TipoDePuesto getTipoDePuesto(String tipo) throws ConstructorInvalidoException {
    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("JR")) {
      return new Jr();
    }

    if (tipo.equalsIgnoreCase("Management")) {
      return new Management();
    }

    if (tipo.equalsIgnoreCase("SR")){
      return new Sr();
    }

    throw new ConstructorInvalidoException(tipo);
  }

}
