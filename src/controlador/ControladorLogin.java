package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exception.ContrasenaIncorrectaException;
import exception.UsuarioIncorrectoException;
import model.Agencia;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.Usuario;
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
			Usuario logueado = null;
			
			try {
				logueado = this.agencia.login(vistaLogin.getUsername(), vistaLogin.getContrasena());
			} catch (UsuarioIncorrectoException err) {
				this.vistaLogin.usuarioNoEncontrado();
			} catch (ContrasenaIncorrectaException err) {
				this.vistaLogin.contrasenaIncorrecta();
			}
			
			if (logueado != null) {
				this.vistaLogin.esconder();
				if (logueado instanceof Empleador) {
					//TODO: Vista de empleador
				} else if (logueado instanceof Empleado) {
					//TODO: Vista de empleado
				} else {
					//TODO: Vista de agencia
				}
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
