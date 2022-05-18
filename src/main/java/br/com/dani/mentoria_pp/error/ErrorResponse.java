package br.com.dani.mentoria_pp.error;

public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponse() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
