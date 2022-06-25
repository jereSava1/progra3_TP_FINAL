package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import model.ticket.TicketBusquedaDeEmpleado;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class VistaSesionEmpleador extends JFrame implements IVistaIEmpleador{

	private JPanel contentPane;
	private JButton btnAltaTicket;
	private JButton btnBajaTicket;
	private JButton btnModificarTicket;
	private JButton btnListaDeAsignacion;
	private JButton btnRondaDeEleccion;
	private JButton btnResultado;
	private JButton btnCerrarSesion;
	private DefaultListModel<TicketBusquedaDeEmpleado> tickets;
	
	private JList<TicketBusquedaDeEmpleado> listaTickets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSesionEmpleador frame = new VistaSesionEmpleador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaSesionEmpleador() {
		setTitle("Sesion Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 550, 353);
		contentPane.add(scrollPane);
		
		tickets = new DefaultListModel<>();
		this.listaTickets = new JList( tickets );
		scrollPane.setViewportView(listaTickets);
		listaTickets.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		btnAltaTicket = new JButton("Alta Ticket");
		btnAltaTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaTicket.setBounds(10, 11, 195, 45);
		contentPane.add(btnAltaTicket);
		
		btnBajaTicket = new JButton("Baja Ticket");
		btnBajaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaTicket.setBounds(586, 103, 125, 38);
		contentPane.add(btnBajaTicket);
		
		btnModificarTicket = new JButton("Modificar Ticket");
		btnModificarTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarTicket.setBounds(586, 166, 125, 38);
		contentPane.add(btnModificarTicket);
		
		btnListaDeAsignacion = new JButton("Lista de asignacion");
		btnListaDeAsignacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListaDeAsignacion.setBounds(586, 227, 157, 38);
		contentPane.add(btnListaDeAsignacion);
		
		btnRondaDeEleccion = new JButton("Ronda de Elecciones");
		btnRondaDeEleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRondaDeEleccion.setBounds(586, 288, 157, 38);
		contentPane.add(btnRondaDeEleccion);
		
		btnResultado = new JButton("Resultado");
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResultado.setBounds(586, 348, 112, 38);
		contentPane.add(btnResultado);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(10, 435, 125, 45);
		contentPane.add(btnCerrarSesion);
	}
	

	public JList getListaTickets() {
		return listaTickets;
	}
	
	public void setListaTickets(JList listaTickets) {
		this.listaTickets = listaTickets;
	}
	
	public DefaultListModel<TicketBusquedaDeEmpleado> getTickets() {
		return tickets;
	}

	public void setTickets(DefaultListModel<TicketBusquedaDeEmpleado> tickets) {
		this.tickets = tickets;
	}
	

	@Override
	public void mostrar() {
		this.setVisible(true);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAltaTicket.addActionListener(actionListener);
		this.btnListaDeAsignacion.addActionListener(actionListener);
		this.btnRondaDeEleccion.addActionListener(actionListener);
		this.btnResultado.addActionListener(actionListener);
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnBajaTicket.addActionListener(actionListener);
		this.btnModificarTicket.addActionListener(actionListener);
		this.listaTickets.addListSelectionListener((ListSelectionListener) actionListener);
	}
}
