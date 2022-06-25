package vista;

import java.awt.event.ActionListener;
import java.util.List;

import dto.UsuarioPuntuadoDTO;
import model.usuario.UsuarioPuntuado;

public interface IListaEmpleadosPretensos {
	void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    void setListaDeAsignacion(List<UsuarioPuntuadoDTO> lista);
}
