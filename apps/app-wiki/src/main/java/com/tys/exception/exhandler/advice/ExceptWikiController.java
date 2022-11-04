package com.tys.exception.exhandler.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.tys.api")
public class ExceptWikiController extends ExceptBaseController{
}
