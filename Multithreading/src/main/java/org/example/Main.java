package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Account account = new Account(0,"777");
        Account account2 = new Account(0,"007");

        System.out.println("Потоки запущены...");
        System.out.println();
        System.out.println();

        ThreadOne threadOne = new ThreadOne(account);
        threadOne.setName("1");
        ThreadOne threadOne2 = new ThreadOne(account);
        threadOne2.setName("2");
        ThreadOne threadOne3 = new ThreadOne(account);
        threadOne3.setName("3");

        ThreadOne thread1 = new ThreadOne(account2);
        thread1.setName("4");
        ThreadOne thread2 = new ThreadOne(account2);
        thread2.setName("5");
        ThreadOne thread3 = new ThreadOne(account2);
        thread3.setName("6");

        threadOne.start();
        threadOne2.start();
        threadOne3.start();
        Thread.sleep(500);
        thread1.start();
        thread2.start();
        thread3.start();

        try{
            threadOne.join();
            threadOne2.join();
            threadOne3.join();

            thread1.join();
            thread2.join();
            thread3.join();
        }catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Баланс счёта: " + account.getAccountNumber() + " составляет: " + account.getBalance() + " сом.");
        System.out.println("Баланс счёта: " + account2.getAccountNumber() + " составляет: " + account2.getBalance() + " сом.");
    }
}