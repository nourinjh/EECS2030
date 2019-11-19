
public class GreaterThan extends Expression {

	private boolean greater;

	GreaterThan(int left, int right) {
		super(left, right);
		this.leftOp = left;
		this.rightOp = right;
		this.greater = this.leftOp > this.rightOp;
		this.value = this.greater;
	}

	@Override
	void evaluate() {
		this.greater = this.leftOp > this.rightOp;
		this.value = this.greater;
	}

	public Object getValue() {
		return this.value;
	}
}
