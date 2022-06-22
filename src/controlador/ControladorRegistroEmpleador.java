package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import dto.RegistroRequestEmpleador;
import vista.IRegistroEmpleador;
import vista.VistaRegistroEmpleador;

public class ControladorRegistroEmpleador implements ActionListener {
	private IRegistroEmpleador vista;
	private static ControladorRegistroEmpleador controladorRegistroEmpleador = null;

	private ControladorRegistroEmpleador() {
		this.vista = new VistaRegistroEmpleador();
		this.vista.setActionListener(this);
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

			if (comando.equalsIgnoreCase("REGISTRO")) {
				RegistroRequestEmpleador NuevoU = vista.getFormulario(); //Aca guardamos el formulario
			}else if (comando.equalsIgnoreCase("VOLVER")){
				ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Contralador para la vista del registro
				this.vista.esconder();
		}

	}
	
	
}