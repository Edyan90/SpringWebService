package EPICODE.SpringWebService.exceptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(int id, String message) {
        super(message);
    }
}
