package se.doodle.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.LineBorder;

import se.doodle.model.Doodler;
import se.doodle.model.canvas.shapes.DoodlerShape;

public class SelectedShape extends JDialog {

	private JButton okButton = new JButton("Modify");

	private JPanel borderColorPrew;
	private JPanel fillColorPrew;
	
	private JRadioButton rdbtnFilled;
	private JSlider slider;
	

	
	
	private Color fillColor = Color.white;
	private Color borderColor = Color.white;
	private int borderSize;
	private boolean filled;


	private DoodlerShape selectedShape;
	private Doodler model;

	public SelectedShape(JFrame owner, Doodler model) {
		super(owner, "New Shape", true); // true -> Modal

		this.model = model;

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setPreferredSize(new Dimension(250,200));

		JButton chooseFillColor = new JButton("Choose fill Color");        
		chooseFillColor.setBounds(6, 6, 175, 29);
		chooseFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(getParent(),
						"Choose fill color", fillColorPrew.getBackground());
				if(fillColor == null){
					fillColor = Color.WHITE;
				}
				fillColorPrew.setBackground(fillColor);
				repaint();
			}
		});
		panel.setLayout(null);

		panel.add(chooseFillColor);

		fillColorPrew = new JPanel();
		fillColorPrew.setBackground(fillColor);
		fillColorPrew.setBorder(new LineBorder(new Color(0, 0, 0)));
		fillColorPrew.setBounds(219, 6, 25, 25);
		panel.add(fillColorPrew);

		JButton chooseBorderColor = new JButton("Choose border Color");        
		chooseBorderColor.setBounds(6, 41, 175, 29);
		chooseBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borderColor = JColorChooser.showDialog(getParent(),
						"Choose border color", borderColorPrew.getBackground());
				if(borderColor == null){
					borderColor = Color.WHITE;
				}

				borderColorPrew.setBackground(borderColor);
				repaint();
			}
		});

		panel.add(chooseBorderColor);

		borderColorPrew = new JPanel();
		borderColorPrew.setBackground(borderColor);
		borderColorPrew.setBorder(new LineBorder(new Color(0, 0, 0)));
		borderColorPrew.setBounds(219, 41, 25, 25);
		panel.add(borderColorPrew);

		JLabel lblBorderSize = new JLabel("Border Size");
		lblBorderSize.setBounds(90, 78, 69, 16);
		panel.add(lblBorderSize);

		slider = new JSlider();
		slider.setBounds(30, 99, 190, 52);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(10);
		panel.add(slider);
		okButton.setBounds(164, 163, 80, 29);

		panel.add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOnOK();
			}
		});

		this.setVisible(false);
		this.setLocation(((owner.getWidth()/2)-125), ((owner.getHeight()/2)-100));
		this.getContentPane().add(panel);

		rdbtnFilled = new JRadioButton("Filled");
		rdbtnFilled.setBounds(6, 171, 69, 23);
		panel.add(rdbtnFilled);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOnRemove();
			}
		});

		btnRemove.setBackground(Color.RED);
		btnRemove.setBounds(90, 163, 80, 29);
		panel.add(btnRemove);
		this.pack();
		this.setResizable(false);
	}


	public void updateDialogInfo(){
		this.selectedShape = model.getSelected();
		
		this.rdbtnFilled.setSelected(selectedShape.isFilled());
		this.slider.setValue(selectedShape.getBorderSize());

		this.fillColorPrew.setBackground(selectedShape.getColor());
		this.borderColorPrew.setBackground(selectedShape.getBorderColor());
		
		this.borderColor = (selectedShape.getBorderColor());
		this.fillColor = (selectedShape.getColor());
	
	}
	private void closeOnOK() {
		
		this.borderSize = slider.getValue();
		this.filled =  this.rdbtnFilled.isSelected();
		
		if(model.getSelected() != null){
			model.modifySelected(borderSize, fillColor, borderColor, filled);	
		}
		setVisible(false);
		selectedShape = null;
	}

	private void closeOnRemove() {
		if(selectedShape != null){
			model.removeSelected();
		}
		
		setVisible(false);
		selectedShape = null;
	}


	private static final long serialVersionUID = 1L;
}
