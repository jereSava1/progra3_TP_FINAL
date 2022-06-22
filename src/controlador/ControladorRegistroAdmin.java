package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import vista.IRegistroAdmin;
import vista.VistaRegistro;
import vista.VistaRegistroAdmin;

public class ControladorRegistroAdmin implements ActionListener{
	private IRegistroAdmin vista;
	private static ControladorRegistroAdmin controladorRegistroAdmin = null;
	
	private ControladorRegistroAdmin() {

		this.vista = new VistaRegistroAdmin();
		this.vista.setActionListener(this);
	};

	public static ControladorRegistroAdmin getControladorRegistroAdmin() {
		if (controladorRegistroAdmin == null) {
			controladorRegistroAdmin = new ControladorRegistroAdmin();
		}
		return controladorRegistroAdmin;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("REGISTRO")) {
			RegistroRequestAdmin NuevoU = vista.getFormulario(); //Aca guardamos el formulario
		}else if (comando.equalsIgnoreCase("VOLVER")) {
			ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Contraolador para la vista del registro
			this.vista.esconder();
		}
	}
}	

