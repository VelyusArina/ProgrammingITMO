package exception;

public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException() {
        super("Непроверенные исключения: не может бросать вещи в камин");
    }
}

