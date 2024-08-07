package lt.onemagic.TruckScale.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

/**
 * CustomException is a custom exception class that extends the RuntimeException class.
 *
 * <p>This class is used to create custom exceptions with a specific error code that can be thrown in the application.
 * It is used to encapsulate error details that can be returned to the client in case of an exception.</p>
 *
 * <p>Annotations:</p>
 * <ul>
 *   <li>@AllArgsConstructor: Generates a constructor with parameters for all fields.</li>
 * </ul>
 */
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private int errorCode;

    public CustomException(String message, int errorCode) {
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }
}