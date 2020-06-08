package spaceshapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.FontMetrics;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	
	public static Font FONT = new Font("Serif", Font.BOLD, 20);
	
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Fills the Rectangle shape with the specific colour.
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Fills the Oval shape with the specified colour.
	 */
	public void fillOval(int x, int y, int width, int height);
	
	/**
	 * Fills Polygon shape with the specified colour.
	 */
	public void fillPolygon(int[] xPoints, int[] yPoints, int numberOfPoints);
	
	/**
	 * Returns the current colour value of the Shape.
	 */
	public Color getColor();
	
	/**
	 * Sets the current colour of the Shape to the colour given in the argument.
	 */
	public void setColor(Color colour);
	
	/**
	 * Performs a translation so the new coordinate system is with respect to the
	 * x and y values given in the argument.
	 */
	public void translate(int x, int y);
	
	/**
	 * Positions and draws the text string for the shape in the centre of the shape.
	 */
	public void drawCentredText(String text, int x, int y, int width, int height);

	/**
	 * Draws an image
	 */
	public void drawImage(Image img, int x, int y, int width, int height);
}
