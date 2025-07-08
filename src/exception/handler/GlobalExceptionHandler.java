package exception.handler;

import exception.BookNotFoundException;
import exception.DuplicateBookException;
import exception.InsufficientQuantityException;

public class GlobalExceptionHandler {

    public static void handle(Exception e) {

        if (e instanceof DuplicateBookException) {
            System.out.println("WARNING: " + e.getMessage());
        } else if (e instanceof BookNotFoundException) {
            System.out.println("WARNING: " + e.getMessage());
        } else if (e instanceof InsufficientQuantityException) {
            System.out.println("WARNING: " + e.getMessage());
        } else {
            System.out.println("ERROR: An unexpected exception occurred");
        }
    }
}
