package me.stefan923.exceptiondemo2;

import me.stefan923.exceptiondemo2.exceptions.AException;
import me.stefan923.exceptiondemo2.exceptions.CException;

public class C extends B {

    public C() { }

    @Override
    public void testException() throws AException {
        throw new CException();
    }

}
