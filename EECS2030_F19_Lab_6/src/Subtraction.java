
public class Subtraction extends Expression {

	private int diff;
	
	Subtraction(int left, int right) {
		super(left, right);
		
		this.leftOp = left;
		this.rightOp = right;
		this.diff = this.leftOp - this.rightOp;
		this.value = this.diff;
		
	}
	
	@Override
	void evaluate() {
		this.diff = this.leftOp - this.rightOp;
		this.value = this.diff;
	}
	
	public Object getValue() {
		return this.value;
	}

}
