package com.palex.practice.Wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Wrapper<T> {
    private final List<T> data;

    public Wrapper(List<T> data) {
        this.data = data;
    }
}
