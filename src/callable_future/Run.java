package callable_future;

import java.util.concurrent.*;

/**
 * Created by Bushy-Netshidaulu
 * on 4/21/2020
 */
public class Run {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //This lambda expression defines a callable returning an integer after sleeping for one second:
        Callable<Integer> task = ()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Statement interrupted !!");
            }
        };


        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        // executor.shutdownNow(); *none terminated future will through an exception if shutdownNow is call before get*

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);



    }
}
