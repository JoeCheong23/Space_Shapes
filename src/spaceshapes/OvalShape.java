package spaceshapes;

public class OvalShape extends Shape{

	
	public OvalShape() {
		super();
	}
	
	public OvalShape(int x, int y) {
		super(x, y);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height);
		addText(text);
	}
	
	/**
	 * Provides implementation for a method required to paint the Oval object in case it has to hold 
	 * text.
	 */
	@Override
	protected void fillShape(Painter painter) {
		painter.fillOval(_x, _y, _width, _height);
	}
	
	/**
	 * Provides implementation for a method required to draw the Oval object.
	 */
	@Override
	protected void drawShape(Painter painter) {
		painter.drawOval(_x, _y, _width, _height);	
		
	}

}