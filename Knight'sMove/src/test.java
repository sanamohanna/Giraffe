import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Knight;
import model.Location;

class test {


	@Test
	void Level1KnightMoveRightRightDownTest() {
		
		Knight knight = new Knight();
		
		knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN);
		Location locationExpected1 = new Location(2,1);
		System.out.println(knight.getLocation()+ " test 1");
		assertEquals(locationExpected1,knight.getLocation());
	}
//	@Test
//	void Level1KnightMoveRightRightUpTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.UP);
//		Location locationExpected1 = new Location(2,7);
//		System.out.println(knight.getLocation()+" test 2");
//		assertEquals(locationExpected1,knight.getLocation());
//	}
//	@Test
//	void Level1KnightMoveLeftLeftUpTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.LEFT, Directions.LEFT, Directions.UP);
//		Location locationExpected1 = new Location(6,7);
//		System.out.println(knight.getLocation()+" test 3");
//		assertEquals(locationExpected1,knight.getLocation());
//		
//	}
//	@Test
//	void  Level1KnightMoveLeftLeftDownTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.LEFT, Directions.LEFT, Directions.DOWN);
//		Location locationExpected1 = new Location(6,1);
//		System.out.println(knight.getLocation()+" test 4");
//		assertEquals(locationExpected1,knight.getLocation());		
//	}
//	@Test
//	void  Level1KnightMoveDownDownLeftTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.DOWN, Directions.DOWN, Directions.LEFT);
//		Location locationExpected1 = new Location(7,2);
//		System.out.println(knight.getLocation()+" test 5");
//		assertEquals(locationExpected1,knight.getLocation());		
//	}
//	@Test
//	void  Level1KnightMoveDownDownRightTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.DOWN, Directions.DOWN, Directions.RIGHT);
//		Location locationExpected1 = new Location(1,2);
//		System.out.println(knight.getLocation()+" test 6");
//		assertEquals(locationExpected1,knight.getLocation());		
//	}
//	@Test
//	void  Level1KnightMoveUpUpLeftTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.UP, Directions.UP, Directions.LEFT);
//		Location locationExpected1 = new Location(7,6);
//		System.out.println(knight.getLocation()+" test 7");
//		assertEquals(locationExpected1,knight.getLocation());		
//	}
//	@Test
//	void  Level1KnightMoveUpUpRightTest() {
//		Knight knight = new Knight(false);
//		knight.level1Move(Directions.UP, Directions.UP, Directions.RIGHT);
//		Location locationExpected1 = new Location(1,6);
//		System.out.println(knight.getLocation()+" test 8");
//		assertEquals(locationExpected1,knight.getLocation());		
//	}

}
