package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Agencia;
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
			//GuardoELTicket
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.get();
		}
		
	}

}
