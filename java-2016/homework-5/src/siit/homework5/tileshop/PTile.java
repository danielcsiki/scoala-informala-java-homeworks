package siit.homework5.tileshop;

/**
 * Implementation of a P type tile.
 * 
 * @author Csiki Daniel.
 *
 */

public class PTile {
	/** The length of the tile(in cm) */
	double length;
	/** The with of the tile (in cm)*/
	double width;
	/** The the price of 1 unit of tile */
	double price;

	/**
	 * Constructor for a P type tile.
	 * 
	 * @param length
	 *            The length of the tile
	 * @param width
	 *            The with of the tile
	 * @param price
	 *            The the price of 1 unit of tile
	 */
	public PTile(double length, double width, double price) {
		this.length = length;
		this.width = width;
		this.price = price;
	}

	/**
	 * Converts the area of 1 tile in square meters.
	 * 
	 * @return the area of 1 tile in square meters.
	 */
	private double areaOfTileInMeters() {
		return width * length * 0.0001;
	}

	/**
	 * Calculates the cost to cover a surface with P type tiles.
	 * 
	 * @param surfaceToCover
	 *            the surface to cover in square meters.
	 * @return return the price to cover a surface with P type tiles.
	 */
	public double calculateCost(double surfaceToCover) {
		return surfaceToCover / (areaOfTileInMeters()) * price;
	}

}
