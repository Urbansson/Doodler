package se.doodle.model.canvas.shapes;

import java.util.Hashtable;

public class ShapeFactory {

	private static Hashtable<AvailableShapes, DoodlerShape> shapeMap  = new Hashtable<AvailableShapes, DoodlerShape>();

	static {
		shapeMap.put( AvailableShapes.SQUARE,   new Square() );
		shapeMap.put( AvailableShapes.CIRCLE,  new Circle() );
		shapeMap.put( AvailableShapes.RECTANGLE, new Rectangle() );
	}

	public static DoodlerShape createShape( AvailableShapes s ) throws CloneNotSupportedException {
		return (DoodlerShape) shapeMap.get(s).clone();
	}
	

}

