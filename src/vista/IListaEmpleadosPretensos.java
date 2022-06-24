package vista;

import java.awt.event.ActionListener;
import java.util.List;

import model.usuario.UsuarioPuntuado;

public interface IListaEmpleadosPretensos {
	void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    void setListaDeAsignacion(List<UsuarioPuntuado> lista);
}
