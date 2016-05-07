package siit.homework5.tileshop;

public class PTTile {
	/** The leg length of the tile (in cm) */
	double legLength;
	/** The price of 1 unit of tile. */
	double price;

	/**
	 * Constructor for a PT type tile.
	 * 
	 * @param legLength
	 * @param price
	 */
	public PTTile(double legLength, double price) {
		this.legLength = legLength;
		this.price = price;
	}

	/**
	 * Calculates the cost to cover a surface with PT type tiles.
	 * 
	 * @param surfaceToCover
	 *            the surface to cover in square meters.
	 * @return the price to cover a surface with P type tiles.
	 */
	public double calculateCost(double surfaceToCover) {
		return surfaceToCover / (legLength * legLength / 2 * 0.0001) * price;
	}

}
