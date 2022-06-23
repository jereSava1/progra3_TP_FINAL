package vista;

import java.awt.event.ActionListener;

public interface IVistaSesionAdmin {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     float getMaximo();
     float getMinimo();
     void limpiaCampos();
}