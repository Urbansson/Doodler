package se.doodle.model.canvas.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Square  extends DoodlerShape{

	private static final long serialVersionUID = 1L;
	private int sideLength = 0;

	public Square() {
		super.type = AvailableShapes.SQUARE;
	} 

	@Override
	public boolean selected(int x, int y) {
		if(x <= super.getStartXCord()+sideLength && x >= super.getStartXCord()){
			if(y <= super.getStartYCord()+sideLength && y >= super.getStartYCord()){
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void paint(Graphics2D g) {
		this.sideLength = Math.abs(getStartXCord() - getEndXCord());
		
		g.setColor(getColor());
		if(isFilled()){
			g.fillRect((int)getStartXCord(), (int)getStartYCord(), (int)sideLength, (int)sideLength);	
		}else{
			g.setColor(getColor());
			g.setStroke(new BasicStroke(1));
			g.draw(new Rectangle2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)sideLength, (int)sideLength));
		}
		
		if(getBorderSize()>0){
			g.setColor(getBorderColor());
			g.setStroke(new BasicStroke(getBorderSize()));
			g.draw(new Rectangle2D.Float((int)getStartXCord(), (int)getStartYCord(), (int)sideLength, (int)sideLength));
		}

	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
		super.setStartXCord(super.getStartXCord()+sideLength);
		super.setStartYCord(super.getStartYCord()+sideLength);
	}


}
