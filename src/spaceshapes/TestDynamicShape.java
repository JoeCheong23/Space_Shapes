package spaceshapes;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

public class TestDynamicShape {
	
	private Painter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour appropriately
	 * to the default white colour before and after filling the shape when bouncing off the right-most boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightNoColourSpecified() {
		Shape defaultColouredRect = new DynamicShape(50,60,10,20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(80, 10000);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(80, 10000);
		defaultColouredRect.paint(_painter);
		assertEquals("(rectangle 50,60,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 55,80,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 45,100,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])", _painter.toString());
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour to the selected colour
	 * appropriately before and after filling the shape when bouncing off the right-most boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightWithColourSpecified() {
		Shape cyanColouredRect = new DynamicShape(50,60,10,20,Color.CYAN);
		//Testing cyanColouredRect (fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(80, 10000);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(80, 10000);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 50,60,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 55,80,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 45,100,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])", _painter.toString());
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour 
	 * to the default colour appropriately before and after filling the shape 
	 * when bouncing off the left-most boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftNoColourSpecified() {
		Shape defaultColouredRect = new DynamicShape(30,60,-40,20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(100, 10000);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(100, 10000);
		defaultColouredRect.paint(_painter);
		
		assertEquals("(rectangle 30,60,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 0,80,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 40,100,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])", _painter.toString());
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour 
	 * to the selected colour appropriately before and after filling the shape when bouncing off the left-most boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftWithColourSpecified() {
		Shape cyanColouredRect = new DynamicShape(30,60,-40,20,Color.CYAN);
		//fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(100, 10000);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(100, 10000);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 30,60,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 0,80,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 40,100,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])", _painter.toString());
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour appropriately
	 * (in this case, it does not change colour or fill the shape at all) when bouncing off the 
	 * ceiling boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffCeiling() {
		Shape defaultColouredRect = new DynamicShape(30,10,40,-20);
		Shape cyanColouredRect = new DynamicShape(30,10,40,-20,Color.CYAN);
		//Testing default coloured rectangle (fyi: white is java.awt.Color[r=255,g=255,b=255])
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(10000, 100);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(10000, 100);
		defaultColouredRect.paint(_painter);
		//Testing cyanColouredRect (fyi: cyan is java.awt.Color[r=0,g=255,b=255])
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(10000, 100);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(10000, 100);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 30,10,25,35)(rectangle 70,0,25,35)"
				+ "(rectangle 110,20,25,35)(rectangle 30,10,25,35)"
				+ "(rectangle 70,0,25,35)(rectangle 110,20,25,35)", _painter.toString());
	}
	
	/*
	 * Test to ensure that the DynamicShape object renders itself and sets the colour appropriately
	 * (in this case, it does not change colour or fill the shape at all) when bouncing off the 
	 * floor boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffFloor() {
		Shape defaultColouredRect = new DynamicShape(30,60,40,20);
		Shape cyanColouredRect = new DynamicShape(30,60,40,20,Color.CYAN);
		//Testing default coloured rectangle (fyi: white is java.awt.Color[r=255,g=255,b=255])
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(10000, 100);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(10000, 100);
		defaultColouredRect.paint(_painter);
		//Testing cyanColouredRect (fyi: cyan is java.awt.Color[r=0,g=255,b=255])
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(10000, 100);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(10000, 100);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 30,60,25,35)(rectangle 70,65,25,35)"
				+ "(rectangle 110,45,25,35)(rectangle 30,60,25,35)"
				+ "(rectangle 70,65,25,35)(rectangle 110,45,25,35)", _painter.toString());
	}
	
	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour to 
	 * the default colour appropriately after bouncing off the right-most boundary, 
	 * and then the floor boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightThenFloorNoColourSpecified() {
		Shape defaultColouredRect = new DynamicShape(100,60,20,20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		assertEquals("(rectangle 100,60,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 115,80,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 95,100,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(rectangle 75,115,25,35)"
				+ "(rectangle 55,95,25,35)", _painter.toString());
	}
	
	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour 
	 * appropriately to the selected colour after bouncing off the right-most boundary, 
	 * and then the floor boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightThenFloorWithSpecifiedColour() {
		Shape cyanColouredRect = new DynamicShape(100,60,20,20,Color.CYAN);
		//fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 100,60,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 115,80,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 95,100,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(rectangle 75,115,25,35)(rectangle 55,95,25,35)", _painter.toString());
	}
	
	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the default colour after bouncing off the left-most boundary, and then the floor boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftThenFloorNoSpecifiedColour() {
		Shape defaultColouredRect = new DynamicShape(10,60,-20,20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		assertEquals("(rectangle 10,60,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 0,80,25,35,java.awt.Color[r=255,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=255,g=255,b=255])(filled 20,100,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(rectangle 40,115,25,35)(rectangle 60,95,25,35)", _painter.toString());
	}
	
	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the specified colour after bouncing off the left-most boundary, and then the floor boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftThenFloorWithSpecifiedColour() {
		Shape cyanColouredRect = new DynamicShape(10,60,-20,20,Color.CYAN);
		//fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 10,60,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 0,80,25,35,java.awt.Color[r=0,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=0,g=255,b=255])(filled 20,100,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(rectangle 40,115,25,35)(rectangle 60,95,25,35)", _painter.toString());
	}
	

	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the default colour after bouncing off the right-most boundary, and then the ceiling boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightThenCeilingNoColourSpecified() {
		Shape defaultColouredRect = new DynamicShape(100,50,20,-20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		assertEquals("(rectangle 100,50,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 115,30,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 95,10,25,35,java.awt.Color[r=255,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(rectangle 75,0,25,35)(rectangle 55,20,25,35)", _painter.toString());
	}
	

	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the specified colour after bouncing off the right-most boundary, and then the ceiling boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffRightThenCeilingWithSpecifiedColour() {
		Shape cyanColouredRect = new DynamicShape(100,50,20,-20,Color.CYAN);
		//Testing default coloured rectangle (fyi: white is java.awt.Color[r=255,g=255,b=255]
		//fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 100,50,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 115,30,25,35,java.awt.Color[r=0,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=0,g=255,b=255])(filled 95,10,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(rectangle 75,0,25,35)(rectangle 55,20,25,35)", _painter.toString());
	}
	

	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the default colour after bouncing off the left-most boundary, and then the ceiling boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftThenCeilingNoColourSpecified() {
		Shape defaultColouredRect = new DynamicShape(10,50,-20,-20);
		//fyi: white is java.awt.Color[r=255,g=255,b=255]
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		defaultColouredRect.move(140, 150);
		defaultColouredRect.paint(_painter);
		assertEquals("(rectangle 10,50,25,35)(Set colour to java.awt.Color[r=255,g=255,b=255])"
				+ "(filled 0,30,25,35,java.awt.Color[r=255,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(Set colour to java.awt.Color[r=255,g=255,b=255])(filled 20,10,25,35,java.awt.Color[r=255,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(rectangle 40,0,25,35)"
				+ "(rectangle 60,20,25,35)", _painter.toString());
	}
	

	/*
	 * Test to ensure that the Dynamic Shape object renders itself and sets the colour appropriately
	 * to the specified colour after bouncing off the left-most boundary, and then the ceiling boundary.
	 */
	@Test
	public void testDynamicShapeWithBounceOffLeftThenCeilingWithSpecifiedColour() {
		Shape cyanColouredRect = new DynamicShape(10,50,-20,-20,Color.CYAN);
		//fyi: cyan is java.awt.Color[r=0,g=255,b=255]
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		cyanColouredRect.move(140, 150);
		cyanColouredRect.paint(_painter);
		assertEquals("(rectangle 10,50,25,35)(Set colour to java.awt.Color[r=0,g=255,b=255])(filled 0,30,25,35,java.awt.Color[r=0,g=255,b=255])"
				+ "(Set colour to java.awt.Color[r=212,g=212,b=212])(Set colour to java.awt.Color[r=0,g=255,b=255])"
				+ "(filled 20,10,25,35,java.awt.Color[r=0,g=255,b=255])(Set colour to java.awt.Color[r=212,g=212,b=212])"
				+ "(rectangle 40,0,25,35)(rectangle 60,20,25,35)", _painter.toString());
	}
	
	
}
