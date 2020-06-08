package spaceshapes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.FontMetrics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;
	private FontMetrics _fontMetrics;
	private int _offset;
	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setFont(FONT);
		_fontMetrics = _g.getFontMetrics(FONT);
		_offset = (_fontMetrics.getAscent() - _fontMetrics.getDescent())/2 ;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes1.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
		
	}

	/**
	 * @see spaceshapes1.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width+1, height+1);
	}

	@Override
	public Color getColor() {
		return _g.getColor();
	}

	@Override
	public void setColor(Color colour) {
		_g.setColor(colour);
	}
	
	@Override
	public void translate(int x, int y) {
		_g.translate(x, y);
	}

	@Override
	public void drawCentredText(String text, int x, int y, int width, int height) {
		
		int textLength = (int)_fontMetrics.getStringBounds(text, _g).getWidth();
		int xOffset = (width - textLength)/2;
		_g.drawString(text, x+xOffset, y+(height/2)+_offset);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		_g.fillOval(x, y, width+1, height+1);
	}

	@Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int numberOfPoints) {
		_g.fillPolygon(xPoints, yPoints, numberOfPoints);
	}

	@Override
	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
		
	}
}
