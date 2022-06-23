package vista;

import java.awt.event.ActionListener;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;

public interface IVistaModificarTicketEmpleado {

    void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    TicketDeEmpleadoRequest getFormulario() throws ConstructorInvalidoException;
	
}
