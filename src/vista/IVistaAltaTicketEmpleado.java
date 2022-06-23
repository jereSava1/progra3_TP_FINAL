package vista;

import java.awt.event.ActionListener;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;

public interface IVistaAltaTicketEmpleado {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void limpiaCampos();
     TicketDeEmpleadoRequest getFormulario() throws ConstructorInvalidoException;
}
