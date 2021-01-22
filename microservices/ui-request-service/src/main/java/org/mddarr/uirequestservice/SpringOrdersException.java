package org.mddarr.uirequestservice;

public class SpringOrdersException extends RuntimeException {
    public SpringOrdersException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringOrdersException(String exMessage) {
        super(exMessage);
    }
}
