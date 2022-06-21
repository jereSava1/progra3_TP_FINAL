package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class ventanaRegistroAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaRegistroAdministrador frame = new ventanaRegistroAdministrador();
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
	public ventanaRegistroAdministrador() {
		setTitle("Registro Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_ID = new JPanel();
		panelCentral.add(panel_ID);
		FlowLayout fl_panel_ID = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_ID.setLayout(fl_panel_ID);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_ID.add(lblNewLabel);
		
		JPanel panel_fieldID = new JPanel();
		panelCentral.add(panel_fieldID);
		panel_fieldID.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_fieldID.add(textField);
		textField.setColumns(15);
		
		JPanel panel_Usuario = new JPanel();
		panelCentral.add(panel_Usuario);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Usuario.add(lblUsuario);
		
		JPanel panel_fieldUsuario = new JPanel();
		panelCentral.add(panel_fieldUsuario);
		
		textField_1 = new JTextField();
		textField_1.setColumns(15);
		panel_fieldUsuario.add(textField_1);
		
		JPanel panel_Contrasena = new JPanel();
		panelCentral.add(panel_Contrasena);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Contrasena.add(lblContrasea);
		
		JPanel panel_fieldContrasena = new JPanel();
		panelCentral.add(panel_fieldContrasena);
		
		textField_2 = new JTextField();
		textField_2.setColumns(15);
		panel_fieldContrasena.add(textField_2);
		
		JPanel panel_Contrasena_1 = new JPanel();
		panelCentral.add(panel_Contrasena_1);
		
		JLabel lblContrasea_1 = new JLabel("Email:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Contrasena_1.add(lblContrasea_1);
		
		JPanel panel_fieldContrasena_1 = new JPanel();
		panelCentral.add(panel_fieldContrasena_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(15);
		panel_fieldContrasena_1.add(textField_3);
		
		JPanel panel_Volver = new JPanel();
		panelCentral.add(panel_Volver);
		
		JButton btnNewButton_1 = new JButton("Volver\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Volver.add(btnNewButton_1);
		
		JPanel panel_RegisterButton = new JPanel();
		panelCentral.add(panel_RegisterButton);
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_RegisterButton.add(btnNewButton);
	}

}
