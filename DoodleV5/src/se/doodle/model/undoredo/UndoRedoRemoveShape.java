package se.doodle.model.undoredo;

import se.doodle.model.canvas.DoodlerCanvas;
import se.doodle.model.canvas.shapes.DoodlerShape;

public class UndoRedoRemoveShape implements UndoRedo{

	
	private DoodlerShape shape;
	private DoodlerCanvas canvas;
	
	public UndoRedoRemoveShape(DoodlerShape shape, DoodlerCanvas canvas){
		this.shape = shape;
		this.canvas = canvas;
		
	}
	
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		canvas.addShape(shape);

	}

	@Override
	public void redo() {
		canvas.removeShapeWithShape(shape);

		// TODO Auto-generated method stub
		
	}

	
	
}
