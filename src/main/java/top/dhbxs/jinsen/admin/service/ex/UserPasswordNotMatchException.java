package top.dhbxs.jinsen.admin.service.ex;

public class UserPasswordNotMatchException extends ServiceException{
    public UserPasswordNotMatchException() {
        super();
    }

    public UserPasswordNotMatchException(String message) {
        super(message);
    }

    public UserPasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected UserPasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
