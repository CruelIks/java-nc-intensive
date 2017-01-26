package netcracker.intensive.rover;

/**
 * Это исключение должно быть проверяемым - оно возникает, если ровер вышел за пределы поверхности
 */
public class OutOfGroundException extends Exception {
    public OutOfGroundException() {
        super();
    }

    public OutOfGroundException(String message) {
        super(message);
    }
}
