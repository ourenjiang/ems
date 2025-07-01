package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyField myField = new MyField();
        myField.run();
        myField.testStringField();

        MyFieldValue myFieldValue = new MyFieldValue();
        myFieldValue.testGetValue();
        myFieldValue.testSetValue();

        CallMethod callMethod = new CallMethod();
        callMethod.testGetMethod();
        callMethod.testCallMethod1();
        callMethod.testCallMethod2();
        callMethod.testCallStaticMethod();
        callMethod.testCallNonPublicMethod();

        Polymorphism polymorphism = new Polymorphism();
        polymorphism.run();

        NewInstance newInstance = new NewInstance();
        newInstance.run();
    }
}