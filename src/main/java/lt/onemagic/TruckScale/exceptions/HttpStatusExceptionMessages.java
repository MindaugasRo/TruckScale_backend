package lt.onemagic.TruckScale.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * HttpStatusExceptionMessages is a data class that represents an error response with an HTTP status and a message.
 *
 * <p>This class is used to encapsulate error details that can be returned to the client in case of an exception.
 * It uses Lombok annotations to automatically generate boilerplate code such as getters, setters, and constructors.</p>
 *
 * <p>Annotations:</p>
 * <ul>
 *   <li>@Data: Generates getters, setters, toString, equals, and hashCode methods.</li>
 *   <li>@AllArgsConstructor: Generates a constructor with parameters for all fields.</li>
 * </ul>
 */
@Data
@AllArgsConstructor
public class HttpStatusExceptionMessages {
    /**
     * The HTTP status of the error response.
     */
    private HttpStatus status;

    /**
     * The error code.
     *
     * <p>Should be a unique identifier for the error, such as:
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     * </p>
     */
    private int errorCode;

    /**
     * The error message.
     *
     * <p>Should provide more specific information about the error, such as:
     *  - Invalid input data
     *  - Database connection error
     *  - Service unavailable
     * </p>
     */
    private String message;

    /**
     * Default constructor for generic error responses.
     */
    public HttpStatusExceptionMessages(HttpStatus internalServerError, String anUnexpectedErrorOccurred) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Įvyko netikėta klaida");
    }

    /**
     * Creates a new HttpStatusExceptionMessages instance with a BAD_REQUEST status and the specified message.
     *
     * @param message the error message
     * @return a new HttpStatusExceptionMessages instance
     */
    public static HttpStatusExceptionMessages badRequest(String message) {
        return new HttpStatusExceptionMessages(HttpStatus.BAD_REQUEST, 400, "Neteisinga nuoroda");
    }

    /**
     * Creates a new HttpStatusExceptionMessages instance with a NOT_FOUND status and the specified message.
     *
     * @param message the error message
     * @return a new HttpStatusExceptionMessages instance
     */
    public static HttpStatusExceptionMessages notFound(String message) {
        return new HttpStatusExceptionMessages(HttpStatus.NOT_FOUND, 404, "Nerasta");
    }

    /**
     * Creates a new HttpStatusExceptionMessages instance with an INTERNAL_SERVER_ERROR status and the specified message.
     *
     * @param message the error message
     * @return a new HttpStatusExceptionMessages instance
     */
    public static HttpStatusExceptionMessages internalServerError(String message) {
        return new HttpStatusExceptionMessages(HttpStatus.INTERNAL_SERVER_ERROR, 500,"Įvyko netikėta klaida");
    }

    /**
     * Creates a new HttpStatusExceptionMessages instance with a SERVICE_UNAVAILABLE status and the specified message.
     *
     * @param message the error message
     * @return a new HttpStatusExceptionMessages instance
     */
    public static HttpStatusExceptionMessages serviceUnavailable(String message) {
        return new HttpStatusExceptionMessages(HttpStatus.SERVICE_UNAVAILABLE, 503, "Paslauga nepasiekiama");
    }
}