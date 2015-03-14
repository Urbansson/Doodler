package se.doodle.model.undoredo;

import java.awt.Color;

import se.doodle.model.canvas.shapes.DoodlerShape;

public class UndoRedomodification implements UndoRedo {

	
	private DoodlerShape shape;
	
	private Color oldBorderColor;
	private Color newBorderColor;
	
	private Color oldFillColor;
	private Color newFillColor;
	
	private int oldBorderSize;
	private int newBorderSize;

	private boolean oldFilledStatus;
	private boolean newFilledStatus;

	public UndoRedomodification(DoodlerShape shape,int borderSize,Color newColor,Color newBorderColor, boolean filled){
		this.shape = shape;
		
		this.oldBorderColor = shape.getBorderColor();
		this.newBorderColor = newBorderColor;
		
		this.oldFillColor = shape.getColor();
		this.newFillColor = newColor;
		
		this.oldBorderSize = shape.getBorderSize();
		this.newBorderSize = borderSize;
		
		this.oldFilledStatus = shape.isFilled();
		this.newFilledStatus = filled;
	}
	
	
	@Override
	public void undo() {
		shape.setBorderColor(oldBorderColor);		
		shape.setColor(oldFillColor);		
		shape.setBorderSize(oldBorderSize);		
		shape.setFilled(oldFilledStatus);	
	}

	@Override
	public void redo() {
		shape.setBorderColor(newBorderColor);		
		shape.setColor(newFillColor);		
		shape.setBorderSize(newBorderSize);		
		shape.setFilled(newFilledStatus);	
	}

}
