package se.doodle.model.canvas.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends DoodlerShape {
	
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;
	
	public Rectangle() {
		super.type = AvailableShapes.RECTANGLE;
	} 
	
	
	
	@Override
	public boolean selected(int x, int y) {
		if(x <= super.getEndXCord() && x >= super.getStartXCord()){
			if(y <= super.getEndYCord() && y >= super.getStartYCord()){
				return true;
			}
		}
		return false;
	}

	@Override
	public void paint(Graphics2D g) {
		this.width = Math.abs(getStartXCord() - getEndXCord());
		this.height = Math.abs(getStartYCord() - getEndYCord());

		g.setColor(getColor());
		if(isFilled()){
			g.fillRect((int)getStartXCord(), (int)getStartYCord(), (int)width, (int)height);	
		}else{
			g.setColor(getColor());
			g.setStroke(new BasicStroke(1));
			g.draw(new Rectangle2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)width, (int)height));
		}
		
		if(getBorderSize()>0){
			g.setColor(getBorderColor());
			g.setStroke(new BasicStroke(getBorderSize()));
			g.draw(new Rectangle2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)width, (int)height));
		}
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		super.setStartYCord(super.getStartYCord()+height);	
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		super.setStartXCord(super.getStartXCord()+width);
	}
	
}
