package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VistaSesionAdmin extends JFrame implements IVistaSesionAdmin,KeyListener{

	private JPanel contentPane;
	private JTextField textFieldSueldoMinimo;
	private JTextField textFieldSueldoMaximo;
	private JButton btnVerEmpleadores;
	private JButton btnVerEmpleados;
	private JButton btnVerComisiones;
	private JButton btnActivarEncuentros;
	private JButton btnActivarContratacion;
	private JButton btnCerrarSesion;
	private float maximo,minimo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSesionAdmin frame = new VistaSesionAdmin();
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
	public VistaSesionAdmin() {
		setTitle("Sesion Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblListaEmpleadores = new JLabel("Ver Lista de Empleadores");
		lblListaEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblListaEmpleadores);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnVerEmpleadores = new JButton("Ver Empleadores");
		btnVerEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnVerEmpleadores);
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JLabel lblMuestraListaDe = new JLabel("Ver Lista de Empleados");
		lblMuestraListaDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_1.add(lblMuestraListaDe);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		
		btnVerEmpleados = new JButton("Ver Empleados");
		btnVerEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(btnVerEmpleados);
		
		JPanel panel_1_2 = new JPanel();
		panel.add(panel_1_2);
		
		JLabel lblVerComisionesObtenidas = new JLabel("Ver Comisiones Obtenidas");
		lblVerComisionesObtenidas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_2.add(lblVerComisionesObtenidas);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		
		btnVerComisiones = new JButton("Ver Comisones");
		btnVerComisiones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2.add(btnVerComisiones);
		
		JPanel panel_1_2_1 = new JPanel();
		panel.add(panel_1_2_1);
		
		JLabel lblIngresaSueldoMinimo = new JLabel("Ingresa Sueldo Minimo");
		lblIngresaSueldoMinimo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_2_1.add(lblIngresaSueldoMinimo);
		
		JPanel panel_2_2_1 = new JPanel();
		panel.add(panel_2_2_1);
		
		textFieldSueldoMinimo = new JTextField();
		panel_2_2_1.add(textFieldSueldoMinimo);
		textFieldSueldoMinimo.setColumns(10);
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel.add(panel_1_2_1_1);
		
		JLabel lblIngresaSueldoMaximo = new JLabel("Ingresa Sueldo Maximo");
		lblIngresaSueldoMaximo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_2_1_1.add(lblIngresaSueldoMaximo);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel.add(panel_2_2_1_1);
		
		textFieldSueldoMaximo = new JTextField();
		textFieldSueldoMaximo.setColumns(10);
		panel_2_2_1_1.add(textFieldSueldoMaximo);
		
		JPanel panel_1_2_2 = new JPanel();
		panel.add(panel_1_2_2);
		
		JLabel lblActivaRondaDe = new JLabel("Activa Ronda De Encuentros");
		lblActivaRondaDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_2_2.add(lblActivaRondaDe);
		
		JPanel panel_2_2_2 = new JPanel();
		panel.add(panel_2_2_2);
		
		btnActivarEncuentros = new JButton("Activar Encuentros");
		btnActivarEncuentros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2_2.add(btnActivarEncuentros);
		
		JPanel panel_1_2_2_1 = new JPanel();
		panel.add(panel_1_2_2_1);
		
		JLabel lblActivaRondaDe_1 = new JLabel("Activa Ronda De Contratacion");
		lblActivaRondaDe_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1_2_2_1.add(lblActivaRondaDe_1);
		
		JPanel panel_2_2_2_1 = new JPanel();
		panel.add(panel_2_2_2_1);
		
		btnActivarContratacion = new JButton("Activar Contrataciones");
		btnActivarContratacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2_2_1.add(btnActivarContratacion);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(btnCerrarSesion);
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	@Override
	public void esconder() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
		this.btnActivarContratacion.addActionListener(actionListener);
		this.btnActivarEncuentros.addActionListener(actionListener);
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnVerComisiones.addActionListener(actionListener);
		this.btnVerEmpleadores.addActionListener(actionListener);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		try {
		  maximo = Float.parseFloat(this.textFieldSueldoMaximo.getText());
		  minimo = Float.parseFloat(this.textFieldSueldoMinimo.getText());
		}
		catch(Exception exception){
			
		}
		
	}

	@Override
	public float getMaximo() {
		// TODO Auto-generated method stub
		return this.maximo;
	}

	@Override
	public float getMinimo() {
		// TODO Auto-generated method stub
		return this.minimo;
	}

	@Override
	public void limpiaCampos() {
		// TODO Auto-generated method stub
		this.textFieldSueldoMaximo.setText("");
		this.textFieldSueldoMinimo.setText("");
	}
	

}