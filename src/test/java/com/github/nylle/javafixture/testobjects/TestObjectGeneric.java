package com.github.nylle.javafixture.testobjects;

public class TestObjectGeneric<T, U> {
    private T t;
    private U u;
    private String string;

    public T getT() {
        return t;
    }

    public U getU() {
        return u;
    }

    public String getString() {
        return string;
    }
}
