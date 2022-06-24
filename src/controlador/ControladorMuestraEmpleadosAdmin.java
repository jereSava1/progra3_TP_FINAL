package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import model.Agencia;
import model.usuario.Empleado;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaMuestraListasAdmin;
import vista.VistaAltaTicketEmpleado;
import vista.VistaMuestraEmpleadosAdmin;

public class ControladorMuestraEmpleadosAdmin implements ActionListener {

	private IVistaMuestraListasAdmin vista;
	private static ControladorMuestraEmpleadosAdmin controladorMuestraEmpleadosAdmin = null;

	private ControladorMuestraEmpleadosAdmin() {
		this.vista = new VistaMuestraEmpleadosAdmin();
		this.vista.setActionListener(this);
	}
	
	public static ControladorMuestraEmpleadosAdmin getControladorMuestraEmpleadosAdmin(){
		if (controladorMuestraEmpleadosAdmin == null) {
			controladorMuestraEmpleadosAdmin = new ControladorMuestraEmpleadosAdmin();
		}
		
		Set<Empleado> empleados = Agencia.getAgencia().getEmpleados();
		
		controladorMuestraEmpleadosAdmin.vista.getModel().setRowCount(0);
		for (Empleado empleado : empleados) {
			
			Object[] fila = {
				empleado.getNombre(),	
				empleado.getEmail(),
				empleado.getTelefono(),
				empleado.getPuntaje()
			};
			
			controladorMuestraEmpleadosAdmin.vista.getModel().addRow(fila);	
			
		}
		
		controladorMuestraEmpleadosAdmin.vista.mostrar();
		
		return controladorMuestraEmpleadosAdmin;
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
