package de.i3a.combobox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.sound.midi.SysexMessage;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ComboBox_innereKlasse<E> extends JFrame {

	private static final long serialVersionUID = 1L;

	private Container c;
	private JButton jbtnRot, jbtnGelb, jbtnBlau;
	private JRadioButton jradioRot, jradioGelb, jradioBlau;
	private JPanel jpNorth, jpWest, jpCenter, jpSouth;
	private JComboBox<String> jcomboBox;
	private JMenuItem jmiRot, jmiBlau, jmiGelb, jmiBeenden;
	private JMenuBar jmb;

	public ComboBox_innereKlasse() {
		this.setTitle("ComboBox");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);

		createMenu();
		initComponents();
		initEvents();

		this.setVisible(true);
	}

	private void initEvents() {
		MeinActionListener mal = new MeinActionListener();
		jbtnRot.addActionListener(mal);
		jbtnGelb.addActionListener(mal);
		jbtnBlau.addActionListener(mal);
		jradioRot.addActionListener(mal);
		jradioGelb.addActionListener(mal);
		jradioBlau.addActionListener(mal);
		jcomboBox.addActionListener(mal);
		jmiBeenden.addActionListener(mal);
		jmiRot.addActionListener(mal);
		jmiBlau.addActionListener(mal);
		jmiGelb.addActionListener(mal);
		jmiBeenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();

			}
		});
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				beenden();
			}
			
		});

	}

	private void createMenu() {

		jmb = new JMenuBar();

		jmiBeenden = new JMenuItem("Beenden");
		jmiRot = new JMenuItem("Rot");
		jmiBlau = new JMenuItem("Blau");
		jmiGelb = new JMenuItem("Gelb");

		JMenu jmenuDatei = new JMenu("Datei");
		jmenuDatei.add(jmiBeenden);

		JMenu jmenuBearbeiten = new JMenu("Bearbeiten");
		jmenuBearbeiten.add(jmiRot);
		jmenuBearbeiten.add(jmiGelb);
		jmenuBearbeiten.add(jmiBlau);

		jmb.add(jmenuDatei);
		jmb.add(jmenuBearbeiten);

		this.setJMenuBar(jmb);
	}

	private void beenden() {
		int i = JOptionPane.showConfirmDialog(null,
				"Wollen Sie wirlich beenden?", "Beenden?",
				JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION) {
			System.exit(NORMAL);
		}

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

		jpCenter.setBackground(Color.RED);
		jradioRot.setSelected(true);
		jcomboBox.setSelectedItem("Rot");
	}

	private class MeinActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("comboBoxChanged"))
				actionCommand = (String) jcomboBox.getSelectedItem();
			switch (actionCommand) {
			case "Rot":
				jpCenter.setBackground(Color.RED);
				jradioRot.setSelected(true);
				jcomboBox.setSelectedItem("Rot");
				break;
			case "Gelb":
				jpCenter.setBackground(Color.YELLOW);
				jradioGelb.setSelected(true);
				jcomboBox.setSelectedItem("Gelb");
				break;
			case "Blau":
				jpCenter.setBackground(Color.BLUE);
				jradioBlau.setSelected(true);
				jcomboBox.setSelectedItem("Blau");
				break;
			default:
				jpCenter.setBackground(Color.RED);
				jradioRot.setSelected(true);
				jcomboBox.setSelectedItem("Rot");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new ComboBox_innereKlasse<>();
	}
}
