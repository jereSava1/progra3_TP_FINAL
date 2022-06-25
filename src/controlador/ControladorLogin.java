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
import vista.VistaRegistro;

public class ControladorLogin implements ActionListener {
	private Agencia agencia;
	private ILogin vistaLogin;
	private static Usuario logueado = null;
	public Agencia getAgencia() {
		return agencia;
	}
	
	private static ControladorLogin controladorLogin = null;
	
	private ControladorLogin() {
		this.vistaLogin = new VistaLogin();
		this.agencia = Agencia.getAgencia();
		this.vistaLogin.setActionListener(this);
	}
	
	public static ControladorLogin getControladorLogin() {
		if (controladorLogin == null) {
			controladorLogin = new ControladorLogin();
		}
		logueado=null;
		controladorLogin.vistaLogin.mostrar();
		return controladorLogin;
	}
	
	public ILogin getVistaLogin() {
		return vistaLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("LOGIN")) {
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
					ControladorInicioEmpleador CEmpleador = ControladorInicioEmpleador.get();
				} else if (logueado instanceof Empleado) {
					ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado();
				} else {
					ControladorSesionAdmin CAdmin = ControladorSesionAdmin.get();
				}
			}
			this.vistaLogin.limpiaCampos();
		} else if (comando.equalsIgnoreCase("REGISTRAR")) {
			ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); // Contraolador para la vista del registro
			this.vistaLogin.esconder();
			this.vistaLogin.limpiaCampos();
		}

	}

	public static Usuario getLogueado() {
		return logueado;
	}   	

}
