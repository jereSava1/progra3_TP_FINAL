package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ControladorAltaTicketEmpleador;
import controlador.ControladorInicioEmpleado;
import model.Agencia;
import vista.IVistaAltaTicketSimplificado;
import vista.VistaAltaTicketSimplificado;

public class ControladorAltaTicketSimplificado implements ActionListener{

	private IVistaAltaTicketSimplificado vista;
	private static ControladorAltaTicketSimplificado controladorAltaTicket=null;
	private Agencia agencia;
	
	private ControladorAltaTicketSimplificado() {
		this.vista = new VistaAltaTicketSimplificado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorAltaTicketSimplificado get(){
		if(controladorAltaTicket==null)
			controladorAltaTicket = new ControladorAltaTicketSimplificado();
		controladorAltaTicket.vista.mostrar();
		return controladorAltaTicket;
	}
	
	public void setVista(IVistaAltaTicketSimplificado vista) {
		this.vista=vista;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("FINALIZAR")) {
			//Guardo el ticket en la "Bolsa de empleo", aca pasa la concurrencia
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
		}
	}

}