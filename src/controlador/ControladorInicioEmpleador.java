package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;

import dto.TicketEmpleadorDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import vista.IVistaIEmpleador;
import vista.VistaSesionEmpleador;

public class ControladorInicioEmpleador implements ActionListener{

	private IVistaIEmpleador vista;
	private static ControladorInicioEmpleador controladorInicioEmpleador=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleador() {
		this.vista = new VistaSesionEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleador get(boolean mostrar){
		if(controladorInicioEmpleador==null)
			controladorInicioEmpleador = new ControladorInicioEmpleador();
		
		String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
		List<TicketBusquedaDeEmpleado> solicitudes = Agencia.getAgencia().getSolicitudes();
		List<TicketBusquedaDeEmpleado> solicitudesUsuario = solicitudes.stream().filter(s -> s.getDueno().getNombreUsuario().equals(nombreEmpleador)). collect(Collectors.toList());
	
		DefaultListModel<TicketEmpleadorDTO> lista = new DefaultListModel<>();

		solicitudesUsuario.forEach(ticket -> { lista.addElement(new TicketEmpleadorDTO(ticket)); } );
		
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
		
		if(comando.equalsIgnoreCase("Baja ticket")) {
			
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
