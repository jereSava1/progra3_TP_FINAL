package simulacionThreads;

import model.ticket.DatosDeEmpleo;
import model.ticket.TicketSimplificado;
import types.Rubro;

public class EmpleadoSimulacion extends Thread {
	
	private String nombre;
	private TicketSimplificado ticketSimplificado;
	private DatosDeEmpleo locacion;
	private Rubro rubro;


	public EmpleadoSimulacion(String nombre, DatosDeEmpleo locacion, Rubro rubro) {
		this.nombre = nombre;
		this.ticketSimplificado = null;
		this.locacion = locacion;
		this.rubro = rubro;
	}


	@Override
	public void run() {
		
		
		
	}

	
	
	public DatosDeEmpleo getLocacion() {
		return locacion;
	}


	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}


	public Rubro getRubro() {
		return rubro;
	}


	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}


	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}
	
	
	
	

}
