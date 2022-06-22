package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Agencia;
import vista.IVistaSesionAdmin;
import vista.VistaSesionAdmin;

public class ControladorSesionAdmin implements ActionListener {

	private IVistaSesionAdmin vista;
	private static ControladorSesionAdmin controladorSesionAdmin=null;
	private Agencia agencia;
	
	private ControladorSesionAdmin() {
		this.vista = new VistaSesionAdmin();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorSesionAdmin get(){
		if(controladorSesionAdmin==null)
			controladorSesionAdmin = new ControladorSesionAdmin();
		controladorSesionAdmin.vista.mostrar();
		return controladorSesionAdmin;
	}
	
	public void setVista(IVistaSesionAdmin vista) {
		this.vista=vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("Ver Empleadores")){
			
		}else if(comando.equalsIgnoreCase("Ver Empleados")){
			
		}else if(comando.equalsIgnoreCase("Ver Comisones")) {
			
		}else if(comando.equalsIgnoreCase("Activar Encuentros")) {
			
		}else if(comando.equalsIgnoreCase("Activar Contrataciones")) {
			
		}else if(comando.equalsIgnoreCase("Cerrar Sesion")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
		}
	}
	
	

}
