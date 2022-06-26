package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.TicketDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Usuario;
import model.usuario.UsuarioPuntuado;
import negocio.RondaDeContrataciones;
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
	
	public static ControladorInicioEmpleado getControladorInicioEmpleado(boolean mostrar){
		if(controladorInicioEmpleado==null)
			controladorInicioEmpleado = new ControladorInicioEmpleado();
		if( mostrar )
			controladorInicioEmpleado.vista.mostrar();
		return controladorInicioEmpleado;
	}
	
	public void setVista(IVistaIEmpleado vista) {
		this.vista=vista;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
		
		TicketDTO ticket = new TicketDTO(agencia.getAgencia().encuentraTicketDeEmpleo(usuario));
		System.out.println(ticket);
        
		if(comando.equalsIgnoreCase("Dar de baja mi ticket")) {
			
			if( ticket!=null ) {
				agencia.cancelaTicket(ticket);
				JOptionPane.showMessageDialog(null, "Ticket dado de baja con exito", "Ticket", JOptionPane.INFORMATION_MESSAGE);
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
	    	
	    	if( ticket == null) {
	    		this.vista.esconder();
		    	ControladorAltaTicketEmpleado controladorAltaTicketEmpleado = ControladorAltaTicketEmpleado.get();
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "Usted ya tiene un ticket de busqueda de empleo activo", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	
		
	    }else if(comando.equalsIgnoreCase("VER LISTA")) {
	    	
	    	if( (ticket!=null) && (RondaDeEncuentro.isActivada())) {

					ControladorListaDeAsignacion controladorListaEmpleadores = ControladorListaDeAsignacion.getControladorListaDeAsignacion(true, ticket);
					this.vista.esconder();
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
	    	if( RondaDeContrataciones.isActivada() ) {
	    		UsuarioPuntuado contratado = ticket.getListaAsignaciones().stream().filter(t -> t.isContratado() == true).findAny().orElse(null);
	    		if( contratado != null ) {
	    			this.vista.success("Has sido contratado por: " + contratado.getUsuario().getNombre(), "Resultado" );
	    		}else {
	    			this.vista.success("No has sido contratado", "Resultado");
	    		}
	    	}else{
	    		this.vista.failure("Ronda de contrataciones inactiva", "Resultado");
	    	}
	    	
	    	
	    }else if(comando.equalsIgnoreCase("CERRAR SESION")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
	    }
  }
}	
