package com.palex.practice.Wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class WrapperObj {

    private final Object data;

    public WrapperObj(Object data) {
        this.data = data;
    }
}
