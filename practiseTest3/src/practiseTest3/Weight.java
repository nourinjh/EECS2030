package practiseTest3;


public class Weight {

    public static final String KG = "kg";

    public static final String LB = "lb";
    
    public static final double KG_PER_LB = 0.45359237;

    private double kg;
    private double lb;
    private String units;

    public Weight() {
        this(0.0, Weight.KG);
    }

   
    public Weight(Weight other) {
        this(other.get(), other.getUnits());
    }

    
    public Weight(double wt, String units) {
       this.setUnits(units);
       this.set(wt);
    }


    public double get() {
    		if(this.units.equals(Weight.KG))
    			return this.kg;
    		else
    			return this.lb;
    }

   
    public final void set(double wt) {
        if(wt < 0.0)
        		throw new IllegalArgumentException("weight must be greater than 0");
        if(this.units.equals(Weight.KG)) {
        		this.kg = wt;
        		this.lb = Weight.toPounds(wt);
        }else {
        		this.lb = wt;
        		this.kg = Weight.toKilograms(wt);
        }
    }

   
    public String getUnits() {
        return this.units;
    }

    
    public final void setUnits(String units) {
       if(!units.equals(Weight.KG) && !units.equals(Weight.LB)){
    	   		throw new IllegalArgumentException("Not a valid unit");
       }
       this.units = units;
    }

   
    public static double toPounds(double kg) {
        return kg/Weight.KG_PER_LB;
    }

    
    public static double toKilograms(double lb) {
        return lb*Weight.KG_PER_LB;
    }

    
    @Override
    public String toString() {
       if(this.units.equals(Weight.KG)) {
    	   		return get() + " " + Weight.KG;
       }else {
    	   		return get() + " " + Weight.LB;
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
    		
    		Weight other = (Weight) obj;
    		
    		if(this.kg != other.kg) {
    			return false;
    		}
    		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
