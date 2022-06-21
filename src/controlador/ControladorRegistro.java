package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import types.TipoUsuario;
import vista.IRegistro;
import vista.IRegistroAdmin;
import vista.VistaLogin;
import vista.VistaRegistro;
import vista.VistaRegistroAdministrador;

public class ControladorRegistro implements ActionListener {
	private IRegistro vistaRegistro;

		public ControladorRegistro() {
		this.vistaRegistro = new VistaRegistro();
		vistaRegistro.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TipoUsuario comando = TipoUsuario.valueOf(this.vistaRegistro.getG().getSelection().getActionCommand());
		System.out.println("aaaaaaaaaaa         "+e.getActionCommand());
		
		 if (e.getActionCommand().equalsIgnoreCase("SIGUIENTE")) {
			System.out.println("ENTREEEEEEEEEEEEEEEEEE");
			if (comando == TipoUsuario.ADMIN) {
				this.vistaRegistro.esconder();
				VistaRegistroAdministrador vistaRegistroAdmin= new VistaRegistroAdministrador();
				vistaRegistroAdmin.mostrar();
			}

			else if (comando == TipoUsuario.EMPLEADO) {
				this.vistaRegistro.esconder();

			} 
			else if (comando == TipoUsuario.EMPLEADOR) {
				this.vistaRegistro.esconder();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("VOLVER")) {
			this.vistaRegistro.esconder();
			VistaLogin login=new VistaLogin();
			login.mostrar();
		}
	}

}
