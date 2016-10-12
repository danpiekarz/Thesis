package spatial_matrix_display;

import java.util.Arrays;

/*
 * This is the Main class for the Spatial Matrix Display
 */

public class JavaSpatialMatrixMain {

	public static int yLength = 30;
	public static int xLength = 30;
	public static double distanceBetweenLEDS = 1.67;
	public static double resolutionFactor = (distanceBetweenLEDS*0.4);// 1.67 *0.4 = 0.668
	public static boolean[][] messageToDisplay = new boolean[yLength][xLength];
	public static JavaSpatialMatrix device = new JavaSpatialMatrix(0, 0, 0, 0, 0, 0);
	public static DisplayMatrix outputMatrix = new DisplayMatrix(xLength, yLength);
	public static LEDOutput ledArray = new LEDOutput(0, false, 0, 0, 0, 0);
	public static TrueLED[] trueLEDArray;
	
	public static void main(String[] args) {

		/*
		 * The main entry point of the program. A configuration file will be
		 * used as an argument when running the program, allowing for quick
		 * testing of parameters and boundaries
		 */
		device.initialiseOrigin();
		DisplayMatrix.findTrueLED();
		messageToDisplay = DisplayMatrix.userInputMatrix();
		trueLEDArray = DisplayMatrix.returnTrueLEDArray();
		System.out.print("\n The contents of messageToDisplay are: \n");
		printOutputMatrix();
		System.out.print("\n\n The locations of nodes in the matrix are: \n");
		printOutputMatrixLocations();
		

		
		ledArray.Initialise();
		while (true) {
			device.setXLoc();
			device.setYLoc();
			device.setZAngle();
			printData(device);
			DisplayMatrix.printNodeData();
			
			final long startTime = System.currentTimeMillis();
			ledArray.updateDeviceLocation();
			ledArray.checkProximityToNode();
			ledArray.updateLEDStatus();
			final long endTime = System.currentTimeMillis();
			System.out.println("\nTotal execution time: " + (endTime - startTime) );
		}
	}

	// This prints the data values for each axis
	public static void printData(JavaSpatialMatrix positionData) {
		System.out.println("X Value is: " + positionData.xLoc + "\nY Value is: " + positionData.yLoc + "\nZ Value is: "
				+ positionData.zLoc + "\nX Rotation (Deg) is: " + positionData.xAngle + "\nY Rotation (Deg) is: "
				+ positionData.yAngle + "\nZ Rotation (Deg) is: " + positionData.zAngle);
	}

	public static void printOutputMatrix() {
		String[] singleDimArray = new String[xLength];
		for (int i = 0; i < yLength; i++) {
			for (int j = 0; j < xLength; j++) {
				singleDimArray[j] = convertBooleanToNumeral(messageToDisplay[i][j]);
			}
			System.out.println("\n" + Arrays.toString(singleDimArray));
		}
	}
	
	public static void printOutputMatrixLocations() {
		String[] singleDimArray = new String[xLength];
		int count = 0;
		for (int i = 0; i < yLength; i++) {
			for (int j = 0; j < xLength; j++) {
				singleDimArray[j] = convertBooleanMatrixToNumeral(messageToDisplay[i][j], trueLEDArray[count]);
				if(messageToDisplay[i][j] == true && count < trueLEDArray.length-1){
					count++;
				}
				
			}
			System.out.println("\n" + Arrays.toString(singleDimArray));
		}
	}

	public static String convertBooleanToNumeral(Boolean boolVal){
		if (boolVal.booleanValue() == true) {
			return "1";
		}
		return "0";
	}
	
	public static String convertBooleanMatrixToNumeral(Boolean boolVal, TrueLED onNode){
		if (boolVal.booleanValue() == true) {
			return String.format("(%.2f, %.2f)", onNode.x, onNode.y);
		}
		return "0";
	}
}
