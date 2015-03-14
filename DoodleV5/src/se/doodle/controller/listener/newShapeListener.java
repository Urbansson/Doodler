package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.doodle.model.canvas.shapes.AvailableShapes;
import se.doodle.model.canvas.shapes.DoodlerShape;
import se.doodle.model.canvas.shapes.ShapeFactory;
import se.doodle.view.DoodleViewCanvas;
import se.doodle.view.NewShape;

public class newShapeListener implements ActionListener{
	
	private NewShape newShapeDialog;
	private DoodleViewCanvas canvas;
	private AvailableShapes shapetype;
	
	
	public newShapeListener(NewShape newShapeDialog, DoodleViewCanvas canvas,AvailableShapes shapetype){
		this.newShapeDialog = newShapeDialog;
		this.canvas = canvas;
		this.shapetype = shapetype;
	}
	
	public void actionPerformed(ActionEvent ae) {
		newShapeDialog.setVisible(true);
		
		try {
			DoodlerShape tmp = ShapeFactory.createShape(shapetype);
			tmp.setBorderColor(newShapeDialog.getBorderColor());
			tmp.setColor(newShapeDialog.getFillColor());
			tmp.setBorderSize(newShapeDialog.getBorderSize());
			tmp.setFilled(newShapeDialog.isFilled());

			canvas.setTempNewShape(tmp);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			canvas.setTempNewShape(null);
		}
		
	}
}
	
	
