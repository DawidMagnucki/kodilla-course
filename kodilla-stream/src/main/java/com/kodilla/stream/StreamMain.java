package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.beans.Expression;

public class StreamMain {
    public static void main(String[] args) {

        /*
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references"); //TODO: Nie rozumiem, dlaczego mozemy skorzystac z method reference skoro w metodzie executeExpression mamy przekazac MathExpression, czyli interface. Klasa FunctionalCalculator nie jest interfacem MathExpression ani z niego nie korzysta. W takim razie, dlaczego ten kod działa?
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("\nDecorating text with lambdas and method reference");
        poemBeautifier.beautify("Jane", poem -> "Beloved " + poem);
        poemBeautifier.beautify("Example", poem -> "ABC " + poem + " ABC");
        poemBeautifier.beautify("Attention!", poem -> "****" + poem.toUpperCase() + "****");
        poemBeautifier.beautify("Attention!", String::toUpperCase);
        poemBeautifier.beautify("Hello!", poem -> poem + new StringBuilder(poem).reverse().toString());
        poemBeautifier.beautify("MyPoemBeautifier", poem -> poem.toLowerCase() + " " + poem);
        */

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}