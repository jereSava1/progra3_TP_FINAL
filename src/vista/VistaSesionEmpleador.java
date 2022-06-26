package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import dto.TicketEmpleadorDTO;
import model.ticket.TicketBusquedaDeEmpleado;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JButton btnGenerarTicketSimplificado;
	
	private DefaultListModel<TicketEmpleadorDTO> tickets;
	private JList<TicketEmpleadorDTO> listaTickets;

	public void addTicket(TicketEmpleadorDTO ticket) {
		tickets.addElement(ticket);
		this.listaTickets.setModel(tickets);
	}
	
	public void removeTicket(TicketEmpleadorDTO ticket) {
		tickets.removeElement(ticket);
		this.listaTickets.setModel(tickets);
	}

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
		
		this.listaTickets = new JList();
		tickets = new DefaultListModel<>();
		this.listaTickets.setModel(tickets);
		scrollPane.setViewportView(listaTickets);
		listaTickets.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		btnAltaTicket = new JButton("Alta Ticket");
		btnAltaTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaTicket.setBounds(65, 18, 195, 33);
		contentPane.add(btnAltaTicket);
		
		btnBajaTicket = new JButton("Baja Ticket");
		btnBajaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaTicket.setBounds(586, 81, 169, 38);
		contentPane.add(btnBajaTicket);
		
		btnModificarTicket = new JButton("Modificar Ticket");
		btnModificarTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarTicket.setBounds(586, 140, 169, 38);
		contentPane.add(btnModificarTicket);
		
		btnListaDeAsignacion = new JButton("Lista de asignacion");
		btnListaDeAsignacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListaDeAsignacion.setBounds(586, 207, 169, 38);
		contentPane.add(btnListaDeAsignacion);
		
		btnRondaDeEleccion = new JButton("Ronda de Elecciones");
		btnRondaDeEleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRondaDeEleccion.setBounds(586, 271, 169, 38);
		contentPane.add(btnRondaDeEleccion);
		
		btnResultado = new JButton("Resultado");
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResultado.setBounds(586, 330, 169, 38);
		contentPane.add(btnResultado);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrarSesion.setBounds(10, 435, 125, 45);
		contentPane.add(btnCerrarSesion);
		
		btnGenerarTicketSimplificado = new JButton("Generar Ticket Simplificado");
		btnGenerarTicketSimplificado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarTicketSimplificado.setBounds(313, 18, 206, 38);
		contentPane.add(btnGenerarTicketSimplificado);
		
		JButton btnVerTicketsSimplificados = new JButton("Ver Tickets Simplificados");
		btnVerTicketsSimplificados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerTicketsSimplificados.setBounds(576, 18, 179, 38);
		contentPane.add(btnVerTicketsSimplificados);
	}
	

	public JList getListaTickets() {
		return listaTickets;
	}
	
	public void setListaTickets(JList listaTickets) {
		this.listaTickets = listaTickets;
	}
	
	public DefaultListModel<TicketEmpleadorDTO> getTickets() {
		return tickets;
	}

	public void setTickets(DefaultListModel<TicketEmpleadorDTO> tickets) {
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
		//this.listaTickets.addListSelectionListener((ListSelectionListener) actionListener);
		this.btnGenerarTicketSimplificado.addActionListener(actionListener);
		//this.listaTickets.addListSelectionListener((ListSelectionListener) actionListener);
	}

	@Override
	public void setModel(DefaultListModel<TicketEmpleadorDTO> model) {
		this.listaTickets.setModel(model);
	}	
		
	
}
