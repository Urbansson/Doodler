package se.doodle.model.undoredo;

import java.awt.Color;

import se.doodle.model.canvas.shapes.DoodlerShape;

public class UndoRedoChangeColor implements UndoRedo{

	
	private DoodlerShape shape;
	private Color oldColor;
	private Color newColor;

	public UndoRedoChangeColor(DoodlerShape shape,Color newColor){
		this.shape = shape;
		this.oldColor = shape.getColor();
		this.newColor = newColor;
	}
	
	@Override
	public void undo() {
		shape.setColor(oldColor);		
	}

	@Override
	public void redo() {
		shape.setColor(newColor);		
	}

	
	
}
