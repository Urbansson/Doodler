package se.doodle.model.undoredo;

import java.awt.Color;

import se.doodle.model.canvas.shapes.DoodlerShape;

public class UndoRedoChangeBorderColor implements UndoRedo{

	
	private DoodlerShape shape;
	private Color oldColor;
	private Color newColor;

	public UndoRedoChangeBorderColor(DoodlerShape shape,Color newColor){
		this.shape = shape;
		this.oldColor = shape.getBorderColor();
		this.newColor = newColor;
	}
	
	@Override
	public void undo() {
		shape.setBorderColor(oldColor);		
	}

	@Override
	public void redo() {
		shape.setBorderColor(newColor);		
	}

	
	
}
