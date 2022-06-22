package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.*;

public class ControladorRegistro implements ActionListener {
	private IRegistro vistaRegistro;
	private static ControladorRegistro controladorRegistro = null;

	private ControladorRegistro() {
		this.vistaRegistro = new VistaRegistro();
		this.vistaRegistro.setActionListener(this);
	}

	public static ControladorRegistro getControladorRegistro(){
		if (controladorRegistro == null) {
			controladorRegistro = new ControladorRegistro();
		}
		controladorRegistro.vistaRegistro.mostrar();
		return controladorRegistro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("SIGUIENTE")) {
			String comando = this.vistaRegistro.getG().getSelection().getActionCommand();
			if (comando.equalsIgnoreCase("admin")) {
				this.vistaRegistro.esconder();
				ControladorRegistroAdmin controladorAdmin = ControladorRegistroAdmin.getControladorRegistroAdmin();
			} else if (comando.equalsIgnoreCase("empleado")) {
				this.vistaRegistro.esconder();
				ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
			} else if (comando.equalsIgnoreCase("empleador")) {

				this.vistaRegistro.esconder();
				ControladorRegistroEmpleador controladorEmpleador = ControladorRegistroEmpleador.getControladorRegistroEmpleador();
			}
		} else if (e.getActionCommand().equalsIgnoreCase("VOLVER")) {
			this.vistaRegistro.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
		}
	}

}
