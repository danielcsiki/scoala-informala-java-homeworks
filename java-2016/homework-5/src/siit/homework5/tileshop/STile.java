package siit.homework5.tileshop;

/**
 * Implementation of an S type tile.
 * @author Csiki Daniel.
 *
 */
public class STile {
	/**
	 * Price of tile per square meter.
	 */
	private double price;

	/**
	 * Constructor for an S type tile.
	 * @param price - the price of 1 square meter of S type tile.
	 */
	public STile(double price) {
		this.price = price;
	}

	/**
	 * Calculates the cost to cover a surface with S type tiles.
	 * @param surfaceToCover - the surface that needs to be covered (in square meters).
	 * @return the price to cover the surface with S type tiles.
	 */
	public double calculateCost(double surfaceToCover) {
		return price * surfaceToCover;
	}

}
