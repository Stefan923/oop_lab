package me.stefan923.exceptiondemo;

import me.stefan923.exceptiondemo.exceptions.AException;
import me.stefan923.exceptiondemo.exceptions.BException;

public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            Methods.g();
        } catch (AException exception) {
            exception.printStackTrace();
        }
        try {
            Methods.f();
        } catch (BException exception) {
            exception.printStackTrace();
        }
    }

}
