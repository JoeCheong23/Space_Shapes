package spaceshapes;

/**
 * Class to represent a simple rectangular space-shape.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class RectangleShape extends Shape {
	/**
	 * Default constructor that creates a RectangleShape instance whose instance
	 * variables are set to default values.
	 */
	public RectangleShape() {
		super();
	}
	
	public RectangleShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public RectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height);
		addText(text);
	}
	
	/**
	 * Provides implementation for a method required to draw the Rectangle object.
	 */
	@Override
	protected void drawShape(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
	}
	
	/**
	 * Provides implementation for a method required to paint the Rectangle object in case it has to hold 
	 * text.
	 */
	@Override
	protected void fillShape(Painter painter) {
		painter.fillRect(_x, _y, _width, _height);
	}
}
