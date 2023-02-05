package org.schneider.expressions;

public class Sub implements IExpression {

    private final IExpression l;

    private final IExpression r;

    public Sub(final IExpression l, final IExpression r) {
        this.l = l;
        this.r = r;
    }

    public double evaluate() {
        return l.evaluate() - r.evaluate();
    }

}
