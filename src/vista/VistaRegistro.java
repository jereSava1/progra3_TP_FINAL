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
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class VistaRegistro extends JFrame implements IRegistro {

	private JPanel contentPane;
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
		setTitle("Tipo de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panelCentral.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnEmpleador = new JRadioButton("Empleador");
		rdbtnEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(rdbtnEmpleador);
		rdbtnEmpleador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnEmpleador.setActionCommand("EMPLEADOR");
		
		JPanel panel_1 = new JPanel();
		panelCentral.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_9375483177500");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(rdbtnAdministrador);
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdministrador.setActionCommand("ADMIN");
		
		JPanel panel_2 = new JPanel();
		panelCentral.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnEmpleado = new JRadioButton("Empleado");
		rdbtnEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(rdbtnEmpleado);
		rdbtnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnEmpleado.setActionCommand("EMPLEADO");
		
		G = new ButtonGroup();
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnVolver);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setActionCommand("REGISTRARSE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Seleccione tipo de usuario con el que desea registrarse:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(lblNewLabel);
		

		
	}

	@Override
	public void mostrar() {
		this.setVisible(true);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

/*	@Override
	public RegistroRequest getFormulario() {
		RegistroRequest req = new RegistroRequest();
		req.setNombreUsuario(this.textFieldUsuario.getText());
		req.setContrasena(this.textFieldContrasena.getText());
		req.setTipo(TipoUsuario.valueOf(G.getSelection().getActionCommand()));
		return req;
	}
*/
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

}
