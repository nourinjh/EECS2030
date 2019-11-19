
public class DisjoinAll extends ExpressionCollector {

	@Override
	void evaluate() {
		Boolean disjoin = false;
		if (this.myExpression.size() == 0) {
			this.value = false;
		} else {
			for (Expression exp : this.myExpression) {
				exp.evaluate();
				disjoin = disjoin || (Boolean) exp.value;
			}

			this.value = disjoin;
		}
	}

	@Override
	public Object getValue() {
		return this.value;
	}
}
