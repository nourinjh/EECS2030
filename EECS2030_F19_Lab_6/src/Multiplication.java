
public class Multiplication extends Expression {
	private int product;

	Multiplication(int left, int right) {
		super(left, right);
		this.leftOp = left;
		this.rightOp = right;
		this.product = this.leftOp * this.rightOp;
		this.value = this.product;
	}

	@Override
	void evaluate() {
		this.product = this.leftOp * this.rightOp;
		this.value = this.product;
	}

	public Object getValue() {
		return this.value;
	}

}
