
public class TimesAll extends ExpressionCollector {

	@Override
	void evaluate() {

		if (this.myExpression.size() == 0) {
			this.value = 1;
		} else {
			Integer product = 1;
			for (Expression exp : this.myExpression) {
				exp.evaluate();
				product *= (Integer) exp.getValue();
			}
			this.value = product;
		}
	}

	public Object getValue() {
		return this.value;
	}
}
