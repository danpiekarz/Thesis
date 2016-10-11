package spatial_matrix_display;

/* 
 * This class will obtain a 2D Matrix from some kind of user input and translate each element into an x,y,z coordinate.
 * It will then populate and send a list containing these coordinates to the JavaSpatialMatrixMain.java
 * 
 */

public class DisplayMatrix {

	// Data Members
	private int xLength, yLength;

	// Constructor

	DisplayMatrix(int x_Length, int y_Length) {

		xLength = x_Length;
		yLength = y_Length;
		/* zLength = z_Length; */
	}

	/*
	 * DisplayMatrix getMatrix(){ if(xLength == 0 || yLength == 0){
	 * System.out.println("The(x_Length=0) or (y_Length=0)");
	 * 
	 * } System.out.println("Passing 2D Matrix object with " + yLength +
	 * " rows and" + xLength + " columns."); return LEDMatrix; }
	 */
	public int getXLength() {
		return xLength;
	}

	public int getYLength() {
		return yLength;
	}

	/*
	 * This method finds all of the true values in a user input matrix and
	 * assigns each true value a coordinate object (TrueLED).
	 */
	public void findTrueLED() {
		boolean[][] LEDMatrix = userInputMatrix();
		for (int i = 0; i < yLength; i++) {
			for (int j = 0; j < xLength; j++) {
				if (LEDMatrix[i][j] == true) {
					TrueLED onLED = new TrueLED(j - xLength, 30 - i);
					System.out.println("True LED at: " + onLED.x + " , "
							+ onLED.y);
				}
			}
		}
	}

	public boolean[][] userInputMatrix() {
		boolean[][] userMatrix = new boolean[yLength][xLength];
		for (int a = 5; a < 20; a++) {
			for (int b = 5; b < 20; b++) {
				userMatrix[a][b] = true;
			}
		}

		return userMatrix;
	}

	public void testMatrix() {
		userInputMatrix()[5][5] = true;

	}

}
