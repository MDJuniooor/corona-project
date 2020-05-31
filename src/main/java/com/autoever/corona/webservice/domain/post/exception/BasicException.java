package com.autoever.corona.webservice.domain.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BasicException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BasicException(String msg){
        super(msg);
    }
}
