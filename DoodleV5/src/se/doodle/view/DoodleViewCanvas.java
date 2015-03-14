package se.doodle.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import se.doodle.model.Doodler;
import se.doodle.model.UpdateMessage;
import se.doodle.model.canvas.shapes.DoodlerShape;

public class DoodleViewCanvas extends JPanel implements Observer{
	
	Doodler model;
	DoodlerShape tempNewShape;
	
	public DoodlerShape getTempNewShape() {
		return tempNewShape;
	}


	public void setTempNewShape(DoodlerShape tempNewShape) {
		this.tempNewShape = tempNewShape;
	}


	public DoodleViewCanvas(Doodler model) {
		this.model = model;
		setBackground(Color.WHITE);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void update(Observable o, Object arg) {

		
		if(((UpdateMessage) arg).equals(UpdateMessage.NEW_CANVAS)){
			repaint();
		}
		
		if(((UpdateMessage) arg).equals(UpdateMessage.SHAPE_ADDED)){
			repaint();
		}
		
		if(((UpdateMessage) arg).equals(UpdateMessage.SHAPE_REMOVED)){
			repaint();
		}
		
		if(((UpdateMessage) arg).equals(UpdateMessage.UNDO_REDO)){
			repaint();
		}
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
        for(DoodlerShape s: model.getAllShapes()){
        	s.paint(g2);
        }
    }

	public Doodler getModel(){
		
		return this.model;
	}

}

