package se.doodle.controller.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import se.doodle.model.Doodler;
import se.doodle.model.canvas.shapes.DoodlerShape;
import se.doodle.view.DoodleViewCanvas;
import se.doodle.view.SelectedShape;

public class canvasMouseListener implements MouseListener{


	private DoodleViewCanvas canvas;
	private Doodler model;

	private int startX;
	private int startY;
	private SelectedShape selectShapeDialaog;


	public canvasMouseListener(DoodleViewCanvas canvas, Doodler model, SelectedShape selectShapeDialaog){
		this.canvas = canvas;
		this.model = model;
		this.selectShapeDialaog = selectShapeDialaog;
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		DoodlerShape tmp = model.selectShapeWithCordinates(e.getX(), e.getY());

		if(tmp != null){

			this.selectShapeDialaog.updateDialogInfo();
			this.selectShapeDialaog.setVisible(true);
			
			canvas.repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

		startX = e.getX();
		startY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int temp =   (int) Math.sqrt(
				(startX - e.getX()) *  (startX - e.getX()) + 
				(startY - e.getY()) *  (startY - e.getY())
				);

		if(canvas.getTempNewShape() != null && temp>25){
	
			canvas.getTempNewShape().setCordinates(startX, startY, e.getX(), e.getY());
			
			try {
				model.addShape(canvas.getTempNewShape().clone());
			} catch (CloneNotSupportedException e1) {}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
