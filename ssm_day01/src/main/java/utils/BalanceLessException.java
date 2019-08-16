package utils;

/**
 * @author yk
 * @date 2019/8/13 - 17:51
 */
public class BalanceLessException extends Exception {
    public BalanceLessException() {
    }

    public BalanceLessException(String message) {
        super(message);
    }
}
