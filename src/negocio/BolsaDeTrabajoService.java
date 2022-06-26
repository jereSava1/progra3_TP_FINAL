package negocio;

import dto.TicketSimplificadoRequest;
import exception.EmpleadoSinIntentosException;
import exception.TicketFinalizadoException;
import model.Agencia;
import model.ticket.TicketSimplificado;
import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;

public class BolsaDeTrabajoService {
	private static Agencia agencia = Agencia.getAgencia();
	public static synchronized void agregarTicketSimplificado(TicketSimplificadoRequest request) {
		Empleador posibleDueno = agencia.getEmpleadores().stream()
				.filter(e -> e.getNombreUsuario().equals(request.getNombreUsuario())).findFirst().get();

		while (posibleDueno.getTicketsSimplificadosSinAsignar() == 3) {
			try {
				wait();
			} catch (Exception cumpleContrato) {
			}
		}

		TicketSimplificado nuevo = new TicketSimplificado(posibleDueno, request.getTipoDeEmpleo(),
				request.getLocacion());

		agencia.getBolsaDeTrabajo().add(nuevo);
		posibleDueno.setTicketsSimplificadosSinAsignar(posibleDueno.getTicketsSimplificadosSinAsignar() + 1);
		notifyAll();
	}

	public synchronized void verificaEmpleado(TicketSimplificado ticket, Empleado empleado, Locacion locacion,
			Agencia agencia) throws TicketFinalizadoException, EmpleadoSinIntentosException {

		while (ticket.getAsignacion() != null && ticket.isEsPermanente()) { // si el ticket est� tomado, espero que se
																			// desocupe
			try {
				wait();
			} catch (Exception cumpleContrato) {
			}
		}

		if (!ticket.isEsPermanente() && empleado.getIntentosBolsaDeTrabajo() < 10) { // si sali del wait porque se
																						// libero el ticket, intento,
																						// sino ignoro el intento porque
																						// el ticket se tomo mientras se
																						// esperaba
			ticket.setAsignacion(empleado);

			if (locacion.calculaPuntaje((Locacion) ticket.getLocacion()) != 1F) {
				ticket.setAsignacion(null); // si no hay coincidencia, libero el ticket
				empleado.setIntentosBolsaDeTrabajo(empleado.getIntentosBolsaDeTrabajo() + 1);
			} else {
				ticket.setEsPermanente(true); // confirmo que el empleado se queda el ticket
			}

			notifyAll();
		} else if (ticket.isEsPermanente()) {
			throw new TicketFinalizadoException("El ticket finalizo mientras se realizaba la operacion",
					ticket.getDueno().toString());
		} else {
			throw new EmpleadoSinIntentosException("Este empleado no tiene mas intentos!", empleado.toString());
		}
	}
}
