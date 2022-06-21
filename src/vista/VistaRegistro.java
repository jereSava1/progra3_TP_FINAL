package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import dto.RegistroRequest;
import types.TipoUsuario;

public class VistaRegistro extends JFrame implements IRegistro {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private ButtonGroup G;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistro frame = new VistaRegistro();
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
	public VistaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tipo de usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNorte.add(lblNewLabel);
		
		JRadioButton rdbtnEmpleado = new JRadioButton("Empleado");
		rdbtnEmpleado.setActionCommand("EMPLEADO");
		rdbtnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNorte.add(rdbtnEmpleado);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setActionCommand("ADMIN");
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNorte.add(rdbtnAdministrador);
		
		JRadioButton rdbtnEmpleador = new JRadioButton("Empleador");
		rdbtnEmpleador.setActionCommand("EMPLEADOR");
		rdbtnEmpleador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNorte.add(rdbtnEmpleador);
		
		G = new ButtonGroup();
		G.add(rdbtnEmpleador);
		G.add(rdbtnAdministrador);
		G.add(rdbtnEmpleado);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnVolver);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setActionCommand("REGISTRARSE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnNewButton);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelUsername = new JPanel();
		panelCentro.add(panelUsername);
		panelUsername.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario");
		panelUsername.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setToolTipText("username\r\n");
		textFieldUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		panelUsername.add(textFieldUsuario);
		textFieldUsuario.setColumns(20);
		
		JPanel panelContrasena = new JPanel();
		panelCentro.add(panelContrasena);
		panelContrasena.setLayout(new GridLayout(0, 2, 0, 5));
		
		JLabel Contrasena = new JLabel("Contrase\u00F1a");
		panelContrasena.add(Contrasena);
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldContrasena = new JTextField();
		panelContrasena.add(textFieldContrasena);
		textFieldContrasena.setColumns(20);
		

		
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
	public RegistroRequest getFormulario() {
		RegistroRequest req = new RegistroRequest();
		req.setNombreUsuario(this.textFieldUsuario.getText());
		req.setContrasena(this.textFieldContrasena.getText());
		req.setTipo(TipoUsuario.valueOf(G.getSelection().getActionCommand()));
		return req;
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

}
