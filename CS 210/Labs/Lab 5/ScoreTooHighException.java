public class ScoreTooHighException extends Exception {

    /**
     * Causes a new exception for a score that's too high
     */
    public ScoreTooHighException() {
        super();
    }

    /**
     * Causes a new exception for a score that's too high
     *
     * @param message
     */
    public ScoreTooHighException(String message) {
        super(message);
    }

    /**
     * Causes a new exception for a score that's too high
     *
     * @param cause
     */
    public ScoreTooHighException(Throwable cause) {
        super(cause);
    }

    /**
     * Causes a new exception for a score that's too high
     *
     * @param message
     * @param cause
     */
    public ScoreTooHighException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Causes a new exception for a score that's too high
     *
     * @param message
     * @param cause
     * @param enableSurpression
     * @param writableStackTrace
     */
    public ScoreTooHighException(String message, Throwable cause, boolean enableSurpression, boolean writableStackTrace) {
        super(message, cause, enableSurpression, writableStackTrace);
    }

}
