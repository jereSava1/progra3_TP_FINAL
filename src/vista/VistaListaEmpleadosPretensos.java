package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.usuario.UsuarioPuntuado;
import negocio.RondaDeEncuentro;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;


//La utilizamos para ver los empleados pretensos de UN solo ticket
public class VistaListaEmpleadosPretensos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TicketBusquedaDeEmpleado ticket;
	
	DefaultTableModel model = new DefaultTableModel();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaListaEmpleadosPretensos frame = new VistaListaEmpleadosPretensos();
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
	public VistaListaEmpleadosPretensos() {
		
		List<UsuarioPuntuado> listaEmpleados = ticket.getListaDeAsignaciones();
		
		setTitle("Lista de Empleados Pretensos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Empleado Pretenso");
		model.addColumn("Fecha de Alta");
		model.addColumn("Puntaje obtenido");
		table.setModel(model);
		
		model.setRowCount(0);
		for (UsuarioPuntuado usuarioPuntuado : listaEmpleados) {
			Object[] fila = {
				usuarioPuntuado.getFechaDeGeneracion(),
				usuarioPuntuado.getUsuario(),
				usuarioPuntuado.getPuntaje()		
			};
			model.addRow(fila);	
		}
		
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
