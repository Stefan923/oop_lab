package me.stefan923.exceptiondemo;

import me.stefan923.exceptiondemo.exceptions.AException;
import me.stefan923.exceptiondemo.exceptions.BException;

public class Methods {

    public static void f() throws BException {
        try {
            g();
        } catch (AException exception) {
            throw new BException("A fost aruncata exceptia BException.");
        }
    }

    public static void g() throws AException {
        throw new AException("A fost aruncata exceptia AException.");
    }

}
