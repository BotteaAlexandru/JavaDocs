package ro.teamnet.zerotohero.exceptions;
import java.lang.*;

/**
 * Created by user on 6/30/2016.
 */
public class Ex {
    public void test() throws MyException {
        throw new MyException("try again please");
    }
}
