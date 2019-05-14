package com.palex.practice.Error;

public class ErrorView {

    private String error;

    public ErrorView(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
