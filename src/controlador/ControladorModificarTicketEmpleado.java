package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;
import exception.NoDuenoDeTicketException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import vista.IVistaAltaTicketEmpleado;
import vista.VistaAltaTicketEmpleado;
import vista.VistaRegistro;

public class ControladorModificarTicketEmpleado implements ActionListener {
	
	private IVistaAltaTicketEmpleado vista;
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
		Empleado empleado = (Empleado)ticket.getDueno();
		if( encontre == true ) {
			
			TicketDeEmpleadoRequest request;
			try {
				request = this.vista.getFormulario();
				
				FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(), 
						   request.getExperiencia(), request.getHorario(),
						   request.getPuesto(), request.getEstudios(), 
						   request.getRemuneracion());

				try {
					empleado.modificaTicket(ticket, formulario);
				}
				catch (NoDuenoDeTicketException e1) {
					//No se ejecuta nunca
				}
				
			} 
			catch (ConstructorInvalidoException e1) {
				//TODO
			}
			
			
		
		}
		
		
	}


}
