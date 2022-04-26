package factory;

import exception.ConstructorInvalidoException;
import model.ticket.cargaHoraria.CargaHoraria;
import model.ticket.cargaHoraria.Completa;
import model.ticket.cargaHoraria.Extendida;
import model.ticket.cargaHoraria.Media;

public class CargaHorariaFactory {

  public CargaHoraria getCargaHoraria(String tipo) throws ConstructorInvalidoException {
    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("COMPLETA")){
      return new Completa();
    }

    if (tipo.equalsIgnoreCase("EXTENDIDA")){
      return new Extendida();
    }

    if (tipo.equalsIgnoreCase("MEDIA")){
      return new Media();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
