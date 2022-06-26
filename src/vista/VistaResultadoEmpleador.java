package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class VistaResultadoEmpleador extends JFrame implements IVistaResultadoEmpleador {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private JTextArea textAreaEmpleadosSolicitados;
	private JTextArea textAreaEmpleadosObtenidos;
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaResultadoEmpleador frame = new VistaResultadoEmpleador();
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
	public VistaResultadoEmpleador() {
		setTitle("Resultado Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empleados contratados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 171, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 233, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nombre de Empleado");
		table.setModel(model);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(10, 249, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_1 = new JLabel("Empleados Solicitados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(253, 67, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		textAreaEmpleadosSolicitados = new JTextArea();
		textAreaEmpleadosSolicitados.setEnabled(false);
		textAreaEmpleadosSolicitados.setBounds(253, 92, 104, 23);
		contentPane.add(textAreaEmpleadosSolicitados);
		
		JLabel lblNewLabel_1_1 = new JLabel("Empleados Obtenidos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(253, 139, 152, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textAreaEmpleadosObtenidos = new JTextArea();
		textAreaEmpleadosObtenidos.setEnabled(false);
		textAreaEmpleadosObtenidos.setBounds(253, 164, 104, 23);
		contentPane.add(textAreaEmpleadosObtenidos);
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

	@Override
	public void setModel(DefaultTableModel model) {
		this.model = model;
		
	}

	@Override
	public DefaultTableModel getModel() {
		return this.model;
	}

	@Override
	public void setTextAreaEmpleadosSolicitados(String solicitados) {
		this.textAreaEmpleadosSolicitados.setText(solicitados);
		
	}

	@Override
	public void setTextAreaEmpleadosObtenidos(String obtenidos) {
		this.textAreaEmpleadosObtenidos.setText(obtenidos);
	}
	
	
	
	
	
}


