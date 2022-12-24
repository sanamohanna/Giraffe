package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Knight;
import model.Location;

class KnightMoveTest {

	@Test
	void test() {
		Knight knight = new Knight(new Location(0, 0));
		Location c = knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN, "0", "0");
		Location locationExpected1 = new Location(2, 2);
		assertEquals(locationExpected1, c);
	}

}
