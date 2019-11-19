
public class LessThan extends Expression {
	private boolean less;
	LessThan(int left, int right) {
		super(left, right);
		this.leftOp = left;
		this.rightOp = right;
		this.less = this.leftOp < this.rightOp;
		this.value = this.less;
	}
	
	@Override
	void evaluate() {
		this.less = this.leftOp < this.rightOp;
		this.value = this.less;
	}
	
	public Object getValue() {
		return this.value;
	}

}
