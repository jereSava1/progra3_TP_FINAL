package controlador;

import model.Agencia;
import vista.IVistaAltaTicketSimplificado;
import vista.VistaAltaTicketSimplificado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEleccionTicketSimplificado implements ActionListener {

	private IVistaAltaTicketSimplificado vista;
	private static ControladorEleccionTicketSimplificado controladorEleccionTicketSimplificado=null;
	private Agencia agencia;
	
	private ControladorEleccionTicketSimplificado() {
		this.vista = new VistaAltaTicketSimplificado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorEleccionTicketSimplificado getControladorEleccionTicketSimplificado(){
		if(controladorEleccionTicketSimplificado == null)
			controladorEleccionTicketSimplificado = new ControladorEleccionTicketSimplificado();
		controladorEleccionTicketSimplificado.vista.mostrar();
		return controladorEleccionTicketSimplificado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
