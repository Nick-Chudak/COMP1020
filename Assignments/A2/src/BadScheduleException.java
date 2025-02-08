/**
 * File: BadScheduleException.java
 * Date: 31-01-2025
 * Copyright: © 2025 University of Manitoba
 * License: All rights reserved.
 *
 * Description:
 *     This class defines a custom exception used to indicate errors 
 *     related to invalid or conflicting train schedules.
 *
 * Example:
 *     throw new BadScheduleException("Train schedule conflicts with existing schedule.");
 *
 * Disclaimer:
 *     This code is intended for educational purposes only and is part of COMP 1020 at the *     University of Manitoba.
 */

public class BadScheduleException extends Exception {
    public BadScheduleException(String message) {
        super(message);
    }

    public BadScheduleException(String message, Throwable cause) {
        super(message, cause);
    }
}
