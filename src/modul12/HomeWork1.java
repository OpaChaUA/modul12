package modul12;

import java.lang.reflect.Executable;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeWork1 {
    public static void main(String[] args) throws InterruptedException {
        HomeWork1 test = new HomeWork1();
        test.countTime();
    }
    public void countTime() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(
                () -> System.out.println("прошло 5 секунд"),
                5,
                5,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                () -> System.out.println("Time " + System.currentTimeMillis()),
                0,
                1,
                TimeUnit.SECONDS
        );
        Thread.sleep(15000);
        executorService.shutdown();
        System.out.println("The End!");
    }
}
