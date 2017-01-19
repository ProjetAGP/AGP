package tools.math;

public class MathTools {
	public static double boundValue(double value,double min, double max){
		return value < min ? min : value > max ? max : value;
	}
	
}
