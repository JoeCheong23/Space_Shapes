package spaceshapes;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape, RectangleShape and OvalShape.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class TestShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
		
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		Shape rectangleShape = new RectangleShape(100, 20, 12, 15);
		Shape ovalShape = new OvalShape(50, 40, 10, 20);
		//Test rectangles
		rectangleShape.paint(_painter);
		rectangleShape.move(500, 500);
		rectangleShape.paint(_painter);
		//Test ovals
		ovalShape.paint(_painter);
		ovalShape.move(500, 500);
		ovalShape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)"
				+ "(oval 50,40,25,35)(oval 60,60,25,35)", _painter.toString());
	}
	
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		Shape rectangleShape = new RectangleShape(100, 20, 12, 15);
		Shape ovalShape = new OvalShape(50, 40, 10, 20);
		//Testing rectangles
		rectangleShape.paint(_painter);
		rectangleShape.move(135, 10000);
		rectangleShape.paint(_painter);
		rectangleShape.move(135, 10000);
		rectangleShape.paint(_painter);
		//Testing ovals
		ovalShape.paint(_painter);
		ovalShape.move(60, 10000);
		ovalShape.paint(_painter);
		ovalShape.move(60, 10000);
		ovalShape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)(oval 50,40,25,35)"
				+ "(oval 35,60,25,35)(oval 25,80,25,35)", _painter.toString());
	}
	

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		Shape rectangleShape = new RectangleShape(10, 20, -12, 15);
		Shape ovalShape = new OvalShape(5, 40, -10, 20);
		//Test rectangles
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 10000);
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 10000);
		rectangleShape.paint(_painter);
		//Test ovals
		ovalShape.paint(_painter);
		ovalShape.move(10000, 10000);
		ovalShape.paint(_painter);
		ovalShape.move(10000, 10000);
		ovalShape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)(oval 5,40,25,35)"
				+ "(oval 0,60,25,35)(oval 10,80,25,35)", _painter.toString());
	}
	
	
	/*
	 * Test to perform a bounce movement off the top boundary and to ensure that the 
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffCeiling() {
		Shape rectangleShape = new RectangleShape(100, 20, -12, -25);
		Shape ovalShape = new OvalShape(50, 10, -10, -20);
		//Test rectangles
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 10000);
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 10000);
		rectangleShape.paint(_painter);
		//Test ovals
		ovalShape.paint(_painter);
		ovalShape.move(10000, 10000);
		ovalShape.paint(_painter);
		ovalShape.move(10000, 10000);
		ovalShape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 88,0,25,35)(rectangle 76,25,25,35)"
				+ "(oval 50,10,25,35)(oval 40,0,25,35)(oval 30,20,25,35)", _painter.toString());
	}
	
	/*
	 * Test to perform a bounce movement off the bottom boundary and to ensure
	 * that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffFloor() {
		Shape rectangleShape = new RectangleShape(100, 55, -12, 25);
		Shape ovalShape = new OvalShape(50, 60, -10, 20);
		//Test rectangles
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 100);
		rectangleShape.paint(_painter);
		rectangleShape.move(10000, 100);
		rectangleShape.paint(_painter);
		//Test ovals
		ovalShape.paint(_painter);
		ovalShape.move(10000, 100);
		ovalShape.paint(_painter);
		ovalShape.move(10000, 100);
		ovalShape.paint(_painter);
		assertEquals("(rectangle 100,55,25,35)(rectangle 88,65,25,35)(rectangle 76,40,25,35)"
				+ "(oval 50,60,25,35)(oval 40,65,25,35)(oval 30,45,25,35)", _painter.toString());
	}
	
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		Shape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", _painter.toString());
	}
	
	/**
	 * Test to check if the text is painted correctly on the Shape.
	 */
	@Test
	public void testShapeWithText() {
		Shape shape = new RectangleShape(10, 90, 12, 15);
		shape.addText("Hello");
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(Set colour to java.awt.Color[r=0,g=0,b=255])(filled 10,90,25,35,java.awt.Color[r=0,g=0,b=255])"
				+ "(Set colour to java.awt.Color[r=255,g=255,b=255])(Text added)"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(Set colour to java.awt.Color[r=0,g=0,b=255])"
				+ "(filled 22,105,25,35,java.awt.Color[r=0,g=0,b=255])(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(Text added)(Set colour to java.awt.Color[r=212,g=212,b=212])", _painter.toString());
		
	}
}
