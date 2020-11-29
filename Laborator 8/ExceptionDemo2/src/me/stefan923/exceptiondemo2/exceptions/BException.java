package me.stefan923.exceptiondemo2.exceptions;

public class BException extends AException {

    public BException() {
        super("A fost aruncata o exceptie de tipul BException.");
    }

    public BException(String message) {
        super(message);
    }

}
