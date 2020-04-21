package threads_runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        //shutdown() -> the the excecutorService  after all running tasks are finished
        executorService.shutdown();

        //shutdownNow() -> interrupts all running tasks and shut the executor down immediately.
        executorService.shutdownNow();


        //This is the preferred way how to typically shutdown executors:
        try {
            System.out.println("attempt to shutdown executor");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }

    }
}
