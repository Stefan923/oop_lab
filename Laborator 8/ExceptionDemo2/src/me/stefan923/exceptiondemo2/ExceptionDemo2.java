package me.stefan923.exceptiondemo2;

import me.stefan923.exceptiondemo2.exceptions.AException;

public class ExceptionDemo2 {

    public static void main(String[] args) {
        C c = new C();

        try {
            ((A) c).testException();
        } catch (AException e) {
            e.printStackTrace();
        }
    }

}
