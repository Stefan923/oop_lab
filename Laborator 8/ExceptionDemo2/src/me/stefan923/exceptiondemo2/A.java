package me.stefan923.exceptiondemo2;

import me.stefan923.exceptiondemo2.exceptions.AException;

public class A {

    public A() { }

    public void testException() throws AException {
        throw new AException();
    }

}
