package me.stefan923.exceptiondemo2;

import me.stefan923.exceptiondemo2.exceptions.AException;
import me.stefan923.exceptiondemo2.exceptions.BException;

public class B extends A {

    public B() { }

    @Override
    public void testException() throws AException {
        throw new BException();
    }

}
