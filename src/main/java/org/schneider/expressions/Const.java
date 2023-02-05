package org.schneider.expressions;

public class Const implements IExpression {

    private final double value;

    public Const(final double value) {
        this.value = value;
    }

    public double evaluate() {
        return value;
    }

}
