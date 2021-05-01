package ch.zhaw.homework.le07;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadFuture implements Callable<String> {


    @Override
    public String call() throws Exception {

        Thread.sleep(1000);

        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<>();

        Callable<String> callable = new ThreadFuture();

        for (int i = 0; i < 99; i++) {
            Future<String> future = service.submit(callable);
            list.add(future);
        }

        for (Future<String> fut : list) {
            System.out.println(fut.get());
        }

        service.shutdown();
    }
}