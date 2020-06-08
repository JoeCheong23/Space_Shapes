package spaceshapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * Two design patterns were implemented. First, the general hierarchy design pattern
 * was implemented for the CarrierShape class. Second, the template method design
 * pattern was implemented to allow all shapes to automatically have a coloured
 * background when they display text.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	
	protected static final Color DEFAULT_COLOUR = Color.WHITE;
	
	protected static final Color DEFAULT_BACKGROUND_COLOUR = Color.blue;
	
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected boolean _collisionWithLeftOrRight = false;
	
	protected Color _chosenColour = DEFAULT_COLOUR;
	
	protected Color _chosenTextBackgroundColour = DEFAULT_BACKGROUND_COLOUR;
	
	protected Color _originalColour;
	
	// ===
	
	// === Instance of variables, not accessible by subclasses.
	private CarrierShape _parent = null;
	private String _shapeText = null;
	
	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_collisionWithLeftOrRight = true;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_collisionWithLeftOrRight = true;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_collisionWithLeftOrRight = false;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_collisionWithLeftOrRight = false;
		}

		_x = nextX;
		_y = nextY;
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting. This acts as the template method.
	 * @param painter the Painter object used for drawing.
	 */
	public final void paint(Painter painter) {
		if (_shapeText != null) {
			paintTextShape(painter);
		} else {
			drawShape(painter);
		}
	}

	/**
	 * Fills the Shape object with the chosen or default colour. This acts as one of
	 * the hook methods.
	 */
	protected abstract void fillShape(Painter painter);
	
	/**
	 * Draws the shape object. This acts as one of the hook methods.
	 * @param painter
	 */
	protected abstract void drawShape(Painter painter);
	
	
	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}
	
	/**
	 * Associates the current Shape object with a CarrierShape object as a parent.
	 */
	public void addParent(CarrierShape parent) throws IllegalArgumentException{
		
		if (_parent == null) {
			_parent = parent;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Removes the association that the current Shape object has with its CarrierShape 
	 * object if the current Shape object is a child of the CarrierShape object
	 */
	public void removeParent() {
		_parent = null;
	}
	
	/**
	 * Returns the CarrierShape that contains the Shape that method parent is called
	 * on. If the callee object is not a child within a CarrierShape instance, this 
	 * method returns null.
	 */
	public CarrierShape parent() {
		return _parent;
	}
	
	/**
	 * Returns an ordered list of Shape objects. The first item within the list is the 
	 * root CarrierShape of the containment hierarchy. The last item within the list is the
	 * callee object (hence this method always returns a list with at least one item). Any
	 * intermediate items are CarrierShapes that connect the root CarrierShape to the
	 * callee Shape. E.g., given:
	 * 
	 * 	CarrierShape root = new CarrierShape();
	 * 	CarrierShape intermediate = new CarrierShape();
	 * 	Shape oval = new OvalShape();
	 * 	root.add(intermediate);
	 * 	intermediate.add(oval);
	 * 
	 * a call to oval.path() yields [root,intermediate,oval]
	 */
	public List<Shape> path(){
		
		 List<Shape> pathList = new ArrayList<Shape>();
		 Stack<Shape> pathStack = new Stack<Shape>();
		 Shape tempShape;
		 pathStack.push(this);
		 
		 while (true) {
			 tempShape = pathStack.peek().parent();
			 if (tempShape == null) {
				 break;
			 } else {
				 pathStack.push(tempShape);
			 }
		 }
		 
		 while (pathStack.isEmpty() == false) {
			 pathList.add(pathStack.pop());
		 }
		
		 return pathList;
	}
	
	/**
	 * Adds text to the current shape.
	 */
	protected void addText(String text) {
		_shapeText = text;
	}
	
	/**
	 * Removes text from being associated with this Shape object.
	 */
	protected void removeText() {
		_shapeText = null;
	}
	
	/**
	 * Paints the text inside a a filled version of the Shape.
	 */
	private void paintTextShape(Painter painter) {
			_originalColour = painter.getColor();
			painter.setColor(_chosenTextBackgroundColour);
			fillShape(painter);
			painter.setColor(DEFAULT_COLOUR);
			painter.drawCentredText(_shapeText, _x, _y, _width, _height);
			painter.setColor(_originalColour);
		
	}
	
	
}
