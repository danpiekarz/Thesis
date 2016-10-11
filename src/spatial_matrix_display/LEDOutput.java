package spatial_matrix_display;

public class LEDOutput extends Thread {

	public int ledNumber, noOfLeds = 30;
	public boolean ledStatus;
	public double myLedx, myLedy, myLedz, ledDistance;
	final double distanceBetweenLEDS = 1.67;

	LEDOutput[] myLEDArray;
	JavaSpatialMatrix myLocation;

	private LEDOutput(int ledNumber) {
		ledNumber = this.ledNumber;
		ledStatus = false;
		ledDistance = (ledNumber * distanceBetweenLEDS);
		myLedx = 0;
		myLedy = 0;
		myLedz = 0;
	}

	/*
	 * Initializes the LED Array and gives each LED it's own X-Y-Z coordinate,
	 * starting at x,y,z = 0; It then determines the distance of the LED from
	 * the origin by calculating distanceBetweenLEDS*ledNumber.
	 * 
	 * It then creates an array, storing all of the LED objects holding their own coordinates
	 * It will run in a thread which will be used to compare this array of LED objects
	 * to an array of TrueLED Objects
	 */
	void Initialise() {
		ledNumber = 0;
		myLEDArray = new LEDOutput[noOfLeds];
		while (ledNumber < noOfLeds) {
			myLEDArray[ledNumber] = new LEDOutput(ledNumber);
			ledNumber++;
		}
	}

	public synchronized void getRealTimeLocation() {
		myLocation.getPosition();
		for (int i = 0; i < noOfLeds; i++) {
			updateDeviceLocation(myLEDArray[i]);
		}
	}

	public void updateDeviceLocation(LEDOutput ledObject) {
		ledObject.myLedx = myLocation.xLoc + (ledObject.ledDistance * Math.sin(Math.toRadians(myLocation.getZAngle())));
		ledObject.myLedy = myLocation.yLoc + (ledObject.ledDistance * Math.cos(Math.toRadians(myLocation.getZAngle())));
	}

}
