package spaceshapes;

import java.awt.Color;

public class DynamicShape extends RectangleShape{

	
	
	public DynamicShape() {
		super();
	}
	
	public DynamicShape(Color colour) {
		super();
		_chosenColour = colour;
		_chosenTextBackgroundColour = colour;
	}
	
	public DynamicShape(int x, int y) {
		super(x, y);
	}
	
	public DynamicShape(int x, int y, Color colour) {
		super(x, y);
		_chosenColour = colour;
		_chosenTextBackgroundColour = colour;
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, Color colour) {
		super(x, y, deltaX, deltaY);
		_chosenColour = colour;
		_chosenTextBackgroundColour = colour;
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color colour) {
		super(x, y, deltaX, deltaY, width, height);
		_chosenColour = colour;
		_chosenTextBackgroundColour = colour;
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height);
		addText(text);
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour) {
		super(x, y, deltaX, deltaY, width, height);
		addText(text);
		_chosenColour = colour;
		_chosenTextBackgroundColour = colour;
	}
	
	/**
	 * Overrides the drawShape method from RectangleShape to allow the shape to be coloured when it collides
	 * with the left and right boundaries, and turn back into a regular uncoloured rectangle when it collides
	 * with the ceiling or floor boundaries.
	 */
	@Override
	protected void drawShape(Painter painter) {
		
		if (_collisionWithLeftOrRight) {
			_originalColour = painter.getColor();
			painter.setColor(_chosenColour);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(_originalColour);
		} else {
			super.drawShape(painter);
		}

	}
	
	
}
