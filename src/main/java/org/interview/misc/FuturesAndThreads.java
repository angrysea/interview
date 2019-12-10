package org.interview.misc;

import java.util.concurrent.*;

public class FuturesAndThreads {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");
            }, executor);

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Results of asynchronous computation.";
        }, executor).thenApply(text -> {
            return text + " This has been appended to.";
        }).thenApply(text -> {
            return text + " Plus a second append.";
        });

        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
