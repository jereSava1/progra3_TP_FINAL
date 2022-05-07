package factory;


import model.ticket.rangoEtario.Entre40Y50;
import model.ticket.rangoEtario.Mas50;
import model.ticket.rangoEtario.Menos40;
import model.ticket.DatosDeEmpleo;

public class RangoEtarioFactory {

  public static DatosDeEmpleo getRangoEtario(int edad,int peso) {

    if (edad < 0) {
      return null;
    }

    if (edad < 40){
      return new Menos40(peso);
    }

    if (edad >= 40 && edad <= 50){
      return new Entre40Y50(peso);
    }

    if (edad > 50){
      return new Mas50(peso);
    }

      return null;
  }
}
