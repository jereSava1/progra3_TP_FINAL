package factory;

import exception.ConstructorInvalidoException;
import model.ticket.experiencia.Media;
import model.ticket.pretensionSalarial.EntreV1YV2;
import model.ticket.pretensionSalarial.MasDeV2;
import model.ticket.pretensionSalarial.MenosV1;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class PretensionSalarialFactory {

  public PretensionSalarial getPretensionSalarial(String tipo) throws ConstructorInvalidoException {

    if (tipo == null){
      return null;
    }

    if (tipo.equalsIgnoreCase("MENOS_V1")){
      return new MenosV1();
    }

    if (tipo.equalsIgnoreCase("ENTRE_V1_V2")){
      return new EntreV1YV2();
    }

    if (tipo.equalsIgnoreCase("MAS_V2")){
      return new MasDeV2();
    }

    throw new ConstructorInvalidoException(tipo);
  }
}
