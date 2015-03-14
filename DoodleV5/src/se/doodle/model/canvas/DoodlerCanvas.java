package se.doodle.model.canvas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import se.doodle.model.canvas.shapes.DoodlerShape;

public class DoodlerCanvas implements Serializable {

	private static final long serialVersionUID = 1L;
	List<DoodlerShape> shapes;
	
	public DoodlerCanvas(){
		shapes = new ArrayList<>();
	}
	
	public DoodlerShape addShape(DoodlerShape newShape){
		shapes.add(newShape);
		return newShape;	
	}
	
	public DoodlerShape removeShapeWithShape(DoodlerShape Shape){
		shapes.remove(Shape);
		return Shape;	
	}
	
	public DoodlerShape removeShapeWithIndex(int shapeIndex){
		return shapes.remove(shapeIndex);
	}
	
	
	public DoodlerShape selectShapeWithIndex(int shapeIndex){
		return shapes.get(shapeIndex);
	}
	
	public DoodlerShape selectShapeWithCordinates(int x , int y){	
		ListIterator<DoodlerShape> iterator = shapes.listIterator(shapes.size());
		while(iterator.hasPrevious()) {
			DoodlerShape shape = (DoodlerShape)iterator.previous();
			if(shape.selected(x, y))
				return shape;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<DoodlerShape> getAllShapes(){	
		return (List<DoodlerShape>) ((ArrayList<DoodlerShape>) shapes).clone();
	}
	
}
