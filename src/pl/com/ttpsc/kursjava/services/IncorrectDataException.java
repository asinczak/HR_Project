package pl.com.ttpsc.kursjava.services;

public class IncorrectDataException extends Exception {

    @Override
    public String getMessage () {
        return "You've entered wrong data. Please try again";
    }
}
