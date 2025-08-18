package com.kodilla.stream; //TODO: Po sprawdzeniu pytan z mentorem, skasuj niepotrzebny kod i importy

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.beans.Expression;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        //@Funcional Interface TODO: Czy zawsze muszę pisać adnotację @Funcional Interface dla interface'u funkcyjnego?

        Forum forum = new Forum();
        Map <Integer, ForumUser> ForumUserList = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() <= 2005)
                .filter(forumUser -> forumUser.getPostCount() > 1)
                .collect(Collectors.toMap(forumUser -> forumUser.getUserID(), forumUser -> forumUser));

        System.out.println("List of users:");
        ForumUserList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}