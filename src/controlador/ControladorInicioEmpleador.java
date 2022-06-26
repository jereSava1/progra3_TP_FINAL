package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;

import dto.TicketEmpleadorDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import negocio.TicketService;
import vista.IVistaIEmpleador;
import vista.VistaSesionEmpleador;

public class ControladorInicioEmpleador implements ActionListener{

	private IVistaIEmpleador vista;
	private static ControladorInicioEmpleador controladorInicioEmpleador=null;
	private Agencia agencia;
	private TicketService ticketService;
	
	private ControladorInicioEmpleador() {
		this.vista = new VistaSesionEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
		this.ticketService = TicketService.getTicketService();
	};
	
	public static ControladorInicioEmpleador get(boolean mostrar){
		if(controladorInicioEmpleador==null)
			controladorInicioEmpleador = new ControladorInicioEmpleador();
		
		String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
		List<TicketEmpleadorDTO> solicitudes = Agencia.getAgencia().getListaSolicitudes(nombreEmpleador);
		DefaultListModel<TicketEmpleadorDTO> lista = new DefaultListModel<>();
		solicitudes.forEach(ticket -> { lista.addElement(ticket); } );
		
		controladorInicioEmpleador.vista.setModel(lista);

		if( mostrar )
			controladorInicioEmpleador.vista.mostrar();
		
		return controladorInicioEmpleador;
	}
	
	public void setVista(IVistaIEmpleador vista) {
		this.vista=vista;
	}
	

	public IVistaIEmpleador getVista() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("BAJA")) {
			TicketEmpleadorDTO ticket = this.vista.getTicketSeleccionado();
			if(ticket!=null) {
				try {
					ticketService.bajaTicketEmpleador(ticket);
					this.vista.success("Baja de ticket", "Ticket borrado con éxito");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
				DefaultListModel updatedList = new DefaultListModel();
				List<TicketEmpleadorDTO> solicitudes = Agencia.getAgencia().getListaSolicitudes(nombreEmpleador);
				solicitudes.forEach(t -> { updatedList.addElement(t); } );
				this.vista.setModel(updatedList);
			}
	    }else if(comando.equalsIgnoreCase("Modificar ticket")) {
	    	
	    }else if(comando.equalsIgnoreCase("Alta ticket")) {
	    	this.vista.esconder();
	    	ControladorAltaTicketEmpleador controladorAltaTicket = ControladorAltaTicketEmpleador.get();
	    }else if(comando.equalsIgnoreCase("Lista de Asignacion")) {
	    	
	    }else if(comando.equalsIgnoreCase("Ronda de Elecciones")) {
	    	
	    }else if(comando.equalsIgnoreCase("Resultados")) {
	    	
	    }else if(comando.equalsIgnoreCase("Cerrar sesion")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
	    }
	}
}
