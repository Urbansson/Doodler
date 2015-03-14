package se.doodle.model.canvas.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;


public abstract class DoodlerShape implements Cloneable,Serializable {

	private static final long serialVersionUID = 1L;
	
	private int startXCord = 0;
	private int startYCord = 0;
	
	private int endXCord = 0;
	private int endYCord = 0;
		
	private int borderSize = 0;
	private boolean filled = false;
	private Color color = Color.BLACK;
	private Color borderColor = Color.BLACK;

	protected AvailableShapes type = null;

	abstract public boolean selected(int x, int y);
	
	//Kinda breaks the MVC pattern but makes everything much simpler
	abstract public void paint(Graphics2D g);

	//Always places the lowest cords as the start values
	public void setCordinates(int x1,int y1,int x2, int y2) {		
		this.setStartXCord(Math.min(x1, x2));
		this.setEndXCord(Math.max(x1, x2));

		this.setStartYCord(Math.min(y1, y2));
		this.setEndYCord(Math.max(y1, y2));
	}
	
	
	public int getStartXCord() {
		return startXCord;
	}

	public void setStartXCord(int startXCord) {
		this.startXCord = startXCord;
	}

	public int getStartYCord() {
		return startYCord;
	}

	public void setStartYCord(int startYCord) {
		this.startYCord = startYCord;
	}

	public int getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(int borderSize) {
		this.borderSize = borderSize;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}


	
	public DoodlerShape clone() throws CloneNotSupportedException{
		DoodlerShape clone = null;

		try {
			clone = (DoodlerShape) super.clone();
			clone.setColor(new Color(getColor().getRGB()));
			clone.setBorderColor(new Color(getBorderColor().getRGB()));

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public AvailableShapes getType() {
		return type;
	}

	public void setType(AvailableShapes type) {
		this.type = type;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getEndYCord() {
		return endYCord;
	}

	public void setEndYCord(int endYCord) {
		this.endYCord = endYCord;
	}

	public int getEndXCord() {
		return endXCord;
	}

	public void setEndXCord(int endXCord) {
		this.endXCord = endXCord;
	}
	
}
