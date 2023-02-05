package org.schneider.parser;

import org.schneider.expressions.*;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_NUMBER;

public class ExpressionParser {

    private final StreamTokenizer tokenizer;

    public ExpressionParser(final String s) {
        tokenizer = new StreamTokenizer(new StringReader(s));
        tokenizer.ordinaryChar('(');
        tokenizer.ordinaryChar(')');
        tokenizer.ordinaryChar('+');
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('*');
        tokenizer.ordinaryChar('/');
    }

    public IExpression parse() throws IOException {
        tokenizer.nextToken();
        final IExpression e = term();
        expect(TT_EOF);
        return e;
    }

    private IExpression term() throws IOException {
        IExpression e = product();
        while (true) {
            if (accept('+')) {
                e = new Add(e, product());
            } else if (accept('-')) {
                e = new Sub(e, product());
            } else {
                return e;
            }
        }
    }

    private IExpression product() throws IOException {
        IExpression e = factor();
        while (true) {
            if (accept('*')) {
                e = new Mul(e, factor());
            } else if (accept('/')) {
                e = new Div(e, factor());
            } else {
                return e;
            }
        }
    }

    private IExpression factor() throws IOException {
        final IExpression e;
        if (accept('(')) {
            e = term();
            expect(')');
        } else {
            expect(TT_NUMBER);
            e = new Const(tokenizer.nval);
        }
        return e;
    }

    private boolean accept(final int type) throws IOException {
        if (tokenizer.ttype == type) {
            tokenizer.nextToken();
            return true;
        }
        return false;
    }

    private void expect(final int type) throws IOException {
        if (tokenizer.ttype != type) {
            throw new IOException("Invalid Syntax.");
        }
        tokenizer.nextToken();
    }

}
