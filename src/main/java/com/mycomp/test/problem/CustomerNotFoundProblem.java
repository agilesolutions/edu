package com.mycomp.test.problem;
import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class CustomerNotFoundProblem extends AbstractThrowableProblem {
	 
    private static final URI TYPE
      = URI.create("https://example.org/not-found");
 
    public CustomerNotFoundProblem(Long customerId) {
        super(
          TYPE,
          "Not found",
          Status.NOT_FOUND,
          String.format("Task '%s' not found", customerId));
    }
 
}