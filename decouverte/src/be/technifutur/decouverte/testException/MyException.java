package be.technifutur.decouverte.testException;

public class MyException extends Exception {
    public MyException() {
    }

    private int num;

    public int getNum() {
        return num;
    }

    public MyException(String message) {
        super(message);
        this.num = num;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
