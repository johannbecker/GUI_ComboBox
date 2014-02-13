package de.i3.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ComboBox_anonym<E> extends JFrame implements ActionListener{

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
//		jcomboBox.addActionListener(this);
//		jradioRot.addActionListener(this);
		MeinItemListener mil = new MeinItemListener();		// Fensterklasse
		jcomboBox.addItemListener(mil);						// Innere Klasse
		jcomboBox.addItemListener(new MeinItemListenerA());	// Externe Klasse
		jcomboBox.addItemListener(new ItemListener() {		// Anynome Klasse
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		this.setVisible(true);
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
//		jradioRot.setActionCommand("FOO");
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


	public static void main(String[] args) {
		new ComboBox_anonym<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		String eintrag = (String) jcomboBox.getSelectedItem();
		System.out.println("Gewählter eingtrag: " + eintrag);
		if(eintrag.equals("Rot")){
			jpCenter.setBackground(Color.RED);			
		}
		if("Gelb".equals(eintrag)){
			jpCenter.setBackground(Color.YELLOW);
		}

	}
	
	private class MeinItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println(e.getItem());
		}
		
		
	}
	
}
