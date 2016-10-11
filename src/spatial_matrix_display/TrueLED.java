package spatial_matrix_display;

/*
 * This Class is used to simply create an object including x and y coordinates of where a TRUE LED is present
 * It is used by DisplayMatrix.java to create an ON-LED coordinate
 */
public class TrueLED {
	double x, y;
	final double distanceBetweenLEDS = 1.67;
	TrueLED(double x, double y) {
		this.x = x*distanceBetweenLEDS;
		this.y = y*distanceBetweenLEDS;
	}
}
