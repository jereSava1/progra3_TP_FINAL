package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.EmpleadorDTO;
import dto.TicketEmpleadorDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.usuario.UsuarioPuntuado;
import vista.IVistaMuestraListasAdmin;
import vista.IVistaResultadoEmpleador;
import vista.VistaMuestraEmpleadoresAdmin;
import vista.VistaResultadoEmpleador;

public class ControladorResultadoEmpleador implements ActionListener {

	private IVistaResultadoEmpleador vista;
	private static ControladorResultadoEmpleador controladorResultadoEmpleador = null;

	private ControladorResultadoEmpleador() {
		this.vista = new VistaResultadoEmpleador();
		this.vista.setActionListener(this);
	}
	
	public static ControladorResultadoEmpleador getControladorResultadoEmpleador(){
		if (controladorResultadoEmpleador == null) {
			controladorResultadoEmpleador = new ControladorResultadoEmpleador();
		}
		
		TicketEmpleadorDTO ticket = ControladorInicioEmpleador.get(false).getVista().getTicketSeleccionado();
    	List<UsuarioPuntuado> listaAsignacionTicket = ticket.getListaAsignaciones();
    	List<UsuarioPuntuado> contratados = listaAsignacionTicket.stream().filter(s -> s.isContratado()). collect(Collectors.toList());
		
		controladorResultadoEmpleador.vista.getModel().setRowCount(0);
		contratados.forEach( contratado -> {
			Object[] fila = {
				contratado.getUsuario().getNombre()
			};
			controladorResultadoEmpleador.vista.getModel().addRow(fila);
		});
		
		controladorResultadoEmpleador.vista.mostrar();
		
		controladorResultadoEmpleador.vista.setTextAreaEmpleadosObtenidos(Integer.toString( ticket.getEmpleadosObtenidos() ));
		controladorResultadoEmpleador.vista.setTextAreaEmpleadosSolicitados(Integer.toString( ticket.getEmpleadosNecesitados() ));
		
		return controladorResultadoEmpleador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vista.esconder();
			
		}
		
	}

}
