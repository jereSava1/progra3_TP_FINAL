package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Agencia;
import vista.IVistaIEmpleador;
import vista.VistaInicioEmpleador;
import vista.VistaRegistroAdmin;

public class ControladorInicioEmpleador implements ActionListener{

	private IVistaIEmpleador vista;
	private static ControladorInicioEmpleador controladorInicioEmpleador=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleador() {
		this.vista = new VistaInicioEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleador get(){
		if(controladorInicioEmpleador==null)
			controladorInicioEmpleador = new ControladorInicioEmpleador();
		controladorInicioEmpleador.vista.mostrar();
		return controladorInicioEmpleador;
	}
	
	public void setVista(IVistaIEmpleador vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("Dar de baja mi ticket")) {
		
	    }else if(comando.equalsIgnoreCase("Modifica mi ticket")) {
	    	
	    }else if(comando.equalsIgnoreCase("Generar mi ticket")) {
	    	
	    }else if(comando.equalsIgnoreCase("VER LISTA")) {
	    	
	    }else if(comando.equalsIgnoreCase("INGRESAR")) {
	    	
	    }else if(comando.equalsIgnoreCase("VER RESULTADO")) {
	    	
	    }else if(comando.equalsIgnoreCase("CERRAR SESION")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
	    }
	}
}
