
public class Equal extends Expression {
	private boolean equals;

	Equal(int left, int right) {
		super(left, right);
		this.leftOp = left;
		this.rightOp = right;

		this.equals = this.leftOp == this.rightOp;
		this.value = this.equals;
	}

	@Override
	void evaluate() {
		this.equals = this.leftOp == this.rightOp;
		this.value = this.equals;
	}

	public Object getValue() {
		return this.value;
	}

}
