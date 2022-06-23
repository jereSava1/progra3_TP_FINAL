package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleo;
import vista.IVistaModificarTicketEmpleado;
import vista.VistaAltaTicketEmpleado;
import vista.VistaRegistro;

public class ControladorModificarTicketEmpleado implements ActionListener {
	
	private IVistaModificarTicketEmpleado vista;
	private static ControladorModificarTicketEmpleado controladorModificarTicketEmpleado = null;

	private ControladorModificarTicketEmpleado() {
		this.vista = new VistaAltaTicketEmpleado();
		this.vista.setActionListener(this);
	}
	
	public static ControladorModificarTicketEmpleado getControladorModificarTicketEmpleado(){
		if (controladorModificarTicketEmpleado == null) {
			controladorModificarTicketEmpleado = new ControladorModificarTicketEmpleado();
		}
		controladorModificarTicketEmpleado.vista.mostrar();
		return controladorModificarTicketEmpleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String usuario = ControladorLogin.getControladorLogin().getVistaLogin().getUsername();
		ControladorLogin.getControladorLogin().getVistaLogin().esconder();
		
		List <TicketBusquedaDeEmpleo> busquedas = Agencia.getAgencia().getBusquedas();
		
		int i = 0;
		boolean encontre = false;
		while( (i < busquedas.size()) && (encontre == false) ) {
			if( ( busquedas.get(i).getDueno().getNombreUsuario() == usuario) == true ) {
				encontre = true;
			}
			i++;
		}
		TicketBusquedaDeEmpleo ticket = busquedas.get(i);
		if( encontre == true ) {
			
		}
		
		
	}


}
