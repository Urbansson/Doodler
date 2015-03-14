package se.doodle.model.canvas.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;



public class Circle extends DoodlerShape{

	private static final long serialVersionUID = 1L;
	private int diameter;
	
	public Circle() {
		super.type = AvailableShapes.CIRCLE;
	} 
	
	@Override
	public boolean selected(int x, int y) {
		
		//int minX = Math.min(getStartXCord(), getEndXCord());
		//int minY = Math.min(getStartYCord(), getEndYCord());
		
		
		//Same algorithm as Ellipse2D 
        double ellw = getDiameter();
        if (ellw <= 0.0) {
            return false;
        }
        double normx = (x - getStartXCord()) / ellw - 0.5;
        double ellh = getDiameter();
        if (ellh <= 0.0) {
            return false;
        }
        double normy = (y - getStartYCord()) / ellh - 0.5;
        return (normx * normx + normy * normy) < 0.25;
        
	}
	
	
	@Override
	public void setEndXCord(int endXCord) {
		super.setEndXCord(endXCord);
	};
	
	
	
	
	@Override
	public void paint(Graphics2D g) {
		this.diameter = Math.abs(getStartXCord() - getEndXCord());
		
		//int minX = Math.min(getStartXCord(), getEndXCord());
		//int minY = Math.min(getStartYCord(), getEndYCord());

		
		g.setColor(getColor());
		g.setStroke(new BasicStroke(getBorderSize()));
		g.draw(new Ellipse2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)(diameter), (int)(diameter)));	
		
		g.setColor(getColor());
		if(isFilled()){
			g.fillOval((int)getStartXCord(), (int)getStartYCord(), (int)(diameter), (int)(diameter));	
		}else{
			g.setColor(getColor());
			g.setStroke(new BasicStroke(2));
			g.draw(new Ellipse2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)(diameter), (int)(diameter)));	
		}
		
		if(getBorderSize()>0){
			g.setColor(getBorderColor());
			g.setStroke(new BasicStroke(getBorderSize()));
			g.draw(new Ellipse2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)(diameter), (int)(diameter)));	
		}
	}
	
	public int getDiameter() {
		return diameter;
	}


	public void setDiameter(int diameter) {
		this.diameter = diameter;
		super.setEndXCord(super.getStartXCord()+diameter);
		super.setEndYCord(super.getStartYCord()+diameter);
	}



}
