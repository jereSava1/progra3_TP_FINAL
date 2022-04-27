package negocio;

import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.RankingEmpleado;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;


public class RondaDeEncuentro {

  public List<RankingEmpleado> ejecutarRondaDeEncuentrosParaEmpleador(List<TicketBusquedaDeEmpleo> busquedas, TicketBusquedaDeEmpleado solicitud){
    List<RankingEmpleado> rankingEmpleados = new ArrayList<>();
    FormularioBusqueda solicitudForm = solicitud.getFormularioDeBusqueda();

    for (TicketBusquedaDeEmpleo busqueda : busquedas){
      FormularioBusqueda formulario = busqueda.getFormularioDeBusqueda();
      float puntaje = 0F;

      //TODO: pasar pesos por parametro
      puntaje += formulario.getPretensionSalarial().calculaPuntaje(solicitudForm.getPretensionSalarial(), 10);
      puntaje += formulario.getEstudios().calculaPuntaje(solicitudForm.getEstudios(), 20);
      puntaje += formulario.getRangoEtario().calculaPuntaje(solicitudForm.getRangoEtario(), 30);
      puntaje += formulario.getTipoDePuesto().calculaPuntaje(solicitudForm.getTipoDePuesto(), 40);
      puntaje += formulario.getCargaHoraria().calculaPuntaje(solicitudForm.getCargaHoraria(), 10);
      puntaje += formulario.getLocacion().calculaPuntaje(solicitudForm.getLocacion(), 0);
      puntaje += formulario.getExperienciaPrevia().calculaPuntaje(solicitudForm.getExperienciaPrevia(), 100);

      rankingEmpleados.add(new RankingEmpleado((Empleado) busqueda.getDueno(), puntaje));
    }
    Collections.sort(rankingEmpleados);
    return  rankingEmpleados;
  }
}
