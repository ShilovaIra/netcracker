package com.netcracker.utils.validator;

/**
 * class create message for validation result
 */
public class Message {

    /**
     * component contain information about field which is validating
     */
    private String component;
    /**
     * status of validate
     */
    private Status status;

    public Message() {
    }

    public Message(String message, Status status) {
        this.component = message;
        this.status = status;
    }

    public Message(String component) {
        this.component = component;
    }

    public Message(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "component='" + component + '\'' +
                ", status=" + status +
                '}';
    }
}
