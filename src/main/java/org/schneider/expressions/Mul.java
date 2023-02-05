package org.schneider.expressions;

public class Mul implements IExpression {

    private final IExpression l;

    private final IExpression r;

    public Mul(final IExpression l, final IExpression r) {
        this.l = l;
        this.r = r;
    }

    public double evaluate() {
        return l.evaluate() * r.evaluate();
    }

}
