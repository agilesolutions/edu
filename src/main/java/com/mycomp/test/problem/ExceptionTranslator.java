package com.mycomp.test.problem;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import org.zalando.problem.DefaultProblem;

import org.zalando.problem.Problem;

import org.zalando.problem.ProblemBuilder;

import org.zalando.problem.Status;

import org.zalando.problem.spring.web.advice.ProblemHandling;

import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;


/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 * The error response follows RFC7807 - Problem Details for HTTP APIs (https://tools.ietf.org/html/rfc7807).
 */
@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {
	
    private static final String MESSAGE_KEY = "message";
    
    public static final String UNRECOVERABLE_FAILURE = "error.notRecoverableFailure";
	

    @Value("${spring.service.name}")

    private String applicationName;
	

    @ExceptionHandler
    public ResponseEntity<Problem> handleBadRequestAlertException(BadRequestAlertException ex, NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withStatus(Status.CONFLICT)
                .with(MESSAGE_KEY, UNRECOVERABLE_FAILURE)
                .build();
            return create(ex, problem, request);
    }


}
