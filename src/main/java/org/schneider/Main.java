package org.schneider;

import org.schneider.parser.ExpressionParser;

import java.io.IOException;

public class Main {

    public static void main(final String[] args) throws IOException {
        System.out.println("Hello");
        for (String expression : args) {
            ExpressionParser parser = new ExpressionParser(expression);
            double result = parser.parse().evaluate();
            System.out.printf("%s = %s%n", expression, result);
        }
    }

}