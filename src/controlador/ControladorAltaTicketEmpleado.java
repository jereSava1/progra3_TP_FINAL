package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaIEmpleador;
import vista.VistaAltaTicketEmpleado;
import vista.VistaInicioEmpleador;

public class ControladorAltaTicketEmpleado implements ActionListener {

	private IVistaAltaTicketEmpleado vista;
	private static ControladorAltaTicketEmpleado controladorAltaTicket=null;
	private Agencia agencia;
	
	private ControladorAltaTicketEmpleado() {
		this.vista = new VistaAltaTicketEmpleado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorAltaTicketEmpleado get(){
		if(controladorAltaTicket==null)
			controladorAltaTicket = new ControladorAltaTicketEmpleado();
		controladorAltaTicket.vista.setV1(Agencia.getAgencia().getRemuneracionV1());
        controladorAltaTicket.vista.setV2(Agencia.getAgencia().getRemuneracionV2());
		controladorAltaTicket.vista.mostrar();
		return controladorAltaTicket;
	}
	
	public void setVista(IVistaAltaTicketEmpleado vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("FINALIZAR")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			//Guardo Ticket
			
			TicketDeEmpleadoRequest request;
			try {
				request = this.vista.getFormulario();
				String usuario = ControladorLogin.getControladorLogin().getVistaLogin().getUsername();
				agencia.crearTicketBusquedaDeEmpleo(request, usuario);
			}catch (ConstructorInvalidoException e1) {}

			ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado();

		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado();
		}
		
	}

}
