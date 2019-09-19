package com.palex.practice.view;

/**
 * View для результатов, обворачивает рекультат в Data.
 */
public class ResultView {

    /**
     * Поле, которое будет корнем возвращаемого Json.
     */
    public final Object data;

    /**
     * Конструктор, кот. устанавливает значение результата.
     * @param data отображение..
     */
    public ResultView(Object data) {
        this.data = data;
    }
}


