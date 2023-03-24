package com.gmail.natalliagavrilova.user.controller.advices;

import java.util.List;

public class MultiError {

    private final String logref = "structured_error";

    private List<FieldError> errors;

    public MultiError() {
    }

    public MultiError(List<FieldError> errors) {
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
