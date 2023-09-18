package app.Backend_USAM.controllers.Exceptions;

public class AdminSignUpException extends Exception{
    public AdminSignUpException(String errorMessage){
        super(errorMessage);
    }
}
