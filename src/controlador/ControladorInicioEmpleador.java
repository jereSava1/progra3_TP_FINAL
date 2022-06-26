package controlador;

import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import vista.IVistaIEmpleador;
import vista.VistaSesionEmpleador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorInicioEmpleador implements ActionListener{

	private IVistaIEmpleador vista;
	private static ControladorInicioEmpleador controladorInicioEmpleador=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleador() {
		this.vista = new VistaSesionEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleador get(){
		if(controladorInicioEmpleador==null)
			controladorInicioEmpleador = new ControladorInicioEmpleador();
		
		String nombreEmpleador = ControladorLogin.getLogueado().getNombreUsuario();
		List<TicketBusquedaDeEmpleado> solicitudes = Agencia.getAgencia().getSolicitudes();
		List<TicketBusquedaDeEmpleado> solicitudesUsuario = solicitudes.stream().filter(s -> s.getDueno().getNombreUsuario().equals(nombreEmpleador)). collect(Collectors.toList());
	
		DefaultListModel<TicketBusquedaDeEmpleado> lista = new DefaultListModel<>();
		for (TicketBusquedaDeEmpleado ticket : solicitudesUsuario) {
			Object[] infoTicket = {
					"Fecha de alta: " + ticket.getFechaDeAlta(),
					"Empleados solicitados: " + ticket.getEmpleadosNecesitados(),
					"Empleados obtenidos" + ticket.getEmpleadosObtenidos(),
					"Estado " + ticket.getEstadoTicket().getNombre()
			};
			
			lista.addElement(infoTicket);
		}
		
		controladorInicioEmpleador.vista.setModel(lista);
			
		controladorInicioEmpleador.vista.mostrar();
		
		return controladorInicioEmpleador;
	}
	
	public void setVista(IVistaIEmpleador vista) {
		this.vista=vista;
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
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
	    }
	}
}
