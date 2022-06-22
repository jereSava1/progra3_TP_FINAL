package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class VistaSesionEmpleado extends JFrame implements IVistaIEmpleado{

	private JPanel contentPane;
	private JButton btnGestionTicket;
	private JButton btnListaEmpleadores;
	private JButton btnRondaEleccion;
	private JButton btnResultado;
	private JButton btnCerrarSesion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSesionEmpleado frame = new VistaSesionEmpleado();
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
	public VistaSesionEmpleado() {
		setTitle("Sesion Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Gestion del ticket: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGestionTicket = new JButton("Ingresar");
		btnGestionTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnGestionTicket);
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JLabel lblListaDeEmpleadores = new JLabel("Lista de empleadores: ");
		lblListaDeEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_1.add(lblListaDeEmpleadores);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		
		btnListaEmpleadores = new JButton("Ver\r\n");
		btnListaEmpleadores.setVerticalAlignment(SwingConstants.BOTTOM);
		btnListaEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListaEmpleadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2_1.add(btnListaEmpleadores);
		
		JPanel panel_1_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1_2.getLayout();
		panel.add(panel_1_2);
		
		JLabel lblRondaDeEleccion = new JLabel("Ronda de eleccion");
		lblRondaDeEleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_2.add(lblRondaDeEleccion);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		
		btnRondaEleccion = new JButton("Ingresar");
		btnRondaEleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2.add(btnRondaEleccion);
		
		JPanel panel_1_3 = new JPanel();
		panel.add(panel_1_3);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_3.add(lblResultado);
		
		JPanel panel_2_3 = new JPanel();
		panel.add(panel_2_3);
		
		btnResultado = new JButton("Ver");
		btnResultado.setVerticalAlignment(SwingConstants.BOTTOM);
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_3.add(btnResultado);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnCerrarSesion = new JButton("Cerrar sesion");
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
		
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnGestionTicket.addActionListener(actionListener);
		this.btnListaEmpleadores.addActionListener(actionListener);
		this.btnResultado.addActionListener(actionListener);
		this.btnListaEmpleadores.addActionListener(actionListener);	
	}

}
