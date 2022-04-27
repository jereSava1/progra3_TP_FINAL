package factory;

import exception.ConstructorInvalidoException;
import model.ticket.cargaHoraria.CargaHoraria;
import model.ticket.cargaHoraria.Completa;
import model.ticket.cargaHoraria.Extendida;
import model.ticket.cargaHoraria.Media;

public class CargaHorariaFactory {

  public CargaHoraria getCargaHoraria(String tipo,int peso) throws ConstructorInvalidoException {
    if (tipo == null) {
      return null;
    }

    if (tipo.equalsIgnoreCase("COMPLETA")){
      return new Completa(peso);
    }

    if (tipo.equalsIgnoreCase("EXTENDIDA")){
      return new Extendida(peso);
    }

    if (tipo.equalsIgnoreCase("MEDIA")){
      return new Media(peso);
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
