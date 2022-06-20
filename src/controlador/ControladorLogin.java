package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exception.ContrasenaIncorrectaException;
import exception.UsuarioIncorrectoException;
import model.Agencia;
import vista.ILogin;
import vista.VistaLogin;

public class ControladorLogin implements ActionListener {
	private Agencia agencia;
	private ILogin vistaLogin;

	public ControladorLogin() {
		this.vistaLogin = new VistaLogin();
		this.agencia = Agencia.getAgencia();
		this.vistaLogin.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("LOGIN")) {
			try {
				this.agencia.login(vistaLogin.getUsername(), vistaLogin.getContrasena());
			} catch (UsuarioIncorrectoException err) {
				this.vistaLogin.usuarioNoEncontrado();
			} catch (ContrasenaIncorrectaException err) {
				this.vistaLogin.contrasenaIncorrecta();
			}
		}

	}

	public ILogin getVistaLogin() {
		return vistaLogin;
	}

	public void setVistaLogin(ILogin vistaLogin) {
		this.vistaLogin = vistaLogin;
	}
}
