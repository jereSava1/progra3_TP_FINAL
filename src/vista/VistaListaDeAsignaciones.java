package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.UsuarioPuntuadoDTO;
import model.ticket.TicketBusquedaDeEmpleado;


//La utilizamos para ver los empleados pretensos de UN solo ticket
public class VistaListaDeAsignaciones extends JFrame implements IListaEmpleadosPretensos {

	private JPanel contentPane;
	private JButton btnVolver;
	private DefaultListModel<UsuarioPuntuadoDTO> listaAsignacion;
	private JList<UsuarioPuntuadoDTO> list;
	private JButton btnConfirmar;
	
	@Override
	public void setListaDeAsignacion(DefaultListModel<UsuarioPuntuadoDTO> lista) {
		this.listaAsignacion = lista;
	}

	@Override
	public List<UsuarioPuntuadoDTO> getSeleccion() {
		return list.getSelectedValuesList();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaListaDeAsignaciones frame = new VistaListaDeAsignaciones();
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
	public VistaListaDeAsignaciones() {
		
		//List<UsuarioPuntuado> listaEmpleados = ticket.getListaDeAsignaciones();
		
		setTitle("Lista de Empleados Pretensos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
		
		list = new JList();
		listaAsignacion = new DefaultListModel<UsuarioPuntuadoDTO>();
		list.setModel(listaAsignacion);
		list.setBounds(10, 10, 416, 211);
		list.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		btnConfirmar = new JButton("Confirmar elecci\u00F3n");
		btnConfirmar.setActionCommand("CONFIRMAR");
		btnConfirmar.setBounds(298, 228, 128, 21);
		contentPane.add(btnConfirmar);
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
		this.btnVolver.addActionListener(actionListener);
		
	}
	public void success(String title, String message){
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
