package se.doodle.model;

import java.awt.Color;
import java.util.List;
import java.util.Observable;

import se.doodle.model.canvas.DoodlerCanvas;
import se.doodle.model.canvas.shapes.DoodlerShape;
import se.doodle.model.undoredo.UndoRedoAddShape;
import se.doodle.model.undoredo.UndoRedoInvoker;
import se.doodle.model.undoredo.UndoRedoRemoveShape;
import se.doodle.model.undoredo.UndoRedomodification;

public class Doodler extends Observable{

	DoodlerCanvas canvas;
	UndoRedoInvoker invoker;
	
	DoodlerShape selected = null;


	public Doodler(){
		invoker = new UndoRedoInvoker();
		this.newCanvas();
	}

	public DoodlerShape addShape(DoodlerShape newShape){
		canvas.addShape(newShape);

		invoker.addUndoCommand(new UndoRedoAddShape(newShape, canvas));
		invoker.clearRedo();
		updateObserbers(UpdateMessage.SHAPE_ADDED);

		return newShape;	
	}

	public DoodlerShape removeShapeWithShape(DoodlerShape Shape){
		canvas.removeShapeWithShape(Shape);
		
		invoker.addUndoCommand(new UndoRedoRemoveShape(Shape, canvas));
		invoker.clearRedo();
		updateObserbers(UpdateMessage.SHAPE_REMOVED);

		return Shape;	
	}

	public DoodlerShape removeShapeWithIndex(int shapeIndex){
		return canvas.removeShapeWithIndex(shapeIndex);
	}


	public DoodlerShape selectShapeWithIndex(int shapeIndex){
		this.selected =  canvas.selectShapeWithIndex(shapeIndex);
		return getSelected();
	}

	public DoodlerShape selectShapeWithCordinates(int x , int y){	
		this.selected = canvas.selectShapeWithCordinates(x, y);
		return getSelected();
	}


	public DoodlerShape getSelected(){	
		if(selected != null){
			try {
				return selected.clone();
			} catch (CloneNotSupportedException e) {}
		}
		return null;
	}

	
	
	public void modifySelected(int newBorderSize, Color newColor, Color newBorderColor, boolean filled ){
		if(selected != null){
			
			invoker.addUndoCommand(new UndoRedomodification(selected, newBorderSize, newColor, newBorderColor, filled));
			invoker.clearRedo();

			selected.setBorderSize(newBorderSize);
			selected.setBorderColor(newBorderColor);
			selected.setColor(newColor);
			selected.setFilled(filled);
		}
		
	}
	
	/*
	public void changeBorderSizeOnSelected(int newBorderSize){
		if(selected != null){
			selected.setBorderSize(newBorderSize);
		}
	}

	public void changeBorderColorOnSelected(Color newBorderColor){
		if(selected != null){
			invoker.addUndoCommand(new UndoRedoChangeBorderColor(selected, newBorderColor));
			selected.setBorderColor(newBorderColor);
		}
	}

	public void changeColorOnSelected(Color newColor){
		if(selected != null){
			invoker.addUndoCommand(new UndoRedoChangeColor(selected, newColor));
			selected.setColor(newColor);
		}
	}

	public void setFilledOnSelected(boolean filled){
		if(selected != null){
			selected.setFilled(filled);
		}
	}*/

	
	public void undo(){
		invoker.undo();
		updateObserbers(UpdateMessage.UNDO_REDO);
	}
	
	public void redo(){
		invoker.redo();
		updateObserbers(UpdateMessage.UNDO_REDO);
	}
	
	public boolean redoAvailable(){
		return invoker.redoAvailable();
	}
	

	public boolean undoAvailable(){
		return invoker.undoAvailable();
	}
	
	
	public void removeSelected(){
		removeShapeWithShape(selected);
	}

	public List<DoodlerShape> getAllShapes(){	
		return canvas.getAllShapes();
	}


	public void newCanvas(){
		canvas = new DoodlerCanvas();
		this.updateObserbers(UpdateMessage.NEW_CANVAS);
	}

	public void loadCanvas(DoodlerCanvas loadedCanvas){
		this.canvas	= loadedCanvas;
		this.invoker = new UndoRedoInvoker();
		this.updateObserbers(UpdateMessage.NEW_CANVAS);

	}

	public DoodlerCanvas saveCanvas(){
		return this.canvas;
	}

	private void updateObserbers(UpdateMessage message){
		
		this.undoAvailable();
		this.redoAvailable();

		setChanged();
		notifyObservers(message);
	}	

	
}
