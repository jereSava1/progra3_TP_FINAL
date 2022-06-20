package vista;

import java.awt.event.ActionListener;

public interface ILogin {
	String getUsername();
	String getContrasena();
	void setActionListener(ActionListener actionListener);
	void entrar();
	void registrarse();
}
