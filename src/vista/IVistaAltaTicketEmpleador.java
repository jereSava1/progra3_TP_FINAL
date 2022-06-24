package vista;

import java.awt.event.ActionListener;

import dto.TicketDeEmpleadorRequest;

public interface IVistaAltaTicketEmpleador {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void limpiaCampos();
     TicketDeEmpleadorRequest getFormulario();
     void setV1(float v1);
     void setV2(float v2);
     float getV1();
     float getV2();
}
