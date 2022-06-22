package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import vista.VistaRegistro;
import vista.VistaRegistroAdministrador;
import vista.VistaRegistroEmpleador;

public class ControladorRegistroEmpleador implements ActionListener {

	private VistaRegistroEmpleador vista;
	
	public void setVista(VistaRegistroEmpleador vista) {
		this.vista=vista;
	}

	@Override
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
