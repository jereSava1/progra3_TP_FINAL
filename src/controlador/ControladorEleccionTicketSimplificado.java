package controlador;

import model.Agencia;
import vista.IVistaAltaTicketSimplificado;
import vista.VistaAltaTicketSimplificado;

public class ControladorEleccionTicketSimplificado {

	private IVista vista;
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

}
