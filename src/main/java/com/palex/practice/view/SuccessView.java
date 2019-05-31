package com.palex.practice.view;

/**
 * View для успешной операции.
 */
public class SuccessView {
    /**
     * Строка успеха.
     */
    public final String result;

    /**
     * Конструктор, кот. устанавливает значение результата.
     *
     * @param result
     */
    public SuccessView(String result) {
        this.result = "success";
    }
}
