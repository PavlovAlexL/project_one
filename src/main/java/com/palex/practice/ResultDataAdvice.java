package com.palex.practice;

import com.palex.practice.view.ResultView;
import com.palex.practice.view.SuccessView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Совет, кастомизирующий ответ для контроллеров.
 */
@ControllerAdvice
public class ResultDataAdvice implements ResponseBodyAdvice {

    /**
     * Определить поддерживается ли кастомизация.
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.hasMethodAnnotation((ExceptionHandler.class));
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getParameterType().getName().equals("void")) {
            return new ResultView(new SuccessView());
        } else {
            return new ResultView(o);
        }
    }
}
