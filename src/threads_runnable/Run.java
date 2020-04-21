package threads_runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Bushy-Netshidaulu
 * on 4/21/2020
 */
public class Run {

    public static void main(String[] args) {

        Runnable task = ()->
                System.out.println("thread name : " + Thread.currentThread().getName()) ;

        Thread thread = new Thread(task);

        thread.start();

        //excecuterService

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);

    }
}
