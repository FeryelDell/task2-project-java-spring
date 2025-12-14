package pl.edu.vistula.task2_rest_api.shared.api.response;

public class ErrorMessageResponse {

    private String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
