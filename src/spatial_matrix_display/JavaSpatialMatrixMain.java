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
		DisplayMatrix test = new DisplayMatrix(29, 29);
		test.findTrueLED();

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
