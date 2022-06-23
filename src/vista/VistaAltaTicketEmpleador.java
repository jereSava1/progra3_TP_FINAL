package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VistaAltaTicketEmpleador extends JFrame implements IVistaAltaTicketEmpleador,MouseListener,KeyListener{

	private JPanel General;
	private ActionListener actionListener;
	private ButtonGroup GrupoLocacion;
	private ButtonGroup GrupoRemuneracion;
	private ButtonGroup GrupoHorario;
	private ButtonGroup GrupoPuesto;
	private ButtonGroup GrupoREtario;
	private ButtonGroup GrupoExperiencia;
	private ButtonGroup GrupoEstudios;
	private JButton btnVolver;
	private JButton btnFinalizar;
	private String Locacion;
	private String Remuneracion;
	private String Puesto;
	private String REtario;
	private String Experiencia;
	private String Estudios;
	private String Horario;
	private JTextField textFieldCantEmpleados;
	private float cantEmpleados=-1;
	int complete=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaTicketEmpleado frame = new VistaAltaTicketEmpleado();
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
	public VistaAltaTicketEmpleador() {
		
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
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
		
		JLabel lblNewLabel_7 = new JLabel("Cantidad de empleados requeridos:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_16.add(lblNewLabel_7);
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		
		textFieldCantEmpleados = new JTextField();
		panel_17.add(textFieldCantEmpleados);
		textFieldCantEmpleados.setColumns(10);
		textFieldCantEmpleados.addKeyListener(this);
		
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
		
		GrupoLocacion = new ButtonGroup();
		GrupoLocacion.add(rdbtnIndistinto);
		GrupoLocacion.add(rdbtnPresencial);
		GrupoLocacion.add(rdbtnHomeOffice);
		rdbtnIndistinto.addMouseListener(this);
		rdbtnPresencial.addMouseListener(this);
		rdbtnHomeOffice.addMouseListener(this);
		
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
		
		GrupoRemuneracion = new ButtonGroup();
		GrupoRemuneracion.add(rdbtnMasDeV2);
		GrupoRemuneracion.add(rdbtnEntreV1yV2);
		GrupoRemuneracion.add(rdbtnHastav1);
		rdbtnMasDeV2.addMouseListener(this);
		rdbtnEntreV1yV2.addMouseListener(this);
		rdbtnHastav1.addMouseListener(this);
		
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
		
		GrupoHorario = new ButtonGroup();
		GrupoHorario.add(rdbtnExtendida);
		GrupoHorario.add(rdbtnCompleta);
		GrupoHorario.add(rdbtnMedia);
		rdbtnExtendida.addMouseListener(this);
		rdbtnCompleta.addMouseListener(this);
		rdbtnMedia.addMouseListener(this);
		
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
		
		GrupoPuesto = new ButtonGroup();
		GrupoPuesto.add(rdbtnManagment);
		GrupoPuesto.add(rdbtnSenior);
		GrupoPuesto.add(rdbtnJunior);
		rdbtnManagment.addMouseListener(this);
		rdbtnSenior.addMouseListener(this);
		rdbtnJunior.addMouseListener(this);
		
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
		
		GrupoREtario = new ButtonGroup();
		GrupoREtario.add(rdbtnMas50);
		GrupoREtario.add(rdbtn4050);
		GrupoREtario.add(rdbtnMenos40);
		rdbtnMas50.addMouseListener(this);
		rdbtn4050.addMouseListener(this);
		rdbtnMenos40.addMouseListener(this);
		
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
		
		GrupoExperiencia = new ButtonGroup();
		GrupoExperiencia.add(rdbtnMucha);
		GrupoExperiencia.add(rdbtnMediaExp);
		GrupoExperiencia.add(rdbtnNada);
		rdbtnMucha.addMouseListener(this);
		rdbtnMediaExp.addMouseListener(this);
		rdbtnNada.addMouseListener(this);
		
		
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
		
		GrupoEstudios = new ButtonGroup();
		GrupoEstudios.add(rdbtnTerciario);
		GrupoEstudios.add(rdbtnSecundario);
		GrupoEstudios.add(rdbtnPrimario);
		rdbtnTerciario.addMouseListener(this);
		rdbtnSecundario.addMouseListener(this);
		rdbtnPrimario.addMouseListener(this);
		
		JPanel panel_15 = new JPanel();
		General.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnFinalizar);
		btnFinalizar.setEnabled(false);
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
        this.btnVolver.addActionListener(actionListener);
        this.btnFinalizar.addActionListener(actionListener);
        this.actionListener = actionListener;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(this.GrupoEstudios.getSelection()!=null)
			this.Estudios = this.GrupoEstudios.getSelection().getActionCommand();
		if(this.GrupoRemuneracion.getSelection()!=null)
			this.Remuneracion = this.GrupoRemuneracion.getSelection().getActionCommand();
		if(this.GrupoHorario.getSelection()!=null)
			this.Horario = this.GrupoHorario.getSelection().getActionCommand();
		if(this.GrupoPuesto.getSelection()!=null)
			this.Puesto = this.GrupoPuesto.getSelection().getActionCommand();
		if(this.GrupoREtario.getSelection()!=null)
			this.REtario = this.GrupoREtario.getSelection().getActionCommand();
		if(this.GrupoExperiencia.getSelection()!=null)
			this.Experiencia = this.GrupoExperiencia.getSelection().getActionCommand();
		if(this.GrupoLocacion.getSelection()!=null)
			this.Locacion = this.GrupoLocacion.getSelection().getActionCommand();
		if(this.GrupoEstudios.getSelection()!=null && this.GrupoRemuneracion.getSelection()!=null && this.GrupoHorario.getSelection()!=null
				&& this.GrupoPuesto.getSelection()!=null && this.GrupoREtario.getSelection()!=null  && this.GrupoExperiencia.getSelection()!=null
				&& this.GrupoLocacion.getSelection()!=null && complete==1) 
			this.btnFinalizar.setEnabled(true);
		else if(complete==0)
			complete=1;
			
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiaCampos() {
		// TODO Auto-generated method stub
		this.GrupoEstudios.clearSelection();
		this.GrupoExperiencia.clearSelection();
		this.GrupoHorario.clearSelection();
		this.GrupoLocacion.clearSelection();
		this.GrupoPuesto.clearSelection();
		this.GrupoRemuneracion.clearSelection();
		this.GrupoREtario.clearSelection();
		this.textFieldCantEmpleados.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		try{
		 this.cantEmpleados = Float.parseFloat(textFieldCantEmpleados.getText());
		}
		catch(Exception exception){	}
		if(this.cantEmpleados!=-1 && complete==1)
			this.btnFinalizar.setEnabled(true);
		else if(complete==0)
			complete=1;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

