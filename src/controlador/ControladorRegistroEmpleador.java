package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import dto.RegistroRequestEmpleador;
import model.Agencia;
import vista.IRegistroEmpleador;
import vista.VistaRegistroEmpleador;

public class ControladorRegistroEmpleador implements ActionListener {
	private IRegistroEmpleador vista;
	private Agencia agencia;
	private static ControladorRegistroEmpleador controladorRegistroEmpleador = null;

	private ControladorRegistroEmpleador() {
		this.vista = new VistaRegistroEmpleador();
		this.vista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	}
	public static ControladorRegistroEmpleador getControladorRegistroEmpleador() {
		if (controladorRegistroEmpleador == null) {
			controladorRegistroEmpleador = new ControladorRegistroEmpleador();
		}
		controladorRegistroEmpleador.vista.mostrar();
		return controladorRegistroEmpleador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if (comando.equalsIgnoreCase("REGISTRARSE")) {
				RegistroRequestEmpleador nuevoEmpleadorRequest = vista.getFormulario(); //Aca guardamos el formulario
				agencia.registrarEmpleador(nuevoEmpleadorRequest);
				this.vista.success();
				this.vista.esconder();
				this.vista.limpiaCampos();
				ControladorLogin controladorReg = ControladorLogin.getControladorLogin();
			}else if (comando.equalsIgnoreCase("VOLVER")){
				ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Contralador para la vista del registro
				this.vista.esconder();
				this.vista.limpiaCampos();
		}

	}
	
	
}
