package top.dhbxs.jinsen.admin.service.ex;

public class TokenErr extends ServiceException{
    public TokenErr() {
        super();
    }

    public TokenErr(String message) {
        super(message);
    }

    public TokenErr(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenErr(Throwable cause) {
        super(cause);
    }

    protected TokenErr(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
