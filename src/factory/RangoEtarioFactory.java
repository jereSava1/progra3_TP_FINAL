package factory;

import exception.ConstructorInvalidoException;
import model.ticket.experiencia.Media;
import model.ticket.rangoEtario.Entre40Y50;
import model.ticket.rangoEtario.Mas50;
import model.ticket.rangoEtario.Menos40;
import model.ticket.rangoEtario.RangoEtario;

public class RangoEtarioFactory {

  public RangoEtario getRangoEtario(String tipo) throws ConstructorInvalidoException {

    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("MENOR_40")){
      return new Menos40();
    }

    if (tipo.equalsIgnoreCase("ENTRE_40_50")){
      return new Entre40Y50();
    }

    if (tipo.equalsIgnoreCase("MAS_50")){
      return new Mas50();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
