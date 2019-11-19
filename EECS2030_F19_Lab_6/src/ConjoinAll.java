
public class ConjoinAll extends ExpressionCollector {
	@Override
	void evaluate() {
		Boolean conjoin = true;
		if (this.myExpression.size() == 0) {
			this.value = true;
		} else {
			for (Expression exp : this.myExpression) {
				exp.evaluate();
				conjoin = conjoin && (Boolean) exp.value;
			}

			this.value = conjoin;
		}
	}

	@Override
	public Object getValue() {
		return this.value;
	}
}
