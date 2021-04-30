package ch.zhaw.exercise.le07a.task06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Fibonacci {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Collection<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();

        tasks.add(new FibonacciCallable(45));
        tasks.add(new FibonacciCallable(35));
        tasks.add(new FibonacciCallable(45));
        tasks.add(new FibonacciCallable(40));

        List<Future<Integer>> result = null;
        try {
            long start = System.currentTimeMillis();
            result = executorService.invokeAll(tasks);
            System.out.println("Total Time: " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("Rechnen");

        for (Future<Integer> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException ignored) { }
        }
        executorService.shutdown();
    }
}


class FibonacciCallable  implements Callable<Integer>{

    private final Integer numberOfDigits;

    public FibonacciCallable(Integer numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public static int fibonacciRekursiv(int n) {
        int res = 0;
        if (n >= 2) {
            res = fibonacciRekursiv(n - 1) + fibonacciRekursiv(n - 2);
        } else if (n == 1) {
            res = 1;
        }
        return res;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                " startet Berechnung der Fibonacci Zahl fuer n = '" + numberOfDigits + "'");
        long start = System.currentTimeMillis();
        int fibonacciNumber = fibonacciRekursiv(numberOfDigits);

        System.out.println(Thread.currentThread().getName() +
                " hat Fibonacci Zahl fuer n = '" + numberOfDigits + "' berechnet: " + (System.currentTimeMillis() - start) + " ms");
        return fibonacciNumber;
    }
}
