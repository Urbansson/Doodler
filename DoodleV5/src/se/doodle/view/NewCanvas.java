package se.doodle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCanvas extends JDialog {

	private JButton okButton = new JButton("Create");

	private JComboBox<String> heightSelector = new JComboBox<String>();

	private JComboBox<String> widthSelector = new JComboBox<String>();
	
	//private static String[] options = { "300", "600", "1200" };

	private int width = 0;
	private int height = 0;
	
	public NewCanvas(JFrame owner) {
		super(owner, "New Canvas", true); // true -> Modal
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setPreferredSize(new Dimension(250,200));
/*
		for (int i = 0; i < options.length; i++) {
			heightSelector.addItem(options[i]);
		}
		
		for (int i = 0; i < options.length; i++) {
			widthSelector.addItem(options[i]);
		}
		
		panel.setLayout(null);

		JLabel label = new JLabel("Choose Players");
		label.setBounds(5, 5, 240, 38);
		panel.add(label);
		
		heightSelector.setBounds(5, 43, 240, 38);
		panel.add(heightSelector);
		JLabel label_1 = new JLabel("Choose Starting Cash");
		label_1.setBounds(5, 81, 240, 38);
		panel.add(label_1);
		
		widthSelector.setBounds(5, 119, 240, 38);
		panel.add(widthSelector);
		okButton.setBounds(5, 157, 240, 38);
*/
		panel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOnOK();
			}
		});
		panel.setVisible(true);
		this.setVisible(false);
		this.setLocation(((owner.getWidth()/2)-125), ((owner.getHeight()/2)-100));
		this.getContentPane().add(panel);
		this.pack();
		this.setResizable(false);
	}

	public int getSelectedWidth() {
		return width;
	}
	public int getSelectedHeight() {
		return height;
	}

	private void closeOnOK() {
		
		switch((int) widthSelector.getSelectedIndex()){
		case 0:
			width = 500;
			break;
		case 1:
			width = 1000;
			break;
		case 2:
			width = 1500;
			break;
		}
		
		switch((int) heightSelector.getSelectedIndex()){
		case 0:
			width = 500;
			break;
		case 1:
			width = 1000;
			break;
		case 2:
			width = 1500;
			break;
		}
		
		setVisible(false);
	}

	private static final long serialVersionUID = 1L;
}
