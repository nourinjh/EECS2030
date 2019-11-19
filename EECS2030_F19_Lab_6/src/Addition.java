
public class Addition extends Expression {
	private int sum;

	Addition(int left, int right) {
		super(left, right);

		this.leftOp = left;
		this.rightOp = right;

		this.sum = this.leftOp + this.rightOp;
		this.value = this.sum;
	}

	// evaluates the expression and puts sum in an expression.value field
	@Override
	void evaluate() {
		this.sum = this.leftOp + this.rightOp;
		this.value = this.sum;
	}

	public Object getValue() {
		return this.value;
	}

}
