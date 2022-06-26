package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.TicketDTO;
import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.ticket.Ticket;
import model.usuario.Usuario;
import vista.IListaEmpleadosPretensos;
import vista.VistaListaDeAsignaciones;

import javax.swing.*;

public class ControladorListaDeAsignacion implements ActionListener {
	
	private IListaEmpleadosPretensos vistaLista;
	private static ControladorListaDeAsignacion controladorListaDeAsignacion = null;
	private static Agencia agencia;

	private ControladorListaDeAsignacion() {
		this.vistaLista = new VistaListaDeAsignaciones();
		this.vistaLista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	};
	
	public static ControladorListaDeAsignacion getControladorListaDeAsignacion(boolean mostrar, TicketDTO ticketSeleccionado) {
		if (controladorListaDeAsignacion == null) {
			controladorListaDeAsignacion = new ControladorListaDeAsignacion();
		}
		//!VER
		Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
		List<UsuarioPuntuadoDTO> usuariosPuntuados = null;
		try {
			usuariosPuntuados = agencia.encuentraTicketsDeEmpleador(ticketSeleccionado.getId())
							.getListaDeAsignaciones()
							.stream()
							.map(UsuarioPuntuadoDTO::of).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			controladorListaDeAsignacion.vistaLista.success("Aviso", "La lista de asignaciones aún no ha sido generada");
		}
		DefaultListModel<UsuarioPuntuadoDTO> model = new DefaultListModel<>();
		usuariosPuntuados.forEach(model::addElement);
		controladorListaDeAsignacion.vistaLista.setListaDeAsignacion(model);

		if (mostrar && usuariosPuntuados != null) {
			controladorListaDeAsignacion.vistaLista.mostrar();
		} else if (usuariosPuntuados == null) {
			ControladorInicioEmpleador.get(true);
		}
		return controladorListaDeAsignacion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vistaLista.esconder();
			ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
		}
		
	}

}
