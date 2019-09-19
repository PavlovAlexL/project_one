package com.palex.practice.view;

/**
 * View для отправки сообщения об ощибке
 */
public class ErrorView {

    /**
     * Строка, которая отправляется при возникновении ошибки.
     */
    public String error;

    public ErrorView() {
        this.error = "Error occured";
    }
}