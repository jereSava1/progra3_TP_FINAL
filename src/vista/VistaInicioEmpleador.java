package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VistaInicioEmpleador extends JFrame implements IVistaIEmpleador{

	private JPanel General;
	private JButton BotonTicket;
	private JButton BotonVerLista;
	private JButton BotonResultado;
	private JButton BotonRondadeEleccion;
	private JButton BotonCerrarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicioEmpleador frame = new VistaInicioEmpleador();
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
	public VistaInicioEmpleador() {
		setTitle("Sesion Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 464);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(new BorderLayout(0, 0));
		
		JPanel Central = new JPanel();
		General.add(Central, BorderLayout.CENTER);
		Central.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		Central.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Gestion del Ticket:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		Central.add(panel_2);
		
		BotonTicket = new JButton("Gestionar");
		BotonTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(BotonTicket);
		
		JPanel panel_3 = new JPanel();
		Central.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Empleados Pretensos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		Central.add(panel_4);
		
		BotonVerLista = new JButton("Ver Lista");
		BotonVerLista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(BotonVerLista);
		
		JPanel panel_5 = new JPanel();
		Central.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Ronda de Eleccion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		Central.add(panel_6);
		
		BotonRondadeEleccion = new JButton("Ingresar");
		BotonRondadeEleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(BotonRondadeEleccion);
		
		JPanel panel = new JPanel();
		Central.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Resultado");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		Central.add(panel_7);
		
		BotonResultado = new JButton("Ver Resultado");
		BotonResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(BotonResultado);
		
		JPanel Sur = new JPanel();
		General.add(Sur, BorderLayout.SOUTH);
		Sur.setLayout(new BorderLayout(0, 0));
		
		BotonCerrarSesion = new JButton("Cerrar Sesion");
		BotonCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sur.add(BotonCerrarSesion);
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
		this.BotonTicket.addActionListener(actionListener);
		this.BotonVerLista.addActionListener(actionListener);
		this.BotonRondadeEleccion.addActionListener(actionListener);
		this.BotonResultado.addActionListener(actionListener);
		this.BotonCerrarSesion.addActionListener(actionListener);
	}


}
