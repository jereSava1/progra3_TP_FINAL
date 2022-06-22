package vista;

import java.awt.event.ActionListener;
import dto.RegistroRequestAdmin;

public interface IRegistroAdmin {
	void mostrar();
	void esconder();
	void setActionListener(ActionListener actionListener);
	RegistroRequestAdmin getFormulario();

}