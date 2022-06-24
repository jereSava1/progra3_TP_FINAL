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
				List <Empleador> empleadores = (List<Empleador>) Agencia.getAgencia().getEmpleadores();
				
				int i = 0;
				while( empleadores.get(i).getNombreUsuario() != usuario ) {
					i++;
				}
				
				FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(), 
																	   request.getExperiencia(), request.getHorario(),
																	   request.getPuesto(), request.getEstudios(), 
																	   request.getRemuneracion());
				
				//Dimos de alta el ticket del empleado en la agencia
				Agencia.getAgencia().addTicketBusquedaDeEmpleado( empleadores.get(i).altaTicket(formulario,request.getCantEmpleados()) );
				
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
