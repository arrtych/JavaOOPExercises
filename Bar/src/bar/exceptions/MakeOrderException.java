package bar.exceptions;

public class MakeOrderException extends NullPointerException {
    public MakeOrderException(String message) {
        super(message);
    }
}
