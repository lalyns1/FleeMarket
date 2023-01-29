package com.lalyns.fleemarket.util.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExceptionDto {
    private String message;
    private StackTraceElement[] trace;

    public ExceptionDto(String message, StackTraceElement[] stackTrace) {
        this.message = message;
        this.trace = stackTrace;
    }

}
