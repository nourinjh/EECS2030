package practiceTest1;
import java.awt.Color;
import java.lang.Object;

public class Gray {
	
	static double MAX_DOUBLE_VALUE = 1.0;
	static int MAX_INT_VALUE = 255;
	static double MIN_DOUBLE_VAULE = 0.0;
	static int MIN_INT_VALUE = 0;
	static double gray;
	static boolean isInt;
	
	public Gray(double g) {
		if(g <0.0 || g>1.0) {
			throw new IllegalArgumentException("number needs to be between 0.0 and 1.0");
		}
		
		this.gray = g;
		this.isInt = false;
	}
	
	public Gray(Gray other) {
		this.gray = other.gray;
		this.isInt = other.isInt;
	}
	
	public Gray(int g) {
		if(g<0 || g>255) {
			throw new IllegalArgumentException("number must be between 0 and 255");
		}
		this.gray = Gray.toDouble(g);
		isInt = true;
	}
	
	public int asInt() {
		
		return Gray.toInt(gray);
	}
	
	public double asDouble() {
	
		return this.gray;
	}
	
	public static double toDouble(int value) {
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("number must be between 0 and 255");
		}
		return  (0.0+value)/Gray.MAX_DOUBLE_VALUE;
	}
	
	public static int toInt(double value) {
		if(value <0.0 || value>1.0) {
			throw new IllegalArgumentException("number needs to be between 0.0 and 1.0");
		}
		
		return (int) Math.round(Gray.MAX_DOUBLE_VALUE*value);
	}
	
	public static Gray fromRGB(Color c) {
		double r = (double)c.getRed()/Gray.MAX_INT_VALUE;
		double g = (double)c.getGreen()/Gray.MAX_INT_VALUE;
		double b = (double)c.getBlue()/Gray.MAX_INT_VALUE;
		double gray = 0.299*r + 0.587*g + 0.114*b;
		
		return new Gray(gray) ;
	}
	
	public String toString() {
		String s = "";
		if(isInt == true) {
			s += asInt();
		}else {
			s += asDouble();
		}
		return s;
	}
	
	public int compareTo(Gray other) {
		int res = 0;
		if(other.gray > this.gray) {
			res = -1;
		}
		if(other.gray < this.gray) {
			res= 1;
		}

		return res;
	}
	
	public boolean equals(Object obj) {
		if(obj != null || obj == this) {
			return true;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		Gray other = (Gray)obj;
		if(this.asInt() != other.asInt()) {
			return false;
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Gray(0.0));

	}

}
