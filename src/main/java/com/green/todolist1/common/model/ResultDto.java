package com.green.todolist1.common.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResultDto<T> {
    private Integer code;
    private String msg;
    private T data;
}
