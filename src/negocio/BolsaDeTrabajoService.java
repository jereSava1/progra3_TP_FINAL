package negocio;

import dto.TicketSimplificadoRequest;
import model.Agencia;
import model.ticket.TicketSimplificado;
import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;

public class BolsaDeTrabajoService {
	
	public synchronized void agregarTicketSimplificado(TicketSimplificadoRequest request, Agencia agencia) {
		Empleador posibleDueno = agencia.getEmpleadores().stream()
				.filter(e -> e.getNombreUsuario()
						.equals(request.getNombreUsuario())).findFirst().get();
		
		while (posibleDueno.getTicketsSimplificadosSinAsignar() == 3) {
			try {
				wait();
			} catch (Exception cumpleContrato) {}
		}
		
		TicketSimplificado nuevo = new TicketSimplificado(posibleDueno, request.getTipoDeEmpleo(), request.getLocacion());
		
		agencia.getBolsaDeTrabajo().add(nuevo);
		posibleDueno.setTicketsSimplificadosSinAsignar(posibleDueno.getTicketsSimplificadosSinAsignar() + 1);
		notifyAll();
	}
	
	public synchronized void verificaEmpleado(TicketSimplificado ticket, Empleado empleado, Locacion locacion, Agencia agencia) {
		
		while (ticket.getAsignacion() != null && ticket.isEsPermanente()) { //si el ticket está tomado, espero que se desocupe
			try {
				wait();
			} catch (Exception cumpleContrato) {}
		}
		
		if (!ticket.isEsPermanente()) { //si sali del wait porque se libero el ticket, intento, sino ignoro el intento porque el ticket se tomo mientras se esperaba
			ticket.setAsignacion(empleado);
			
			if (locacion.calculaPuntaje(ticket.getLocacion()) != 1F) {
				ticket.setAsignacion(null); //si no hay coincidencia, libero el ticket
			}
			
			notifyAll();
		}
		
	}
}
