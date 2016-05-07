package siit.homework5.tileshop;

public class Main {

	public static void main(String[] args) {

		double surfaceToCoverInMeters = 40;
		STile sTile = new STile(160);
		PTile pTile = new PTile(30, 20, 19.90);
		PTTile ptTile = new PTTile(20, 35);

		double sCost = sTile.calculateCost(surfaceToCoverInMeters);
		double pCost = pTile.calculateCost(surfaceToCoverInMeters);
		double ptCost = ptTile.calculateCost(surfaceToCoverInMeters);
		double splitCost = calculateSplitCost(surfaceToCoverInMeters, sTile, pTile);

		System.out.println("Price to cover surface with S type tiles: " + sCost);
		System.out.println("Price to cover surface with P type tiles: " + pCost);
		System.out.println("Price to cover surface with PT type tiles: " + ptCost);
		System.out.println("Price to cover surface with P type tiles and S tupe tyles (50% + 50%): " + splitCost);

	}

	/**
	 * Calculates the cost to cover a surface with P type and S type tiles
	 * (50-50%)
	 * 
	 * @param surfaceToCoverInMeters
	 *            the surface that needs to be covered.
	 * @param sTile
	 *            instance of STile
	 * @param pTile
	 *            instance of PTile.
	 * @return returns the cost to cover a surface with S and P type tiles.
	 */
	private static double calculateSplitCost(double surfaceToCoverInMeters, Object sTile, Object pTile) {

		return ((((PTile) pTile).calculateCost(surfaceToCoverInMeters)
				+ ((STile) sTile).calculateCost(surfaceToCoverInMeters)) / 2);
	}

}
