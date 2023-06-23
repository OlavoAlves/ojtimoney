package com.ojti.ojtimoneyapi.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class OjtimoneyExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    protected ResponseEntity<Object> handleHttpMessageReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, HttpRequest request){
        String mensagemUsuario = messageSource.getMessage("mensagem invalida", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.getCause().toString();
        return handleExceptionInternal(ex, mensagemUsuario, headers, HttpStatus.BAD_REQUEST, request);
    }
    public static class Erro {
        private String mensagemUsuario;
        private String mensagemDesenvolvedor;
        public Erro(String mensagemDesenvolvedor, String mensagemUsuario){
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }
    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, "Mensagem invalida", headers,HttpStatus.BAD_REQUEST, request);
    }
}
