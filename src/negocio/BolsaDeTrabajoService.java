package negocio;

import java.util.Observable;

import controlador.ControladorAltaTicketSimplificado;
import controlador.ControladorEleccionTicketSimplificado;
import dto.TicketSimplificadoRequest;
import exception.EmpleadoSinIntentosException;
import exception.TicketFinalizadoException;
import model.Agencia;
import model.ticket.DatosDeEmpleo;
import model.ticket.TicketSimplificado;
import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;

public class BolsaDeTrabajoService extends Observable{
	
	private static Agencia agencia = Agencia.getAgencia();
	private static BolsaDeTrabajoService bolsaDeTrabajoService;

	private BolsaDeTrabajoService() {}

	public static BolsaDeTrabajoService getBolsaDeTrabajoService() {
		if (bolsaDeTrabajoService == null) {
			bolsaDeTrabajoService = new BolsaDeTrabajoService();
		}
		return bolsaDeTrabajoService;
	}
	public synchronized void agregarTicketSimplificado(TicketSimplificadoRequest request, Empleador dueno) {
		while(dueno.getTicketsSimplificadosSinAsignar() >= 3) {
				try {
					ControladorAltaTicketSimplificado.get().falla();
					wait();
				}catch(Exception e) {}
		}
		 TicketSimplificado nuevo = new TicketSimplificado(dueno, request.getTipoDeEmpleo(),request.getLocacion());
		 agencia.getBolsaDeTrabajo().add(nuevo);
		 dueno.setTicketsSimplificadosSinAsignar(dueno.getTicketsSimplificadosSinAsignar() + 1);
		 notifyAll();
		}

	public synchronized void verificaEmpleado(TicketSimplificado ticket, Empleado empleado, DatosDeEmpleo locacion) throws TicketFinalizadoException, EmpleadoSinIntentosException {

		while (ticket.getAsignacion() != null && ticket.isEsPermanente()) { // si el ticket está tomado, espero que se
			// desocupe
			try {
				ControladorEleccionTicketSimplificado.getControladorEleccionTicketSimplificado().falla();
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

			if ((locacion.getValor().equalsIgnoreCase("HomeOffice") && ticket.getLocacion().getValor().equalsIgnoreCase("Presencial")) || ((locacion.getValor().equalsIgnoreCase("Presencial") && ticket.getLocacion().getValor().equalsIgnoreCase("HomeOffice")))) {
				ticket.setAsignacion(null); // si no hay coincidencia, libero el ticket
				empleado.setIntentosBolsaDeTrabajo(empleado.getIntentosBolsaDeTrabajo() + 1);
			} else {
				ticket.setEsPermanente(true); // confirmo que el empleado se queda el ticket
			}
			agencia.getAgencia().getBolsaDeTrabajo().remove(ticket);
			notifyAll();
		} else if (ticket.isEsPermanente()) {
			throw new TicketFinalizadoException("El ticket finalizo mientras se realizaba la operacion",
							ticket.getDueno().toString());
		} else {
			throw new EmpleadoSinIntentosException("Este empleado no tiene mas intentos!", empleado.toString());
		}
	}
}
