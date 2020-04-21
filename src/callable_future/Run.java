package callable_future;

import java.util.concurrent.*;

/**
 * Created by Bushy-Netshidaulu
 * on 4/21/2020
 */
public class Run {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        //This lambda expression defines a callable returning an integer after sleeping for one second:
        Callable<Integer> task = ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Statement interrupted !!");
            }
        };

        //Here we used newFixedThreadPool(1) --This is equivalent to newSingleThreadExecutor()
        // but we could later increase the pool size by simply passing a value larger than one.

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        // executor.shutdownNow(); *none terminated future will through an exception if shutdownNow is call before get*


        //Any call to future.get() will block and wait until the underlying callable has been terminated.
        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);



        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future1 = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 456;
            } catch (InterruptedException ex) {
                throw new IllegalStateException("Executor Service interrupted!");
            }
        });

        //Executing the above code results in a TimeoutException:
        // We specified a maximum wait time of one second but the callable actually needs two seconds before returning the result.
        future1.get(1 ,TimeUnit.SECONDS);


    }
}
