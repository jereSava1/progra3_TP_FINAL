package negocio;

import model.Agencia;
import model.ticket.FormularioBusqueda;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import model.ticket.Ticket;
import model.usuario.RankingUsuario;
import sun.java2d.pipe.AATileGenerator;


public class RondaDeEncuentro {

  private void ejecutarRondaDeEncuentrosParaTicket(List<? extends Ticket> busquedas, Ticket solicitud){
    List<RankingUsuario> ranking = new ArrayList<>();
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

      ranking.add(new RankingUsuario( busqueda.getDueno(), puntaje));
    }
    Collections.sort(ranking);
    solicitud.setRanking(ranking);
  }

  private void ejecutarRondaDeEncuentros(Agencia agencia) {
    for(Ticket busqueda : agencia.getBusquedas()) { //TICKETS DE EMPLEADOS
      this.ejecutarRondaDeEncuentrosParaTicket(agencia.getSolicitudes(), busqueda);
    }

    for(Ticket solicitud : agencia.getSolicitudes()) { //TICKETS DE EMPLEADORES
      this.ejecutarRondaDeEncuentrosParaTicket(agencia.getBusquedas(), solicitud);
    }
  }
}
