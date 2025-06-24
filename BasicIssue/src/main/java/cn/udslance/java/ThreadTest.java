package cn.udslance.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ThreadTest
 *
 * @author: Udslance
 * @create: 2024-08-04 11:21
 **/
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // MyThread myThread = new MyThread();
        // myThread.start();
        // RunnableTask task = new RunnableTask();
        // new Thread(task).start();
        // new Thread(task).start();
        FutureTask<String> futureTask = new FutureTask<>(new CallableTask());
        new Thread(futureTask).start();
        try {
            // 等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    // 继承Thread类并重新run方法
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements java.lang.Runnable {

        @Override
        public void run() {
            System.out.println("I am a runnable child thread");
        }
    }

    public static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello world";
        }
    }
}
