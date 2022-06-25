package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Usuario;
import vista.IListaEmpleadosPretensos;
import vista.VistaListaEmpleadores;

public class ControladorListaEmpleadores implements ActionListener {
	
	private IListaEmpleadosPretensos vistaLista;
	private static ControladorListaEmpleadores ControladorListaEmpleadores=null;
	private Agencia agencia;

	private ControladorListaEmpleadores() {
		this.vistaLista = new VistaListaEmpleadores();
		this.vistaLista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	};
	
	public static ControladorListaEmpleadores getControladorListaEmpleadores() {
		if (ControladorListaEmpleadores == null) {
			ControladorListaEmpleadores = new ControladorListaEmpleadores();
		}
		//!VER
		Usuario usuario = ControladorLogin.getLogueado();
		List<UsuarioPuntuadoDTO> usuariosPuntuados = Agencia.getAgencia().encuentraTicketDeEmpleo(usuario)
																											.getListaDeAsignaciones()
																															.stream()
																																			.map(UsuarioPuntuadoDTO::of).collect(Collectors.toList());
		ControladorListaEmpleadores.vistaLista.setListaDeAsignacion(usuariosPuntuados);
		
		ControladorListaEmpleadores.vistaLista.mostrar();
		return ControladorListaEmpleadores;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado();
			this.vistaLista.esconder();
		}
		
	}

}
