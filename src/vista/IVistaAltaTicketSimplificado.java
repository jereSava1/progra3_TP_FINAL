package vista;

import dto.TicketSimplificadoRequest;
import vista.IVistaGeneral;

public interface IVistaAltaTicketSimplificado extends IVistaGeneral {
	
	TicketSimplificadoRequest getTicketSimplificado();
	void limpiaCampos();
	void failure(String titulo, String mensaje);
}
