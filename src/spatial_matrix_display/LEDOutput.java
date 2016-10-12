package spatial_matrix_display;

import java.util.Arrays;

public class LEDOutput extends Thread {

	public int ledNumber, noOfLEDS = 30;
	public boolean ledStatus;
	public double myLedx, myLedy, myLedz, ledDistance;

	public LEDOutput[] myLEDArray;
	public JavaSpatialMatrix myLocation;
	public String[] outputToLEDS = new String[noOfLEDS];

	LEDOutput(int ledNumber, boolean ledStatus, double ledDistance, double myLedx, double myLedy, double myLedz) {
		this.ledNumber = ledNumber;
		this.ledStatus = ledStatus;
		this.ledDistance = ledDistance;
		this.myLedx = myLedx;
		this.myLedy = myLedy;
		this.myLedz = myLedz;
	}

	/*
	 * Initializes the LED Array and gives each LED it's own X-Y-Z coordinate,
	 * starting at x,y,z = 0; It then determines the distance of the LED from
	 * the origin by calculating distanceBetweenLEDS*ledNumber.
	 * 
	 * It then creates an array, storing all of the LED objects holding their
	 * own coordinates It will run in a thread which will be used to compare
	 * this array of LED objects to an array of TrueLED Objects
	 */
	public void Initialise() {
		ledNumber = 0;
		myLEDArray = new LEDOutput[noOfLEDS];
		for (int i = 0; i < noOfLEDS; i++) {
			myLEDArray[i] = new LEDOutput(i, false, (JavaSpatialMatrixMain.distanceBetweenLEDS * i), 0, 0, 0);
			System.out.print("\n ledDistance: " + myLEDArray[i].ledDistance);
		}
	}

	public void checkProximityToNode() {
		for (int i = 0; i < noOfLEDS; i++) {
			for (int j = 0; j < JavaSpatialMatrixMain.trueLEDArray.length; j++) {
				if (((Math.abs(myLEDArray[i].myLedx
						- JavaSpatialMatrixMain.trueLEDArray[j].x)) < JavaSpatialMatrixMain.resolutionFactor)
						&& (Math.abs(myLEDArray[i].myLedy
								- JavaSpatialMatrixMain.trueLEDArray[j].y)) < JavaSpatialMatrixMain.resolutionFactor) {
					myLEDArray[i].ledStatus = true;
					double x = Math.abs(myLEDArray[i].myLedx - JavaSpatialMatrixMain.trueLEDArray[j].x);
					double y = Math.abs(myLEDArray[i].myLedy - JavaSpatialMatrixMain.trueLEDArray[j].y);
					System.out.print("\nX, Y Distance from node: " + x + ", " + y);
					break;
				}
				{
					myLEDArray[i].ledStatus = false;
				}
			}

		}
	}

	public void updateDeviceLocation() {
		myLocation = JavaSpatialMatrixMain.device;
		for (int i = 0; i < noOfLEDS; i++) {
			myLEDArray[i].myLedx = (myLocation.getXLoc()
					+ (myLEDArray[i].ledDistance * Math.sin(Math.toRadians(myLocation.getZAngle()))));
			myLEDArray[i].myLedy = (myLocation.getYLoc()
					+ (myLEDArray[i].ledDistance * Math.cos(Math.toRadians(myLocation.getZAngle()))));
			System.out.print(
					"\n myLEDArray[" + i + "].myLedx, y : " + myLEDArray[i].myLedx + ", " + myLEDArray[i].myLedy);
		}

	}

	public void updateLEDStatus() {
		
		for (int i = 0; i < noOfLEDS; i++) {
			outputToLEDS[i] = JavaSpatialMatrixMain.convertBooleanToNumeral(myLEDArray[i].ledStatus);
		}
		System.out.print("\nThe result of outputToLEDS is: " + Arrays.toString(outputToLEDS));
	}

}
