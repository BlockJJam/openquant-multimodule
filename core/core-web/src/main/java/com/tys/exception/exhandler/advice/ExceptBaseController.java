package com.tys.exception.exhandler.advice;
import com.tys.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
public class ExceptBaseController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    private ErrorResult illegalExHandler(IllegalArgumentException e){
        log.error("[exceptionHandler] error", e);
        return new ErrorResult("BAD_REQUEST_PARAMETER", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ErrorResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("[validHandler] error", e);
        return new ErrorResult("METHOD_ARGUMENT_NOT_VALID", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ErrorResult methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        log.error("[validHandler] error", e);
        return new ErrorResult("METHOD_ARGUMENT_TYPE_MISMATCH", e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    private ErrorResult internalExHandler(Exception e){
        log.error("[exceptionHandler] error", e);
        return new ErrorResult("INTERNAL_EXCEPTION", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler
    private ErrorResult badRequest(HttpServerErrorException.BadGateway e){
        log.error("[exceptionHandler] e", e);
        return new ErrorResult("BAD_GATEWAY", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    private ErrorResult notFound(HttpClientErrorException.NotFound e){
        log.error("[exceptionHandler] e", e);
        return new ErrorResult("NOT_FOUND", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ErrorResult httpMessageNotReadableExHandler(HttpMessageNotReadableException e){
        log.error("[validationHandler] error", e);
        return new ErrorResult("HTTP_MSG_NOT_READABLE_VALIDATION", e.getMessage());
    }
}
