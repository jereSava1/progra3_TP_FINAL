package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaSesionEmpleador extends JFrame implements IVistaIEmpleador{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSesionEmpleador frame = new VistaSesionEmpleador();
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
	public VistaSesionEmpleador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 550, 353);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Generar nuevo Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 195, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Baja Ticket");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(586, 103, 125, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar Ticket");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(586, 166, 125, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver Lista de asignacion");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(586, 227, 157, 38);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ronda de Elecciones");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(586, 288, 157, 38);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Resultado");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(586, 348, 112, 38);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Cerrar Sesion");
		btnNewButton_6.setBounds(10, 435, 125, 45);
		contentPane.add(btnNewButton_6);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void esconder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}
}
