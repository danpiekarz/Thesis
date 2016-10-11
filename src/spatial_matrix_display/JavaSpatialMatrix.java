package spatial_matrix_display;

/*
 * Java Spatial Matrix Class
 */

public class JavaSpatialMatrix {

	// Data members
	public double xLoc;
	public double yLoc;
	public double zLoc;
	public double xAngle;
	public double yAngle;
	public double zAngle;

	// Member functions

	// Constructor
	JavaSpatialMatrix(double xl, double yl, double zl, double xa, double ya,
			double za) {
		xLoc = xl;
		yLoc = yl;
		zLoc = zl;
		xAngle = xa;
		yAngle = ya;
		zAngle = za;
	}

	// Initialise current device position
	public void initialiseOrigin() {
		this.xLoc = 0.0;
		this.yLoc = 0.0;
		this.zLoc = 0.0;
		this.xAngle = 0.0;
		this.yAngle = 0.0;
		this.zAngle = 0.0;
	}

	// try returning a class object
	JavaSpatialMatrix getPosition() {
		JavaSpatialMatrix pos = new JavaSpatialMatrix(getXLoc(), getYLoc(),
				getZLoc(), getXAngle(), getYAngle(), getZAngle());
		return pos;
	}

	public double getXLoc() {
		return xLoc;
		// insert code to obtain x value from sensor here
	}

	public double getYLoc() {
		return yLoc;
		// insert code to obtain y value from sensor here
	}

	public double getZLoc() {
		return zLoc;
		// insert code to obtain z value from sensor here
	}

	public double getXAngle() {
		return xAngle;
		// insert code to obtain x angle from sensor here
	}

	public double getYAngle() {
		return yAngle;
		// insert code to obtain y angle from sensor here
	}

	public double getZAngle() {
		return zAngle;
		// insert code to obtain z angle from sensor here
	}

}
