package de.i3a.combobox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ComboBox_anonym<E> extends JFrame {

	private static final long serialVersionUID = 1L;

	private Container c;
	private JButton jbtnRot, jbtnGelb, jbtnBlau;
	private JRadioButton jradioRot, jradioGelb, jradioBlau;
	private JPanel jpNorth, jpWest, jpCenter, jpSouth;
	private JComboBox<String> jcomboBox;

	public ComboBox_anonym() {
		this.setTitle("ComboBox");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initComponents();
		initEvents();

		this.setVisible(true);
	}

	private void initEvents() {
		// MeinActionListener mal = new MeinActionListener();
		// jbtnRot.addActionListener(mal);
		// jbtnGelb.addActionListener(mal);
		// jbtnBlau.addActionListener(mal);
		// jradioRot.addActionListener(mal);
		// jradioGelb.addActionListener(mal);
		// jradioBlau.addActionListener(mal);
		// jcomboBox.addActionListener(mal);
		jbtnRot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rotGewaehlt();
			}
		});

		jradioRot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rotGewaehlt();
			}
		});

		jcomboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) jcomboBox.getSelectedItem();
				switch (item) {
				case "Rot":
					rotGewaehlt();
					break;
				case "Gelb":
					gelbGewaehlt();
					break;
				case "Blau":
					blauGewaehlt();
					break;
				}
			}
		});


	}

	private void rotGewaehlt() {
		jradioRot.setSelected(true);
		jpCenter.setBackground(Color.RED);
		jcomboBox.setSelectedItem("Rot");
	}

	private void gelbGewaehlt(){
		jradioGelb.setSelected(true);
		jpCenter.setBackground(Color.YELLOW);
		jcomboBox.setSelectedItem("Gelb");
	}
	
	private void blauGewaehlt(){
		jradioBlau.setSelected(true);
		jpCenter.setBackground(Color.BLUE);
		jcomboBox.setSelectedItem("Blau");
	}
	
	private void initComponents() {
		c = this.getContentPane();

		jpNorth = new JPanel();
		jcomboBox = new JComboBox<>();
		jcomboBox.addItem("Rot");
		jcomboBox.addItem("Gelb");
		jcomboBox.addItem("Blau");
		jpNorth.add(jcomboBox);

		jpWest = new JPanel();
		jpWest.setLayout(new BoxLayout(jpWest, BoxLayout.Y_AXIS));
		jradioRot = new JRadioButton("Rot");
		jradioGelb = new JRadioButton("Gelb");
		jradioBlau = new JRadioButton("Blau");

		ButtonGroup bg = new ButtonGroup();
		bg.add(jradioRot);
		bg.add(jradioGelb);
		bg.add(jradioBlau);

		jpWest.add(jradioRot);
		jpWest.add(jradioGelb);
		jpWest.add(jradioBlau);

		jpCenter = new JPanel();

		jpSouth = new JPanel();
		jbtnRot = new JButton("Rot");
		jbtnGelb = new JButton("Gelb");
		jbtnBlau = new JButton("Blau");
		jpSouth.add(jbtnRot);
		jpSouth.add(jbtnGelb);
		jpSouth.add(jbtnBlau);

		c.add(jpNorth, BorderLayout.NORTH);
		c.add(jpWest, BorderLayout.WEST);
		c.add(jpCenter, BorderLayout.CENTER);
		c.add(jpSouth, BorderLayout.SOUTH);
		
	}

	// private class MeinActionListener implements ActionListener{
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// String actionComand = e.getActionCommand();
	// if (actionComand.equals("comboBoxChanged"))
	// actionComand = (String) jcomboBox.getSelectedItem();
	// switch (actionComand){
	// case "Rot":
	// jpCenter.setBackground(Color.RED);
	// jradioRot.setSelected(true);
	// jcomboBox.setSelectedItem("Rot");
	// break;
	// case "Gelb":
	// jpCenter.setBackground(Color.YELLOW);
	// jradioGelb.setSelected(true);
	// jcomboBox.setSelectedItem("Gelb");
	// break;
	// case "Blau":
	// jpCenter.setBackground(Color.BLUE);
	// jradioBlau.setSelected(true);
	// jcomboBox.setSelectedItem("Blau");
	// break;
	// }
	// }
	// }

	public static void main(String[] args) {
		new ComboBox_anonym<>();
	}
}
