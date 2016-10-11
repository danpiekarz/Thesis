package spatial_matrix_display;

/*
 * This Class is used to simply create an object including x and y coordinates of where a TRUE LED is present
 * It is used by DisplayMatrix.java to create an ON-LED coordinate
 */
public class TrueLED {
	double x, y;

	TrueLED(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
