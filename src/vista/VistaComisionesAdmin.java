package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;

public class VistaComisionesAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaComisionesAdmin frame = new VistaComisionesAdmin();
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
	public VistaComisionesAdmin() {
		setTitle("Comisiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nombre");
		model.addColumn("Tipo de usuario");
		model.addColumn("Comision");
		
		JLabel lblNewLabel = new JLabel("Comision total");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(322, 196, 102, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_1.setBounds(322, 221, 102, 22);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 212, 89, 31);
		contentPane.add(btnNewButton);
	}
}
