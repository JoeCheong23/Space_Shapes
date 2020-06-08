package spaceshapes;

import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape {
	
	private List<Shape> childShapes = new ArrayList<Shape>();
	/**
	/ Creates a CarrierShape object with default values for state.
	*/
	public CarrierShape() {
		super();
	}
	
	/**
	 * Creates a CarrierShape object with specified location values,
	 * default values for other state items.
	 */
	public CarrierShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity and direction.
	 * Non-specified state items take on default values.
	 */
	
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity, direction,
	 * width and height.
	 */
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity, direction,
	 * width, height, and text
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height);
		addText(text);
	}
	
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds specified by 
	 * arguments width and height.
	 */
	@Override
	public void move(int width, int height) {
		
		super.move(width, height);
		
		for (Shape child:childShapes) {
			child.move(_width, _height);
		}
		
	}
	
	
	/**
	 * Attempts to add a Shape to a CarrierShape object. If successful, a two-way link is
	 * established between the CarrierShape and the newly added Shape. Note that this 
	 * method has package visibility - for reasons that will become apparent in Space
	 * Shapes III.
	 * @param shape the shape to be added.
	 * @throws IllegalArgumentException if an attempt is made to add a Shape to
	 * a CarrierShape instance where the Shape argument is already a child within a 
	 * CarrierShape instance. An IllegalArgumentException is also thrown when an attempt
	 * is made to add a Shape that will not fit within the bounds of the proposed
	 * CarrierShape object.
	 */
	void add(Shape shape) throws IllegalArgumentException {
		
		if ((_width < shape.x()+shape.width()) || (_height < shape.y()+shape.height()) ) {
			throw new IllegalArgumentException();
		} else {
			shape.addParent(this);
			childShapes.add(shape);
		}
		
	}
	
	/**
	 * Removes a particular Shape from a CarrierShape instance. Once removed, the two-way
	 * link between the CarrierShape and its former child is destroyed. This method has no 
	 * effect if the Shape specified to remove is not a child of the CarrierShape. Note that
	 * this method has package visibility - for reasons that will become apparent in Space
	 * Shapes III. 
	 * @param shape the shape to be removed. 
	 */
	void remove(Shape shape) {
		
		if (contains(shape) == true) {
			childShapes.remove(shape);
			shape.removeParent();
		}
		
	}
	
	/**
	 * Returns the Shape at a specified position within a CarrierShape. If the position
	 * specified is less than zero or greater than the number of children stored in the 
	 * CarrierShape less one, this method throws an IndexOutOfBoundsException. 
	 * @param index the specified index position.
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		
		return childShapes.get(index);
				
	}
	
	/**
	 * Returns the number of children contained within a CarrierShape object. Note this
	 * method is not recursive - it simply returns the number of children at the top level 
	 * within the callee CarrierShape object.
	 */
	public int shapeCount() {
		
		return childShapes.size();
		
	}
	
	/**
	 * Returns the index of a specified child within a CarrierShape object. If the Shape
	 * specified is not actually a child of the CarrierShape, this method returns -1;
	 * otherwise the value returned is in the range 0..shapeCount()-1.
	 * @param shape the shape whose index position within the CarrierShape is requested.
	 */
	public int indexOf(Shape shape) {
		
		return childShapes.indexOf(shape);
		
	}
	
	/**
	 * Returns true if the Shape argument is a child of the CarrierShape object on which this
	 * method is called, false otherwise.
	 */
	public boolean contains(Shape shape) {
		
		return childShapes.contains(shape);
		
	}
	
	/**
	 * Provides implementation for a method required to paint the CarrierShape object in case it has to hold 
	 * text.
	 */
	@Override
	protected void fillShape(Painter painter) {
		painter.fillRect(_x, _y, _width, _height);
	}
	
	/**
	 * Provides implementation for a method required to draw the CarrierShape object and its children.
	 */
	@Override
	protected void drawShape(Painter painter) {
	
		painter.drawRect(_x, _y, _width, _height);
		for (Shape child:childShapes) {
			painter.translate(_x, _y);
			child.paint(painter);
			painter.translate(-_x, -_y);
		}
	}
	
	
}
