package callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bushy-Netshidaulu
 * on 4/21/2020
 */
public class Run {

    public static void main(String[] args) {

        Callable<Integer> task = ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Statement interrupted !!");
            }
        };





    }
}
