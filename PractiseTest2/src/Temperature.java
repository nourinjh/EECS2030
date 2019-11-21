
public class Temperature {

	public static final String CELCIUS = "C";
	public static final String FAHRENHEIT = "F";
	double degC;
	double degF;
	String units;
	
	public Temperature() {
		this(0.0, Temperature.CELCIUS);
	}
	
	public Temperature(double temp, String units) {
		this.setUnits(units);
		this.setTemperature(temp);
	}
	
	public Temperature(Temperature other) {
		this(other.getTemperature(), other.getUnits());
	}
	
	public double getTemperature() {
		if(this.units.equals(Temperature.CELCIUS)) {
			return this.degC;
		}else {
			return this.degF;
		}
	}
	
	public final void setTemperature(double temp) {
		if(this.units.equals(Temperature.CELCIUS)) {
			this.degC = temp;
			this.degF = Temperature.toCelcius(temp);
		}else {
			this.degF = temp;
			this.degC = Temperature.toFahrenheit(temp);
		}
	}
	
	public String getUnits() {
		return this.units;
	}
	
	public final void setUnits(String units) {
		if(units != Temperature.CELCIUS ||units != Temperature.FAHRENHEIT) {
			throw new IllegalArgumentException("the units are incorrect");
		}
		
		this.units = units;
	}
	
	public static double toCelcius(double degF){
		return (degF-32.0)*(5.0/9.0);
	}
	
	public static double toFahrenheit(double degC) {
		return degC*(9.0/5.0)+32.0;
	}
	
	@Override
	public String toString() {
		if(this.getUnits().equals(Temperature.CELCIUS)) {
			return this.getTemperature() + Temperature.CELCIUS;
		}else {
			return this.getTemperature() + Temperature.FAHRENHEIT;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		
		Temperature other = (Temperature) obj;
		if(this.degC != other.degC) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
