package spaceshapes;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

public class TestHexagon {

	private Painter _smallHexagonPainter;
	private Painter _largeHexagonPainter;
	
	@Before
	public void setUp() {
		_smallHexagonPainter = new MockPainter();
		_largeHexagonPainter = new MockPainter();
	}

	/*
	 * Test to create two hexagons, one with a width smaller than 20 and one with a
	 * width larger than 20 to ensure that the lines are drawn correctly.
	 */
	@Test
	public void testHexagonFormation() {
		Shape smallHexagon = new HexagonShape(30, 30, 10, 10, 20, 20);
		Shape largeHexagon = new HexagonShape(30, 30, 10, 10, 50, 50);
		
		smallHexagon.paint(_smallHexagonPainter);
		largeHexagon.paint(_largeHexagonPainter);
		assertEquals("(line 30,40,40,30)(line 40,30,50,40)(line 50,40,40,50)"
				+ "(line 40,50,30,40)", _smallHexagonPainter.toString());
		assertEquals("(line 30,55,50,30)(line 50,30,60,30)(line 60,30,80,55)"
				+ "(line 80,55,60,80)(line 60,80,50,80)(line 50,80,30,55)"
				, _largeHexagonPainter.toString());
	}
	
	/*
	 * Test to ensure two hexagons, one with a width smaller than 20 and one with a
	 * width larger than 20 paint themselves correctly after bouncing off the right boundary.
	 */
	@Test
	public void testHexagonBounceOffRight() {
		Shape smallHexagon = new HexagonShape(75, 30, 10, 10, 20, 20);
		Shape largeHexagon = new HexagonShape(45, 45, 10, 10, 50, 50);
		//Test small hexagon
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(100, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(100, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		//Test large hexagon
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(100, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(100, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		assertEquals("(line 75,40,85,30)(line 85,30,95,40)(line 95,40,85,50)(line 85,50,75,40)"
				+ "(line 80,50,90,40)(line 90,40,100,50)(line 100,50,90,60)(line 90,60,80,50)"
				+ "(line 70,60,80,50)(line 80,50,90,60)(line 90,60,80,70)(line 80,70,70,60)", _smallHexagonPainter.toString());
		assertEquals("(line 45,70,65,45)(line 65,45,75,45)(line 75,45,95,70)(line 95,70,75,95)(line 75,95,65,95)(line 65,95,45,70)"
				+ "(line 50,80,70,55)(line 70,55,80,55)(line 80,55,100,80)(line 100,80,80,105)(line 80,105,70,105)(line 70,105,50,80)"
				+ "(line 40,90,60,65)(line 60,65,70,65)(line 70,65,90,90)(line 90,90,70,115)(line 70,115,60,115)(line 60,115,40,90)"
				, _largeHexagonPainter.toString());
	}
	
	/*
	 * Test to ensure two hexagons, one with a width smaller than 20 and one with a
	 * width larger than 20 paint themselves correctly after bouncing off the left boundary.
	 */
	@Test
	public void testHexagonBounceOffLeft() {
		Shape smallHexagon = new HexagonShape(5, 30, -10, 10, 20, 20);
		Shape largeHexagon = new HexagonShape(5, 45, -10, 10, 50, 50);
		//Test small hexagon
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		//Test large hexagon
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		assertEquals("(line 5,40,15,30)(line 15,30,25,40)(line 25,40,15,50)(line 15,50,5,40)"
				+ "(line 0,50,10,40)(line 10,40,20,50)(line 20,50,10,60)(line 10,60,0,50)"
				+ "(line 10,60,20,50)(line 20,50,30,60)(line 30,60,20,70)(line 20,70,10,60)", _smallHexagonPainter.toString());
		assertEquals("(line 5,70,25,45)(line 25,45,35,45)(line 35,45,55,70)(line 55,70,35,95)(line 35,95,25,95)(line 25,95,5,70)"
				+ "(line 0,80,20,55)(line 20,55,30,55)(line 30,55,50,80)(line 50,80,30,105)(line 30,105,20,105)(line 20,105,0,80)"
				+ "(line 10,90,30,65)(line 30,65,40,65)(line 40,65,60,90)(line 60,90,40,115)(line 40,115,30,115)(line 30,115,10,90)"
				, _largeHexagonPainter.toString());
	}
	
	/*
	 * Test to ensure two hexagons, one with a width smaller than 20 and one with a
	 * width larger than 20 paint themselves correctly after bouncing off the ceiling boundary.
	 */
	@Test
	public void testHexagonBounceOffCeiling() {
		Shape smallHexagon = new HexagonShape(35, 5, 10, -10, 20, 20);
		Shape largeHexagon = new HexagonShape(35, 5, 10, -10, 50, 50);
		//Test small hexagon
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 10000);
		smallHexagon.paint(_smallHexagonPainter);
		//Test large hexagon
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 10000);
		largeHexagon.paint(_largeHexagonPainter);
		assertEquals("(line 35,15,45,5)(line 45,5,55,15)(line 55,15,45,25)(line 45,25,35,15)"
				+ "(line 45,10,55,0)(line 55,0,65,10)(line 65,10,55,20)(line 55,20,45,10)"
				+ "(line 55,20,65,10)(line 65,10,75,20)(line 75,20,65,30)(line 65,30,55,20)", _smallHexagonPainter.toString());
		assertEquals("(line 35,30,55,5)(line 55,5,65,5)(line 65,5,85,30)(line 85,30,65,55)(line 65,55,55,55)(line 55,55,35,30)"
				+ "(line 45,25,65,0)(line 65,0,75,0)(line 75,0,95,25)(line 95,25,75,50)(line 75,50,65,50)(line 65,50,45,25)"
				+ "(line 55,35,75,10)(line 75,10,85,10)(line 85,10,105,35)(line 105,35,85,60)(line 85,60,75,60)(line 75,60,55,35)"
				, _largeHexagonPainter.toString());
	}
	
	/*
	 * Test to ensure two hexagons, one with a width smaller than 20 and one with a
	 * width larger than 20 paint themselves correctly after bouncing off the floor boundary.
	 */
	@Test
	public void testHexagonBounceOffFloor() {
		Shape smallHexagon = new HexagonShape(35, 75, 10, 10, 20, 20);
		Shape largeHexagon = new HexagonShape(35, 45, 10, 10, 50, 50);
		//Test small hexagon
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 100);
		smallHexagon.paint(_smallHexagonPainter);
		smallHexagon.move(10000, 100);
		smallHexagon.paint(_smallHexagonPainter);
		//Test large hexagon
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 100);
		largeHexagon.paint(_largeHexagonPainter);
		largeHexagon.move(10000, 100);
		largeHexagon.paint(_largeHexagonPainter);
		assertEquals("(line 35,85,45,75)(line 45,75,55,85)(line 55,85,45,95)(line 45,95,35,85)"
				+ "(line 45,90,55,80)(line 55,80,65,90)(line 65,90,55,100)(line 55,100,45,90)"
				+ "(line 55,80,65,70)(line 65,70,75,80)(line 75,80,65,90)(line 65,90,55,80)", _smallHexagonPainter.toString());
		assertEquals("(line 35,70,55,45)(line 55,45,65,45)(line 65,45,85,70)(line 85,70,65,95)(line 65,95,55,95)(line 55,95,35,70)"
				+ "(line 45,75,65,50)(line 65,50,75,50)(line 75,50,95,75)(line 95,75,75,100)(line 75,100,65,100)(line 65,100,45,75)"
				+ "(line 55,65,75,40)(line 75,40,85,40)(line 85,40,105,65)(line 105,65,85,90)(line 85,90,75,90)(line 75,90,55,65)"
				, _largeHexagonPainter.toString());
	}
	
	
}
