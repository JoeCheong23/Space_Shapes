package spaceshapes;

public class HexagonShape extends Shape {
	
	private final int VERTEX_SHIFT = 20;
	private int NUM_OF_POINTS;
	private int[] _xPoints;
	private int[] _yPoints;
	
	public HexagonShape() {
		super();
	}
	
	public HexagonShape(int x, int y) {
		super(x, y);
	}
	
	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height);
		addText(text);
	}
	
	/**
	 * Provides implementation for a method required to paint the Hexagon object in case it has to hold 
	 * text.
	 */
	@Override
	protected void fillShape(Painter painter) {
		
		int leftmostVertexX = _x-1;
		int middleLeftVertexX = _x+VERTEX_SHIFT-1;
		int middleRightVertexX = _x-VERTEX_SHIFT+_width+1;
		int middleVertexX = _x+(_width/2);
		int rightMostVertexX = _x+_width+1;
		int topVertexY = _y-1;
		int middleVertexY = _y+(_height/2)+1;
		int bottomVertexY = _y+_height+1;
		
		if (_width >= 40) {
			_xPoints = new int[]{leftmostVertexX, middleLeftVertexX, middleRightVertexX, rightMostVertexX, middleRightVertexX, middleLeftVertexX};
			_yPoints = new int[]{middleVertexY, topVertexY, topVertexY, middleVertexY, bottomVertexY, bottomVertexY};
			NUM_OF_POINTS = 6;
		} else {
			_xPoints = new int[]{leftmostVertexX, middleVertexX, rightMostVertexX, middleVertexX};
			_yPoints = new int[]{middleVertexY, topVertexY, middleVertexY, bottomVertexY};
			NUM_OF_POINTS = 4;
		}
			
		painter.fillPolygon(_xPoints, _yPoints, NUM_OF_POINTS);
	}
	
	/**
	 * Provides implementation for a method required to draw the Hexagon object.
	 */
	@Override
	protected void drawShape(Painter painter) {
		
		int leftmostVertexX = _x;
		int middleLeftVertexX = _x+VERTEX_SHIFT;
		int middleRightVertexX = _x-VERTEX_SHIFT+_width;
		int middleVertexX = _x+(_width/2);
		int rightMostVertexX = _x+_width;
		int topVertexY = _y;
		int middleVertexY = _y+(_height/2);
		int bottomVertexY = _y+_height;
		
		
		
		if (_width >= 40) {
			painter.drawLine(leftmostVertexX, middleVertexY, middleLeftVertexX, topVertexY);
			painter.drawLine(middleLeftVertexX, topVertexY, middleRightVertexX, topVertexY);
			painter.drawLine(middleRightVertexX, topVertexY, rightMostVertexX, middleVertexY);
			painter.drawLine(rightMostVertexX, middleVertexY, middleRightVertexX, bottomVertexY);
			painter.drawLine(middleRightVertexX, bottomVertexY, middleLeftVertexX, bottomVertexY);
			painter.drawLine(middleLeftVertexX, bottomVertexY, leftmostVertexX, middleVertexY);		
		} else {
			painter.drawLine(leftmostVertexX, middleVertexY, middleVertexX, topVertexY);
			painter.drawLine(middleVertexX, topVertexY, rightMostVertexX, middleVertexY);
			painter.drawLine(rightMostVertexX, middleVertexY, middleVertexX, bottomVertexY);
			painter.drawLine(middleVertexX, bottomVertexY, leftmostVertexX, middleVertexY);
		}
	}

	
	
	
}
