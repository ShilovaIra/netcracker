package com.netcracker.utils.reflection;

/**
 * class for throwing a special exception from a Injector class
 */
public class InjectionException extends Exception {

    public InjectionException() {
    }

    public InjectionException(String message) {
        super(message);
    }

    public InjectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InjectionException(Throwable cause) {
        super(cause);
    }

}
