package com.tys.exception.exhandler.advice;

import com.tys.exception.PriceException;
import com.tys.exception.SymbolException;
import com.tys.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.tys.api")
public class ExceptMarketDataController extends ExceptBaseController{
    @ExceptionHandler
    private ResponseEntity<ErrorResult> priceExHandler(PriceException e){
        log.error("[priceExHandler] error", e);
        return new ResponseEntity<>(new ErrorResult("PRICE_EXCEPTION", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResult> symbolExHandler(SymbolException e){
        log.error("[symbolExHandler] error", e);
        return new ResponseEntity<>(new ErrorResult("SYMBOL_EXCEPTION", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
