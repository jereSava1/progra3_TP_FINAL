package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.IRegistro;
import vista.VistaRegistro;

public class ControladorRegistro implements ActionListener {
	private IRegistro vistaRegistro;
	
	public ControladorRegistro() {
		this.vistaRegistro = new VistaRegistro();
		vistaRegistro.setActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
	}
	
}
