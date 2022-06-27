package vista;

import dto.TicketSimplificadoDTO;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.FlowLayout;

public class VistaListaTicketSimplificado extends JFrame implements KeyListener, IListaTicketSimplificado {
	private JButton btnVolver;
	private DefaultListModel<TicketSimplificadoDTO> modelLista;
	private JList<TicketSimplificadoDTO> list;

	public VistaListaTicketSimplificado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 467);

		modelLista = new DefaultListModel<>();
		getContentPane().setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 409, 61, 21);
		btnVolver.setActionCommand("VOLVER");
		getContentPane().add(btnVolver);
		
		list = new JList<TicketSimplificadoDTO>();
		list.setModel(modelLista);
		list.setBounds(10, 10, 408, 389);
		getContentPane().add(list);
		
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
		// TODO Auto-generated method stub

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
		this.btnVolver.addActionListener(actionListener);
	}

	@Override
	public void setModel(DefaultListModel<TicketSimplificadoDTO> model) {
		this.modelLista = model;
		this.list.setModel(modelLista);
	}
}
