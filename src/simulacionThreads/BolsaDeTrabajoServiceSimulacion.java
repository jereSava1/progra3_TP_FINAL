package simulacionThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class BolsaDeTrabajoServiceSimulacion extends Observable{
	
	private static BolsaDeTrabajoServiceSimulacion bolsaDeTrabajoService;
	private boolean finalizado = false;
	private List<TicketSimplificado> bolsa = new ArrayList<>();
	
	private BolsaDeTrabajoServiceSimulacion() {}

	public static BolsaDeTrabajoServiceSimulacion getBolsaDeTrabajoService() {
		if (bolsaDeTrabajoService == null) {
			bolsaDeTrabajoService = new BolsaDeTrabajoServiceSimulacion();
		}
		return bolsaDeTrabajoService;
	}
	public synchronized void agregarTicketSimplificado(TicketSimplificado ticket) {
		 bolsa.add(ticket);
		 notifyAll();
	}
	
	public synchronized void sacaTicketSimplificado(EmpleadoSimulacion empleado) {
		
		int i = 0;
		boolean verifica = false;
		
		while( i < bolsa.size() && !verifica && !finalizado ) {
			if( verificaTicket(bolsa.get(i), empleado) ) {
				verifica = true;
				bolsa.get(i).setEmpleadoAsignado(empleado);
				bolsa.remove(i);
			}else {
				if( i == bolsa.size()-1  ) {
					try{
						wait();
					}catch( Exception e ) {
						e.printStackTrace();
					}
					i = 0;
				}else 
					i++;		
			}
		}
	}
	
	public boolean verificaTicket(TicketSimplificado ticket, EmpleadoSimulacion empleado) {
		
		return ticket.getLocacion().getValor().equalsIgnoreCase(empleado.getLocacion().getValor()) && ticket.getTipoDeEmpleo().equals(empleado.getRubro());
		
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
}
