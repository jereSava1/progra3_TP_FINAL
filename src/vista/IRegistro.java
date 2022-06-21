package vista;

import java.awt.event.ActionListener;

import dto.RegistroRequest;

public interface IRegistro {
	void mostrar();
	void esconder();
	RegistroRequest getFormulario();
	void setActionListener(ActionListener actionListener);
}
