package com.instantor.dap.springbootbackend.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    @JsonIgnore
    private HttpStatus httpStatus;

    private String code;

    private String message;
}
