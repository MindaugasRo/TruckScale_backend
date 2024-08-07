package lt.onemagic.TruckScale.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex, WebRequest request) {
        HttpStatusExceptionMessages httpStatusExceptionMessages;
        httpStatusExceptionMessages = new HttpStatusExceptionMessages(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(httpStatusExceptionMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        HttpStatusExceptionMessages httpStatusExceptionMessages = new HttpStatusExceptionMessages(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        return new ResponseEntity<>(httpStatusExceptionMessages, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}