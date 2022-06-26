package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.TicketDTO;
import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.usuario.Usuario;
import negocio.TicketService;
import sun.security.krb5.internal.Ticket;
import vista.IListaDeAsignaciones;
import vista.VistaListaDeAsignaciones;

import javax.swing.*;

public class ControladorListaDeAsignacion implements ActionListener {
	
	private IListaDeAsignaciones vistaLista;
	private TicketService ticketService;
	private static ControladorListaDeAsignacion controladorListaDeAsignacion = null;
	private static Agencia agencia;
	private static TicketDTO ticketSeleccionado;

	private ControladorListaDeAsignacion() {
		this.vistaLista = new VistaListaDeAsignaciones();
		this.vistaLista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
		this.ticketService = TicketService.getTicketService();
	};
	
	public static ControladorListaDeAsignacion getControladorListaDeAsignacion(boolean mostrar, TicketDTO ticketSeleccionado) {
		if (controladorListaDeAsignacion == null) {
			controladorListaDeAsignacion = new ControladorListaDeAsignacion();
		}
		ControladorListaDeAsignacion.ticketSeleccionado = ticketSeleccionado;
		//!VER
		Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
		List<UsuarioPuntuadoDTO> usuariosPuntuados = null;
		try {
			usuariosPuntuados = controladorListaDeAsignacion.ticketService.encuentraTicketsDeEmpleador(ticketSeleccionado)
							.getListaDeAsignaciones()
							.stream()
							.map(UsuarioPuntuadoDTO::of).collect(Collectors.toList());
			DefaultListModel<UsuarioPuntuadoDTO> model = new DefaultListModel<>();
			usuariosPuntuados.forEach(model::addElement);
			controladorListaDeAsignacion.vistaLista.setListaDeAsignacion(model);
		} catch (NullPointerException e) {
			controladorListaDeAsignacion.vistaLista.success("Aviso", "La lista de asignaciones aï¿½n no ha sido generada");
		}
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
			ControladorInicioEmpleador controladorInicioEmpleador = ControladorInicioEmpleador.get(true);
		} else if ( comando.equalsIgnoreCase("CONFIRMAR")) {
			List<UsuarioPuntuadoDTO> seleccion = this.vistaLista.getSeleccion();
			ticketService.seleccionarUsuariosPuntuados(seleccion, ticketSeleccionado);

			this.vistaLista.success("Exito", "Seleccion confirmada");
			List<UsuarioPuntuadoDTO> usuariosPuntuados = ticketService.encuentraTicketsDeEmpleador(ControladorListaDeAsignacion.ticketSeleccionado)
							.getListaDeAsignaciones()
							.stream()
							.map(UsuarioPuntuadoDTO::of).collect(Collectors.toList());
			DefaultListModel<UsuarioPuntuadoDTO> model = new DefaultListModel<>();
			usuariosPuntuados.forEach(model::addElement);
			controladorListaDeAsignacion.vistaLista.setListaDeAsignacion(model);
		}
	}
}
