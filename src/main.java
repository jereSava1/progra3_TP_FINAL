import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.usuario.Empleado;
import model.usuario.Empleador;
import types.*;

public class main {

  public static void main(String[] args){

    Agencia agencia = Agencia.getAgencia();
    Empleado jere = new Empleado("jere", "pepe123", "Jeremias Savarino", 21, "jere@gmail.com", "22392391");


    agencia.getEmpleados().add(jere);
    /*Ticket ticket = empleado.altaTicket(new FormularioBusqueda(
            100F,
            200F,
            RangoEtario.ENTRE_40_50,
            Locacion.HOMEOFFICE,
            ExperienciaPrevia.MUCHA,
            CargaHoraria.EXTENDIDA,
            TipoDePuesto.SR,
            Estudios.TERCIARIO
    ));*/
    agencia.getEmpleadores().add(new Empleador("facu", "puto123"));
    /*Ticket ticket1 = empleador.altaTicket(
              new FormularioBusqueda(
                100F,
                200F,
                RangoEtario.ENTRE_40_50,
                Locacion.HOMEOFFICE,
                ExperienciaPrevia.MUCHA,
                CargaHoraria.EXTENDIDA,
                TipoDePuesto.SR,
                Estudios.TERCIARIO
              ),
              4
    );*/
    agencia.mostrarEmpleados();

  }
}
