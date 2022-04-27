package negocio;

import model.ticket.FormularioBusqueda;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import model.ticket.Ticket;
import model.usuario.RankingUsuario;


public class RondaDeEncuentro {

  public void ejecutarRondaDeEncuentrosParaTicket(List<Ticket> busquedas, Ticket solicitud){
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
}
