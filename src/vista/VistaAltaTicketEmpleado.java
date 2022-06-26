package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VistaAltaTicketEmpleado extends JFrame implements IVistaAltaTicketEmpleado, MouseListener{

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
	private JTextField pesoLocacion;
	private JTextField pesoRemuneracion;
	private JTextField pesocargaHoraria;
	private JTextField pesoTipoDePuesto;
	private JTextField pesoRangoEtario;
	private JTextField pesoExperiencia;
	private JTextField pesoEstudios;
	private JRadioButton rdbtnHastav1;
	private JRadioButton rdbtnEntreV1yV2;
	private JRadioButton rdbtnMasDeV2;
	private float v1;
	private float v2;
	
	public float getV1() {
        return v1;
    }

    public void setV1(Float v1) {
        this.v1 = v1;
        rdbtnHastav1.setText("Hasta "+v1);
        rdbtnEntreV1yV2.setText("Entre "+v1+" y "+this.v2);
    }

    public float getV2() {
        return v2;
    }

    public void setV2(Float v2) {
        this.v2 = v2;
        rdbtnEntreV1yV2.setText("Entre "+this.v1+" y "+v2);
        rdbtnMasDeV2.setText("Mas de "+v2);
    }

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
	public VistaAltaTicketEmpleado() {
		setTitle("Alta de su Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 665);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 428, 587);
		General.add(panel);
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
		
		rdbtnHastav1 = new JRadioButton("Hasta");
		rdbtnHastav1.setActionCommand("MENOS_V1");
		rdbtnHastav1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnHastav1);
		
		rdbtnEntreV1yV2 = new JRadioButton("Entre");
		rdbtnEntreV1yV2.setActionCommand("ENTRE_V1_Y_V2");
		rdbtnEntreV1yV2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnEntreV1yV2);
		
		rdbtnMasDeV2 = new JRadioButton("Mas de");
		rdbtnMasDeV2.setActionCommand("MAS_DE_V2");
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
		panel_15.setBounds(5, 592, 620, 29);
		General.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnVolver);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.add(btnFinalizar);
		btnFinalizar.setEnabled(false);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(433, 5, 192, 587);
		General.add(panel_16);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_17_1 = new JPanel();
		panel_16.add(panel_17_1);
		panel_17_1.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel("Importancia");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setBounds(24, 0, 142, 20);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel_17_1.add(lblNewLabel_7_1);
		
		pesoLocacion = new JTextField();
		pesoLocacion.setBounds(53, 36, 86, 20);
		panel_17_1.add(pesoLocacion);
		pesoLocacion.setColumns(10);
		
		JPanel panel_17_2 = new JPanel();
		panel_16.add(panel_17_2);
		panel_17_2.setLayout(null);
		
		pesoRemuneracion = new JTextField();
		pesoRemuneracion.setBounds(54, 28, 86, 20);
		panel_17_2.add(pesoRemuneracion);
		pesoRemuneracion.setColumns(10);
		
		JPanel panel_17_3 = new JPanel();
		panel_16.add(panel_17_3);
		panel_17_3.setLayout(null);
		
		pesocargaHoraria = new JTextField();
		pesocargaHoraria.setBounds(55, 29, 86, 20);
		panel_17_3.add(pesocargaHoraria);
		pesocargaHoraria.setColumns(10);
		
		JPanel panel_17_4 = new JPanel();
		panel_16.add(panel_17_4);
		panel_17_4.setLayout(null);
		
		pesoTipoDePuesto = new JTextField();
		pesoTipoDePuesto.setBounds(56, 26, 86, 20);
		panel_17_4.add(pesoTipoDePuesto);
		pesoTipoDePuesto.setColumns(10);
		
		JPanel panel_17_5 = new JPanel();
		panel_16.add(panel_17_5);
		panel_17_5.setLayout(null);
		
		pesoRangoEtario = new JTextField();
		pesoRangoEtario.setBounds(57, 27, 86, 20);
		panel_17_5.add(pesoRangoEtario);
		pesoRangoEtario.setColumns(10);
		
		JPanel panel_17_6 = new JPanel();
		panel_16.add(panel_17_6);
		panel_17_6.setLayout(null);
		
		pesoExperiencia = new JTextField();
		pesoExperiencia.setBounds(59, 26, 86, 20);
		panel_17_6.add(pesoExperiencia);
		pesoExperiencia.setColumns(10);
		
		JPanel panel_17_1_1 = new JPanel();
		panel_16.add(panel_17_1_1);
		panel_17_1_1.setLayout(null);
		
		pesoEstudios = new JTextField();
		pesoEstudios.setBounds(59, 30, 86, 20);
		panel_17_1_1.add(pesoEstudios);
		pesoEstudios.setColumns(10);
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
				&& this.GrupoLocacion.getSelection()!=null)
			this.btnFinalizar.setEnabled(true);
			
		
		
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
		this.GrupoEstudios.clearSelection();
		this.GrupoExperiencia.clearSelection();
		this.GrupoHorario.clearSelection();
		this.GrupoLocacion.clearSelection();
		this.GrupoPuesto.clearSelection();
		this.GrupoRemuneracion.clearSelection();
		this.GrupoREtario.clearSelection();
		
		this.pesocargaHoraria.setText("");
		this.pesoEstudios.setText("");
		this.pesoExperiencia.setText("");
		this.pesoLocacion.setText("");
		this.pesoRangoEtario.setText("");
		this.pesoRemuneracion.setText("");
		this.pesoTipoDePuesto.setText("");
	}

	@Override
	public TicketDeEmpleadoRequest getFormulario() throws ConstructorInvalidoException{
		
		TicketDeEmpleadoRequest ticketDeEmpleadoRequest;
		ticketDeEmpleadoRequest = new TicketDeEmpleadoRequest(this.Locacion, this.pesoLocacion.getText(), 
																					  this.Estudios, this.pesoEstudios.getText(),
																					  this.Experiencia, this.pesoExperiencia.getText(), 
																					  this.Horario,this.pesocargaHoraria.getText(), 
																					  this.REtario, this.pesoRangoEtario.getText(),
																					  this.Remuneracion, this.pesoRemuneracion.getText(), 
																					  this.Puesto, this.pesoTipoDePuesto.getText());
		
		return ticketDeEmpleadoRequest;
		
	}
}
