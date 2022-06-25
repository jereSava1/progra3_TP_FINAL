package vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.ticket.TicketBusquedaDeEmpleado;

public interface IVistaIEmpleador {
       void mostrar();
       void esconder();
       void setActionListener(ActionListener actionListener);
       JList getListaTickets();
       void setListaTickets(JList listaTickets);
       DefaultListModel<TicketBusquedaDeEmpleado> getTickets();
	   void setTickets(DefaultListModel<TicketBusquedaDeEmpleado> tickets);
	   void setModel(DefaultListModel<TicketBusquedaDeEmpleado> model);
}
