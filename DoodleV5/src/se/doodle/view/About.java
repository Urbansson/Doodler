package se.doodle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JDialog {

	private JButton okButton;
	
	public About(JFrame owner) {
		super(owner, "Texas hold'em", true); // true -> Modal
		
		okButton = new JButton("Close");
		okButton.setBounds(90, 133, 79, 29);
	
		JLabel text = new JLabel("<html><center><b>Doodle</b><br>Version 0.1<br><br>"
		+"Made By<br>Theodor Brandt<br>Kevin Brejcha</center></html>");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(6, 6, 238, 96);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setPreferredSize(new Dimension(250,180));
		panel.setLayout(null);

		panel.add(text);
		panel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		this.setLocation(((owner.getWidth()/2)-125), 200);
		this.getContentPane().add(panel);
		this.pack();
		this.setResizable(false);
	}


	private static final long serialVersionUID = 1L;
}
