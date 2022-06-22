package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VistaAltaTicket extends JFrame {

	private JPanel General;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaTicket frame = new VistaAltaTicket();
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
	public VistaAltaTicket() {
		setTitle("Alta de su Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		General.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Locacion pretendida:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JRadioButton rdbtnHomeOffice = new JRadioButton("Home Office");
		rdbtnHomeOffice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnHomeOffice);
		
		JRadioButton rdbtnPresencial = new JRadioButton("Presencial");
		rdbtnPresencial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnPresencial);
		
		JRadioButton rdbtnIndistinto = new JRadioButton("Indistinto");
		rdbtnIndistinto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnIndistinto);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Remuneracion pretendida:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JRadioButton rdbtnHastav1 = new JRadioButton("Hasta");
		rdbtnHastav1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnHastav1);
		
		JRadioButton rdbtnEntreV1yV2 = new JRadioButton("Entre");
		rdbtnEntreV1yV2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnEntreV1yV2);
		
		JRadioButton rdbtnMasDeV2 = new JRadioButton("Mas de");
		rdbtnMasDeV2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnMasDeV2);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Carga Horario pretendida:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JRadioButton rdbtnMedia = new JRadioButton("Media");
		rdbtnMedia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(rdbtnMedia);
		
		JRadioButton rdbtnCompleta = new JRadioButton("Completa");
		rdbtnCompleta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(rdbtnCompleta);
		
		JRadioButton rdbtnExtendida = new JRadioButton("Extendida");
		rdbtnExtendida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(rdbtnExtendida);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Puesto pretendido:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JRadioButton rdbtnJunior = new JRadioButton("Junior");
		rdbtnJunior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(rdbtnJunior);
		
		JRadioButton rdbtnSenior = new JRadioButton("Senior");
		rdbtnSenior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(rdbtnSenior);
		
		JRadioButton rdbtnManagment = new JRadioButton("Managment");
		rdbtnManagment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(rdbtnManagment);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JLabel lblNewLabel_4 = new JLabel("Rango Etario:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_9.add(lblNewLabel_4);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JRadioButton rdbtnMenos40 = new JRadioButton("Menos de 40");
		rdbtnMenos40.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(rdbtnMenos40);
		
		JRadioButton rdbtn4050 = new JRadioButton("De 40 a 50");
		rdbtn4050.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(rdbtn4050);
		
		JRadioButton rdbtnMas50 = new JRadioButton("Mas de 50");
		rdbtnMas50.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(rdbtnMas50);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JLabel lblNewLabel_5 = new JLabel("Experiencia Previa:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_11.add(lblNewLabel_5);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JRadioButton rdbtnNada = new JRadioButton("Nada");
		rdbtnNada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_12.add(rdbtnNada);
		
		JRadioButton rdbtnMediaExp = new JRadioButton("Media");
		rdbtnMediaExp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_12.add(rdbtnMediaExp);
		
		JRadioButton rdbtnMucha = new JRadioButton("Mucha");
		rdbtnMucha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_12.add(rdbtnMucha);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JLabel lblNewLabel_6 = new JLabel("Estudios Cursados:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_13.add(lblNewLabel_6);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JRadioButton rdbtnPrimario = new JRadioButton("Primario");
		rdbtnPrimario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_14.add(rdbtnPrimario);
		
		JRadioButton rdbtnSecundario = new JRadioButton("Secundario");
		rdbtnSecundario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_14.add(rdbtnSecundario);
		
		JRadioButton rdbtnTerciario = new JRadioButton("Terciario");
		rdbtnTerciario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_14.add(rdbtnTerciario);
		
		JPanel panel_15 = new JPanel();
		General.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnFinalizar);
	}

}
