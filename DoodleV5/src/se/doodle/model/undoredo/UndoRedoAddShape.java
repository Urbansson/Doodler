package se.doodle.model.undoredo;

import se.doodle.model.canvas.DoodlerCanvas;
import se.doodle.model.canvas.shapes.DoodlerShape;

public class UndoRedoAddShape implements UndoRedo{

	
	private DoodlerShape shape;
	private DoodlerCanvas canvas;
	
	public UndoRedoAddShape(DoodlerShape shape, DoodlerCanvas canvas){
		this.shape = shape;
		this.canvas = canvas;
		
	}
	
	
	@Override
	public void undo() {
		canvas.removeShapeWithShape(shape);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		canvas.addShape(shape);

		// TODO Auto-generated method stub
		
	}

	
	
}
