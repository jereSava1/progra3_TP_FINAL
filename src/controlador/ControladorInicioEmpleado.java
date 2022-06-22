package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Agencia;
import vista.IVistaIEmpleado;
import vista.VistaSesionEmpleado;

public class ControladorInicioEmpleado implements ActionListener {

	private IVistaIEmpleado vista;
	private static ControladorInicioEmpleado controladorInicioEmpleado=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleado() {
		this.vista = new VistaSesionEmpleado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleado get(){
		if(controladorInicioEmpleado==null)
			controladorInicioEmpleado = new ControladorInicioEmpleado();
		controladorInicioEmpleado.vista.mostrar();
		return controladorInicioEmpleado;
	}
	
	public void setVista(IVistaIEmpleado vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("GESTIONAR")) {
		
	    }else if(comando.equalsIgnoreCase("VER LISTA")) {
	    	
	    }else if(comando.equalsIgnoreCase("INGRESAR")) {
	    	
	    }else if(comando.equalsIgnoreCase("VER RESULTADO")) {
	    	
	    }else if(comando.equalsIgnoreCase("CERRAR SESION")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
	    }
	}

}
