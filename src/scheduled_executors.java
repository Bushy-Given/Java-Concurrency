import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bushy-Netshidaulu
 * on 4/22/2020
 */
public class scheduled_executors {

    public static void main(String[] args) throws InterruptedException {

        //This code sample schedules a task to run after an initial delay of three seconds has passed:
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        //ScheduledFutures and Delay
        ScheduledFuture<?> future = executorService.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);



    }
}
