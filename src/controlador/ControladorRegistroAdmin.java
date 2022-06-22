package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import types.TipoUsuario;
import vista.VistaRegistro;
import vista.VistaRegistroAdministrador;

public class ControladorRegistroAdmin implements ActionListener{
	private String nombreUsuario;
	private String contrasena;
	private TipoUsuario tipo;
	private String email;
	private String ID;
	private VistaRegistroAdministrador vista;
	
	public ControladorRegistroAdmin() {};
	
	public void setVista(VistaRegistroAdministrador vista) {
		this.vista=vista;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Registro")) {
			RegistroRequestAdmin NuevoU = vista.getFormulario(); //Aca guardamos el 
			
		}else/* if (e.getActionCommand().equalsIgnoreCase("Volver")) */{  //No tengo idea por que no anda la condicion
			
			ControladorRegistro controladorReg= new ControladorRegistro(); //Contraolador para la vista del registro
			
			this.vista.esconder();
			VistaRegistro registro = new VistaRegistro();
			controladorReg.setVista(registro);
			registro.setActionListener(controladorReg);
			registro.mostrar();
	}
	}
}	

