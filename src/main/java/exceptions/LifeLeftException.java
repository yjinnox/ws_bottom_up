package exceptions;

public class LifeLeftException extends Exception{

    private LifeLeftFault fault;

    public LifeLeftException(String message, LifeLeftFault fault) {
        super(message);
        this.fault = fault;
    }

    public LifeLeftException(String message, Throwable cause, LifeLeftFault fault) {
        super(message, cause);
        this.fault = fault;
    }

    public LifeLeftFault getFaultInfo(){
        return fault;
    }
}
