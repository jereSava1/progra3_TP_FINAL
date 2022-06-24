package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Usuario;
import negocio.RondaDeEncuentro;
import state.CanceladoState;
import vista.IVistaIEmpleado;
import vista.VistaSesionEmpleado;

public class ControladorInicioEmpleado implements ActionListener {

	private IVistaIEmpleado vista;
	private static ControladorInicioEmpleado controladorInicioEmpleado=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleado() {
		this.vista = new VistaSesionEmpleado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleado getControladorInicioEmpleado(){
		if(controladorInicioEmpleado==null)
			controladorInicioEmpleado = new ControladorInicioEmpleado();
		controladorInicioEmpleado.vista.mostrar();
		return controladorInicioEmpleado;
	}
	
	public void setVista(IVistaIEmpleado vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		Usuario usuario = ControladorLogin.getLogueado();
		
		TicketBusquedaDeEmpleo ticket = agencia.getAgencia().encuentraTicketDeEmpleo(usuario);
        
		if(comando.equalsIgnoreCase("Dar de baja mi ticket")) {
			
			if( ticket!=null ) {
				ticket.setEstadoTicket(new CanceladoState(ticket));
				Agencia.getAgencia().removeTicketBusquedaDeEmpleo(ticket);
			}
			else
				JOptionPane.showMessageDialog(null, "Usted no tiene creado un ticket de busqueda de empleo", "Error", JOptionPane.ERROR_MESSAGE);
			
	    }else if(comando.equalsIgnoreCase("Modifica mi ticket")) {
	    	
	    	if( ticket!=null ) {
	    		this.vista.esconder();
	    		ControladorModificarTicketEmpleado controladorModificarTicketEmpleado = ControladorModificarTicketEmpleado.getControladorModificarTicketEmpleado();
	    	}
			else
				JOptionPane.showMessageDialog(null, "Usted no tiene creado un ticket de busqueda de empleo", "Error", JOptionPane.ERROR_MESSAGE);
	    	
	    }else if(comando.equalsIgnoreCase("Generar mi ticket")) {
	    	
	    	if( ticket==null) {
	    		this.vista.esconder();
		    	ControladorAltaTicketEmpleado controladorAltaTicketEmpleado = ControladorAltaTicketEmpleado.get();
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "Usted ya tiene un ticket de busqueda de empleo activo", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	
		
	    }else if(comando.equalsIgnoreCase("VER LISTA")) {
	    	
	    	if( (ticket!=null) && (RondaDeEncuentro.isActivada() == true)) {
	    		this.vista.esconder();
		    	ControladorListaEmpleadores controladorListaEmpleadores = ControladorListaEmpleadores.getControladorListaEmpleadores();
		    	
	    	}else {
	    		if( ticket == null )
	    			JOptionPane.showMessageDialog(null, "Usted no tiene creado un ticket de busqueda de empleo", "Error", JOptionPane.ERROR_MESSAGE);
	    		else
	    			JOptionPane.showMessageDialog(null, "No se ha ejecutado la ronda de encuentros", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	
	    	
	    }else if(comando.equalsIgnoreCase("INGRESAR")) {
	    	
	    	if( (ticket!=null) && (RondaDeEncuentro.isActivada() == true)) {
	    		this.vista.esconder();
		    	//ControladorEleccionEmpleadores ControladorEleccionEmpleadores = ControladorEleccionEmpleadores.getControladorEleccionEmpleadores();
		    	//Llenar lista con lista de asignaciones del ticket 
	    	}else {
	    		if( ticket==null )
	    			JOptionPane.showMessageDialog(null, "Usted no tiene creado un ticket de busqueda de empleo", "Error", JOptionPane.ERROR_MESSAGE);
	    		else
	    			JOptionPane.showMessageDialog(null, "No se ha ejecutado la ronda de encuentros", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	
	    }else if(comando.equalsIgnoreCase("VER RESULTADO")) {
	    	
	    	//Si ha sido contratado nos muestra el nombre del empleador y datos del empleo, caso contrario vuelve a la vista sesion
	    	
	    }else if(comando.equalsIgnoreCase("CERRAR SESION")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin();
	    }
  }
}	
