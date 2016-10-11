package spatial_matrix_display;

import java.util.ArrayList;

/* 
 * This class will obtain a 2D Matrix from some kind of user input and translate each element into an x,y,z coordinate.
 * It will then populate and send a list containing these coordinates to the JavaSpatialMatrixMain.java
 * 
 */

public class DisplayMatrix {

	// Data Members
	private static int xLength, yLength;
	public static TrueLED[] trueLEDArray;
	public static ArrayList<TrueLED> trueLEDList;

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
	 * This method is used to take an input from the user in the form of a 2D
	 * Boolean Matrix
	 * 
	 * NOTE: At this point in time, since I have not configured a mode of input
	 * as of yet, this is a testing-only method which will return a 30x30 2D
	 * Matrix a Filled Square of size 15x15 within the center of the 30x30
	 * matrix are allocated ON_NODES
	 */
	public static boolean[][] userInputMatrix() {
		boolean[][] userMatrix = new boolean[yLength][xLength];
		for (int a = 5; a < 20; a++) {
			for (int b = 5; b < 20; b++) {
				userMatrix[a][b] = true;
			}
		}

		return userMatrix;
	}

	/*
	 * This method finds all of the true values in a user input matrix and
	 * assigns each true value a coordinate object (TrueLED). These objects are
	 * then placed in an array so that they can be compared with myLEDArray
	 */
	public static void findTrueLED() {
		trueLEDList = new ArrayList<TrueLED>();
		boolean[][] LEDMatrix = userInputMatrix();
		for (int i = 0; i < yLength; i++) {
			for (int j = 0; j < xLength; j++) {
				if (LEDMatrix[i][j] == true) {
					TrueLED onLED = new TrueLED(j - xLength, 30 - i);
					trueLEDList.add(onLED);
				}
			}
		}
		trueLEDArray = new TrueLED[trueLEDList.size()];
		trueLEDList.toArray(trueLEDArray);
		System.out.print("Amount of objects in trueLEDList = " + trueLEDList.size()
				+ "\nAmount of objects in trueLEDArray = " + trueLEDArray.length);
	}

	public static TrueLED[] returnTrueLEDArray() {
		return (trueLEDArray);
	}

}
