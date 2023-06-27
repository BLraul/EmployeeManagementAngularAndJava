package ro.myapp.employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);//apelez constructorul clasei RuntimeException
    }
}
