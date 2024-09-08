package org.example.oddify.demo.productserviceapr24.advices;

import org.example.oddify.demo.productserviceapr24.dtos.ExceptionDto;
import org.example.oddify.demo.productserviceapr24.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class,NullPointerException.class})
    public ResponseEntity<String> handleException(){
        return new ResponseEntity<>("In Controller advice Runtime exception", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexException(){
        return new ResponseEntity<>("In Controller advice Index out of bonds exception happened", HttpStatus.OK);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleParentException(){
        ExceptionDto exceptionDto = new ExceptionDto();

        exceptionDto.setMessage("Exception");
        exceptionDto.setErrorCode("Exception");

        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> handleProductLimitReached(){
        ExceptionDto exceptionDto = new ExceptionDto();

        exceptionDto.setMessage("Custom exception handled");
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");

        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);

    }
}
