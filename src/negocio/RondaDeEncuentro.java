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

      puntaje += formulario.getPretensionSalarial().calculaPuntaje(solicitudForm.getPretensionSalarial(), solicitudForm.getPretensionSalarial().getPeso());
      puntaje += formulario.getEstudios().calculaPuntaje(solicitudForm.getEstudios(), solicitudForm.getEstudios().getPeso());
      puntaje += formulario.getRangoEtario().calculaPuntaje(solicitudForm.getRangoEtario(), solicitudForm.getRangoEtario().getPeso());
      puntaje += formulario.getTipoDePuesto().calculaPuntaje(solicitudForm.getTipoDePuesto(), solicitudForm.getTipoDePuesto().getPeso());
      puntaje += formulario.getCargaHoraria().calculaPuntaje(solicitudForm.getCargaHoraria(), solicitudForm.getCargaHoraria().getPeso());
      puntaje += formulario.getLocacion().calculaPuntaje(solicitudForm.getLocacion(), solicitudForm.getLocacion().getPeso());
      puntaje += formulario.getExperienciaPrevia().calculaPuntaje(solicitudForm.getExperienciaPrevia(), solicitudForm.getExperienciaPrevia().getPeso());

      ranking.add(new RankingUsuario( busqueda.getDueno(), puntaje));
    }
    Collections.sort(ranking);
    solicitud.setRanking(ranking);
  }
}
