package spatial_matrix_display;

/*
 * This is the Main class for the Spatial Matrix Display
 */

public class JavaSpatialMatrixMain {

	public static void main(String[] args) {

		// Initialise Origin and spatial coordinate system, set current device
		// position/orientation to origin
		JavaSpatialMatrix myLocation = new JavaSpatialMatrix(0.0, 0.0, 0.0,
				0.0, 0.0, 0.0);
		DisplayMatrix test = new DisplayMatrix(30, 30);
		test.findTrueLED();
		
		/*
		 * testing crap to see if LEDOutput works
		 * 
		LEDOutput testing = new LEDOutput(0, false, 0, 0, 0, 0);
		testing.Initialise();
		testing.updateLEDStatus();
		 */
		
	}

	// This prints the data values for each axis
	public static void printData(JavaSpatialMatrix positionData) {
		System.out.println("X Value is: " + positionData.xLoc
				+ "\nY Value is: " + positionData.yLoc + "\nZ Value is: "
				+ positionData.zLoc + "\nX Rotation (Deg) is: "
				+ positionData.xAngle + "\nY Rotation (Deg) is: "
				+ positionData.yAngle + "\nZ Rotation (Deg) is: "
				+ positionData.zAngle);
	}

}
