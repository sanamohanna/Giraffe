package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Knight;
import model.Location;

public class KnightMoveTest {
	private Knight knight;

	// "setup" method
	@BeforeEach
	public void setUp() {
		knight = new Knight(new Location(0, 0));
	}

	@Test
	//id:9
	//check the case that the input is not legal for level1Move method
	public void level1KnightMoveRRDTest() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			knight.level1Move(Directions.LEFT, Directions.RIGHT, Directions.DOWN, "0", "0");
		});

		assertEquals("illegal Move", exception.getMessage());
	}

	@Test
	//id:10
	//check if the update location is right in case the input is legal for level1Move method 
	public void level1KnightMoveRRUTest() {
		Location actualLocation = knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.UP, "0", "1");
		Location expectedLocation = new Location(2, 0);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	//id:11
	//check if the update location is right in case the input is legal for level2Move method 
	public void level2KnightMoveRRD_RTest() {
		Location actualLocation = knight.level2Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN_RIGHT, "0",
				"0");
		Location expectedLocation = new Location(3, 1);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	//id:1
	//check the specific case that the knight go up of the board ,if the return location is right for method level2Move
	public void level2KnightMoveRRU_RTest() {
		Location actualLocation = knight.level2Move(Directions.RIGHT, Directions.RIGHT, Directions.UP_RIGHT, "0", "0");
		Location expectedLocation = new Location(3, 7);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	//id:12
	//check if the return arraylist of method allValidMovesLevel1 contain all the options
	public void knightAllValidMoveLevel1Test() {
		/*
		 * 0,3 (up up right) 0,1 (up up left ) 1,0 (left left up) 1,4 (right right up)
		 * 3,0 (left left down) 3,4 (right right down) 4,1 (down down left) 4,3 (down
		 * down right)
		 * 
		 */
		Knight knight = new Knight(new Location(2, 2));
		ArrayList<Location> actualLocations = knight.allValidMovesLevel1(knight);
		ArrayList<Location> expectedLocations = new ArrayList<Location>();
		expectedLocations.add(new Location(1, 4));
		expectedLocations.add(new Location(3, 4));
		expectedLocations.add(new Location(1, 0));
		expectedLocations.add(new Location(3, 0));
		expectedLocations.add(new Location(4, 3));
		expectedLocations.add(new Location(4, 1));
		expectedLocations.add(new Location(0, 3));
		expectedLocations.add(new Location(0, 1));
		assertEquals(expectedLocations, actualLocations);
	}

	// reset the knight object to its initial state.
	@AfterEach
	public void tearDown() {
		knight = new Knight(new Location(0, 0));
	}

}
