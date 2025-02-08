/**
 * File: BadTrainException.java
 * Date: 31-01-2025
 * Copyright: © 2025 University of Manitoba
 * License: All rights reserved.
 *
 * Description:
 *     This class defines a custom exception used to indicate errors 
 *     related to invalid train operations.
 *
 * Example:
 *     throw new BadTrainException("Train ID not found in the system.");
 *
 * Disclaimer:
 *     This code is intended for educational purposes only and is part of COMP 1020 at the *     University of Manitoba.
 */

public class BadTrainException extends Exception {
    public BadTrainException(String message) {
        super(message);
    }

    public BadTrainException(String message, Throwable cause) {
        super(message, cause);
    }
}
