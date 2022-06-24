package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleador;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaMuestraListasAdmin;
import vista.VistaAltaTicketEmpleado;
import vista.VistaComisionesAdmin;
import vista.VistaMuestraEmpleadoresAdmin;
import vista.VistaMuestraEmpleadosAdmin;

public class ControladorComisionesAdmin implements ActionListener {

	private IVistaMuestraListasAdmin vista;
	private static ControladorComisionesAdmin controladorComisionesAdmin = null;

	private ControladorComisionesAdmin() {
		this.vista = new VistaComisionesAdmin();
		this.vista.setActionListener(this);
	}
	
	public static ControladorComisionesAdmin getControladorComisionesAdmin(){
		if (controladorComisionesAdmin == null) {
			controladorComisionesAdmin = new ControladorComisionesAdmin();
		}
		
		List<TicketBusquedaDeEmpleo> busquedas = Agencia.getAgencia().getBusquedas();
		
		List<TicketBusquedaDeEmpleado> solicitudes = Agencia.getAgencia().getSolicitudes();
		for (TicketBusquedaDeEmpleado solicitud : solicitudes) {
			if( Agenci )
		}
		
		controladorComisionesAdmin.vista.getModel().setRowCount(0);
		for (Empleador empleador : empleadores) {
			
			Object[] fila = {
				empleador.getNombre(),	
				empleador.getRubro(),
				empleador.getTipoPersona(),
				empleador.getPuntaje()
			};
			
			controladorComisionesAdmin.vista.getModel().addRow(fila);	
			
		}
		
		controladorComisionesAdmin.vista.mostrar();
		
		return controladorComisionesAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vista.esconder();
			ControladorSesionAdmin CAdmin = ControladorSesionAdmin.get();
		}
		
	}

}
