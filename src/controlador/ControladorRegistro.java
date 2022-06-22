package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import types.TipoUsuario;
import vista.IRegistro;
import vista.IRegistroAdmin;
import vista.VistaLogin;
import vista.VistaRegistro;
import vista.VistaRegistroAdministrador;
import vista.VistaRegistroEmpleador;

public class ControladorRegistro implements ActionListener {
	private VistaRegistro vistaRegistro;

	public ControladorRegistro() {}
	
	public void setVista(VistaRegistro vistaRegistro) {
		this.vistaRegistro=vistaRegistro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand().equalsIgnoreCase("SIGUIENTE")) {
			String comando = this.vistaRegistro.getG().getSelection().getActionCommand(); 
			if (comando.equalsIgnoreCase("admin")) {
				this.vistaRegistro.esconder();
				VistaRegistroAdministrador vistaRegistroAdmin= new VistaRegistroAdministrador();
				ControladorRegistroAdmin controladorAdmin = new ControladorRegistroAdmin();
				controladorAdmin.setVista(vistaRegistroAdmin);
				vistaRegistroAdmin.setActionListener(controladorAdmin);
				vistaRegistroAdmin.mostrar();
			}

			else if (comando.equalsIgnoreCase("empleado")) {
				this.vistaRegistro.esconder();
				VistaLogin login = new VistaLogin();
				ControladorLogin controladorLogin = new ControladorLogin();
				controladorLogin.setVistaLogin(login);
				login.setActionListener(controladorLogin);
				login.mostrar();

			} 
			else if (comando.equalsIgnoreCase("empleador")) {
				this.vistaRegistro.esconder();
				VistaRegistroEmpleador VistaEmpleador = new VistaRegistroEmpleador();
				ControladorRegistroEmpleador controladorEmpleador = new ControladorRegistroEmpleador();
				controladorEmpleador.setVista(VistaEmpleador);
				VistaEmpleador.setActionListener(controladorEmpleador);
				VistaEmpleador.mostrar();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("VOLVER")) {
			this.vistaRegistro.esconder();
			VistaLogin login = new VistaLogin();
			ControladorLogin controladorLogin = new ControladorLogin();
			controladorLogin.setVistaLogin(login);
			login.setActionListener(controladorLogin);
			login.mostrar();
		}
	}

}
