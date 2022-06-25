package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketDeEmpleadoRequest;
import dto.TicketDeEmpleadorRequest;
import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.usuario.Empleado;
import model.usuario.Empleador;
import vista.IVistaAltaTicketEmpleador;
import vista.VistaAltaTicketEmpleador;

public class ControladorAltaTicketEmpleador implements ActionListener{


	private IVistaAltaTicketEmpleador vista;
	private static ControladorAltaTicketEmpleador controladorAltaTicket=null;
	private Agencia agencia;
	
	private ControladorAltaTicketEmpleador() {
		this.vista = new VistaAltaTicketEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorAltaTicketEmpleador get(){
		if(controladorAltaTicket==null)
			controladorAltaTicket = new ControladorAltaTicketEmpleador();
		controladorAltaTicket.vista.setV1(Agencia.getAgencia().getRemuneracionV1());
		controladorAltaTicket.vista.setV2(Agencia.getAgencia().getRemuneracionV2());
		controladorAltaTicket.vista.mostrar();
		return controladorAltaTicket;
	}
	
	public void setVista(IVistaAltaTicketEmpleador vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("FINALIZAR")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			//Guardo Ticket
			
			TicketDeEmpleadorRequest request;
			try {
				request = this.vista.getFormulario();
				String usuario = ControladorLogin.getControladorLogin().getVistaLogin().getUsername();
				agencia.crearTicketBusquedaDeEmpleado(request, usuario);
			} 
			catch (Exception e1) {
				//Manejar exc
			}
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado();
		}

	}
}	
