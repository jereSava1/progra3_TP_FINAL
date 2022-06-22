package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dto.RegistroRequestEmpleado;
import model.Agencia;
import vista.IRegistroEmpleado;
import vista.VistaRegistroEmpleadoPretenso;

public class ControladorRegistroEmpleado implements ActionListener {
	private IRegistroEmpleado vista;
	private Agencia agencia;
	private static ControladorRegistroEmpleado controladorRegistroEmpleado = null;

	private ControladorRegistroEmpleado() {
		this.vista = new VistaRegistroEmpleadoPretenso();
		this.vista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	}
	public static ControladorRegistroEmpleado getControladorRegistroEmpleado() {
		if (controladorRegistroEmpleado == null) {
			controladorRegistroEmpleado = new ControladorRegistroEmpleado();
		}
		controladorRegistroEmpleado.vista.mostrar();
		return controladorRegistroEmpleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if (comando.equalsIgnoreCase("REGISTRARSE")) {
				RegistroRequestEmpleado nuevoEmpleadoRequest = vista.getFormulario(); //Aca guardamos el formulario
				agencia.registrarEmpleado(nuevoEmpleadoRequest);
				this.vista.success();
				this.vista.esconder();
				this.vista.limpiaCampos();
				ControladorLogin controladorReg = ControladorLogin.getControladorLogin();
			}else if (comando.equalsIgnoreCase("VOLVER")){
				ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Controlador para la vista del registro
				this.vista.limpiaCampos();
				this.vista.esconder();
		}

	}
	
	
}
