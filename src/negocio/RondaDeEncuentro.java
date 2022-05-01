package negocio;

import model.Agencia;
import model.ticket.FormularioBusqueda;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.ListaDeAsignaciones;


public class RondaDeEncuentro {

  private static void ejecutarRondaDeEncuentrosParaTicket(List<? extends Ticket> busquedas, Ticket solicitud){
    List<ListaDeAsignaciones> ranking = new ArrayList<>();
    FormularioBusqueda solicitudForm = solicitud.getFormularioDeBusqueda();

    for (Ticket busqueda : busquedas){
      FormularioBusqueda formulario = busqueda.getFormularioDeBusqueda();
      float puntaje = 0F;

      puntaje += formulario.getPretensionSalarial().calculaPuntaje(solicitudForm.getPretensionSalarial());
      puntaje += formulario.getEstudios().calculaPuntaje(solicitudForm.getEstudios());
      puntaje += formulario.getRangoEtario().calculaPuntaje(solicitudForm.getRangoEtario());
      puntaje += formulario.getTipoDePuesto().calculaPuntaje(solicitudForm.getTipoDePuesto());
      puntaje += formulario.getCargaHoraria().calculaPuntaje(solicitudForm.getCargaHoraria());
      puntaje += formulario.getLocacion().calculaPuntaje(solicitudForm.getLocacion());
      puntaje += formulario.getExperienciaPrevia().calculaPuntaje(solicitudForm.getExperienciaPrevia());

      ranking.add(new ListaDeAsignaciones( busqueda.getDueno(), puntaje));
    }
    Collections.sort(ranking);

    solicitud.setListaDeAsignaciones(ranking);
  }

  public static void ejecutarRondaDeEncuentros(Agencia agencia) {
    for(Ticket busqueda : agencia.getBusquedas()) { //TICKETS DE EMPLEADOS
      RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getSolicitudes(), busqueda);
    }

    for(Ticket solicitud : agencia.getSolicitudes()) { //TICKETS DE EMPLEADORES
      RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getBusquedas(), solicitud);
    } 
  }

  public static void actualizarPuntajesParaEmpleado(List<TicketBusquedaDeEmpleado> solicitudes){
    for(TicketBusquedaDeEmpleado solicitud : solicitudes) {
      List<ListaDeAsignaciones> listaDeAsignaciones = solicitud.getListaDeAsignaciones();
      listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(5);
      listaDeAsignaciones.get(listaDeAsignaciones.size()-1).getUsuario().bajarPuntaje(5);
    }
  }

  public static void actualizarPuntajesParaEmpleador(List<TicketBusquedaDeEmpleo> busquedas){
    for(TicketBusquedaDeEmpleo busqueda : busquedas) {
      List<ListaDeAsignaciones> listaDeAsignaciones = busqueda.getListaDeAsignaciones();
      listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(10);
    }
  }
}
