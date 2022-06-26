package vista;

import dto.TicketSimplificadoRequest;
import vista.IVistaGeneral;

public interface IVistaAltaTicketSimplificado extends IVistaGeneral {
	
	TicketSimplificadoRequest getFormulario();
	void limpiaCampos();
}
