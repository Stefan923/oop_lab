package me.stefan923.exceptiondemo2.exceptions;

public class AException extends Exception {

    public AException() {
        super("A fost aruncata o exceptie de tipul AException.");
    }

    public AException(String message) {
        super(message);
    }

}
