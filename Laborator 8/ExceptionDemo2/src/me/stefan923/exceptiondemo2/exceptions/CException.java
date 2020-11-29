package me.stefan923.exceptiondemo2.exceptions;

public class CException extends BException {

    public CException() {
        super("A fost aruncata o exceptie de tipul CException.");
    }

    public CException(String message) {
        super(message);
    }

}
