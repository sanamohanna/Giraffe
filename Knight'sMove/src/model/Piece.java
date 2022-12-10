package model;

//import java.util.ArrayList;
import java.util.Objects;

import Enum.Directions;

//2another check
public class Piece {

	private Location location;

	public Piece(Location location) {
		super();
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(location, other.location);
	}

	/* stright method make the pieces move straightly , UP , DOWN , LEFT OR RIGHT */
	/* the location of the piece will change according to the move type */
	public void StrightMove(Directions dir) {
		switch (dir) {
		/* here is the location changes in case the piece moved up */
		/*
		 * in case the piece is on the last square of the board sides , it goes to the
		 * first square in the same line
		 */
		case UP: {
			if (this.getLocation().getY() == 0) {
				this.getLocation().setY(7);
			} else {
				this.getLocation().setY(this.location.getY() - 1);
			}
			break;
		}
		/* here is the location changes in case the piece moved down */
		case DOWN: {

			if (this.getLocation().getY() == 7) {
				this.getLocation().setY(0);
			} else {
				this.getLocation().setY(this.location.getY() + 1);
			}
			break;
		}
		/* here is the location changes in case the piece moved right */
		case RIGHT: {
			if (this.getLocation().getX() == 7) {
				this.getLocation().setX(0);
			} else {
				this.getLocation().setY(this.location.getX() + 1);
			}
			break;
		}
		/* here is the location changes in case the piece moved left */
		case LEFT: {
			if (this.getLocation().getX() == 0) {
				this.getLocation().setX(7);
			} else {
				this.getLocation().setX(this.location.getX() - 1);
			}
			break;
		}
		default:
			break;
		}
	}

	/* the pieces can move diagonally , so here is the method that do this */
	public void DiagonallyMove(Directions dir) {
		/* the diffrent cases it's about the direction that the slant goes */
		/*
		 * in case the piece is on the last square of the board sides , it goes to the
		 * first square in the same line
		 */
		switch (dir) {
		case UP_LEFT: {
			if (this.location.getX() == 0 && this.location.getY() > 0) {
				this.location.setX(7);
				this.location.setY((this.location.getY()) - 1);
			} else if (this.location.getY() == 0) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.location.setX(this.location.getX() - 1);
				this.location.setY((this.location.getY()) - 1);
			}
			break;

		}
		case UP_RIGHT: {
			if (this.location.getX() == 7 && this.location.getY() > 0) {
				this.location.setX(0);
				this.location.setY((this.location.getY()) - 1);
			} else if (this.location.getY() == 0) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.location.setX(this.location.getX() + 1);
				this.location.setY((this.location.getY()) - 1);
			}
			break;
		}
		// ?????
		case DOWN_LEFT: {
			if (this.location.getX() == 0 && this.location.getY() < 7) {
				this.location.setX(7);
				this.location.setY((this.location.getY()) + 1);
			} else if (this.location.getY() == 7) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.location.setX(this.location.getX() - 1);
				this.location.setY((this.location.getY()) + 1);
			}
			break;
		}
		case DOWN_RIGHT: {
			if (this.location.getX() == 7 && this.location.getY() < 7) {
				this.location.setX(0);
				this.location.setY((this.location.getY()) + 1);
			} else if (this.location.getY() == 7) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.location.setX(this.location.getX() + 1);
				this.location.setY((this.location.getY()) + 1);
			}
			break;
		}
		default:
			break;

		}
	}

}
