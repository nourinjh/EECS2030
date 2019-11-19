
public class AddAll extends ExpressionCollector {

	@Override
	void evaluate() {
		Integer sum = 0;
		for (Expression exp : this.myExpression) {
			exp.evaluate();
			sum += (Integer) exp.getValue();
		}
		this.value = sum;
	}

	public Object getValue() {
		return this.value;
	}
}
