package modul12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzProblem {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzz fizzBuzz = new FizzBuzz();
        service.submit(fizzBuzz::fizz);
        service.submit(fizzBuzz::buzz);
        service.submit(fizzBuzz::fizzbuzz);
        service.submit(fizzBuzz::number);
        service.submit(() -> outPut(fizzBuzz));
        Thread.sleep(2000);
        service.shutdown();
    }

    private static void outPut(FizzBuzz fizzBuzz) {
        while (true) {
            if (fizzBuzz.queue.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!fizzBuzz.queue.isEmpty()) {
                System.out.println(fizzBuzz.queue.poll());
            }
        }

    }
}
