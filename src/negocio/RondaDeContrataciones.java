package negocio;
import model.Agencia;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.UsuarioPuntuado;
import types.EstadoTicket;

import java.util.List;
import java.util.stream.Collectors;


public class RondaDeContrataciones {
  /**
   * PRECONDICION: se debe ejecutar luego de la ronda de encuentro y de la ronda de elecciones
   * @param solicitudes
   * @param busquedas
   */
  public static void ejecutarRondaDeContrataciones(Agencia agencia) {
      
	  float comisiones=0;
      agencia.empleadorNoElegido();//actualiza los puntajes en caso de que el empleador no haya sido elegido por ningun empleado
	  for (TicketBusquedaDeEmpleado solicitud : agencia.getSolicitudes()) { //TICKETS DE EMPLEADORES

      List<UsuarioPuntuado> candidatosSeleccionados = solicitud.getListaDeAsignaciones()
              .stream()
              .filter(UsuarioPuntuado::isSeleccionado)
              .collect(Collectors.toList()); //filtro los candidatos seleccionados por los empleadores de la lista de asignaciones

      for (TicketBusquedaDeEmpleo busqueda : agencia.getBusquedas()) { //TICKETS DE EMPLEADOS
        if (solicitud.getEstadoTicket() == EstadoTicket.FINALIZADO) { //Si el ticket se cerró durante la ejecucion, la corto
          break;
        }

        if (busqueda.getEstadoTicket() == EstadoTicket.ACTIVO
                && candidatosSeleccionados.stream().anyMatch(
                c -> c.getUsuario().equals(busqueda.getDueno()))
        ) { //validamos que el ticket este activo y que el dueño de la solicitud

          List<UsuarioPuntuado> empleadoresSeleccionados = busqueda.getListaDeAsignaciones()
                  .stream()
                  .filter(UsuarioPuntuado::isSeleccionado)
                  .collect(Collectors.toList());

          if (empleadoresSeleccionados.stream().anyMatch(c -> c.getUsuario().equals(solicitud.getDueno()))) { // si el empleado tambien seleccionó al empleador HAY MATCH
        	/*Agrego comisiones a la agencia*/
        	comisiones=agencia.calculaComisionesEmpleado(busqueda) + agencia.calculaComisionesEmpleador(solicitud);
        	agencia.setComisiones(agencia.getComisiones()+comisiones);
        	/* Actualizamos los atributos del ticket de empleado*/
            busqueda.setEstadoTicket(EstadoTicket.FINALIZADO); //Si se contrata, finalizamos el ticket
            busqueda.getDueno().aumentarPuntaje(10); //aumentamos el puntaje del usuario

            /*actualizamos los atributos del ticket de empleador*/
            solicitud.aumentarEmpleadosObtenidos();
            if (solicitud.getEmpleadosObtenidos() == solicitud.getEmpleadosNecesitados()) { //si alcanza el tope, cierro el ticket
              solicitud.setEstadoTicket(EstadoTicket.FINALIZADO);
              solicitud.getDueno().aumentarPuntaje(50);
            }
          }
        }
      }
    } 
  }
}
