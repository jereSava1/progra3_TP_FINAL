package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.RegistroRequest;
import dto.RegistroRequestAdmin;
import types.TipoUsuario;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class VistaRegistroAdministrador extends JFrame implements IRegistroAdmin {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;
	private JButton btnVolver;
	private JButton btnRegistro;
	protected ActionListener actionListener;
	private String contrasena;
	private String ID;
	private String email;
	private String usuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistroAdministrador frame = new VistaRegistroAdministrador();
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
	public VistaRegistroAdministrador() {
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
		
		textFieldID = new JTextField();
		panel_fieldID.add(textFieldID);
		textFieldID.setColumns(15);
		
		JPanel panel_Usuario = new JPanel();
		panelCentral.add(panel_Usuario);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Usuario.add(lblUsuario);
		
		JPanel panel_fieldUsuario = new JPanel();
		panelCentral.add(panel_fieldUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(15);
		panel_fieldUsuario.add(textFieldUsuario);
		
		JPanel panel_Contrasena = new JPanel();
		panelCentral.add(panel_Contrasena);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Contrasena.add(lblContrasea);
		
		JPanel panel_fieldContrasena = new JPanel();
		panelCentral.add(panel_fieldContrasena);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setColumns(15);
		panel_fieldContrasena.add(textFieldContrasena);
		
		JPanel panel_Contrasena_1 = new JPanel();
		panelCentral.add(panel_Contrasena_1);
		
		JLabel lblContrasea_1 = new JLabel("Email:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Contrasena_1.add(lblContrasea_1);
		
		JPanel panel_fieldContrasena_1 = new JPanel();
		panelCentral.add(panel_fieldContrasena_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(15);
		panel_fieldContrasena_1.add(textFieldEmail);
		
		JPanel panel_Volver = new JPanel();
		panelCentral.add(panel_Volver);
		
		btnVolver = new JButton("Volver\r\n");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_Volver.add(btnVolver);
		
		JPanel panel_RegisterButton = new JPanel();
		panelCentral.add(panel_RegisterButton);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_RegisterButton.add(btnRegistro);
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
		this.btnRegistro.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener=actionListener;
		
		
	}

	public void keyReleased(KeyEvent e) {
		this.usuario = this.textFieldUsuario.getText();
		this.email=this.textFieldEmail.getText();
		this.ID= this.textFieldID.getText();
		this.contrasena =this.textFieldContrasena.getText();
	}
	
	
	@Override
	public RegistroRequestAdmin getFormulario() {
		RegistroRequestAdmin req = new RegistroRequestAdmin(this.usuario,this.contrasena,this.email,this.ID);
		req.setNombreUsuario(this.textFieldUsuario.getText());
		req.setContrasena(this.textFieldContrasena.getText());
		return req;
	}

	
}
