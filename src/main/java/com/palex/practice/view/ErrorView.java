package com.palex.practice.view;

public class ErrorView {

    public String error;

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