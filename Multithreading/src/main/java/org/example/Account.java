package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private Integer balance;
    private String accountNumber;
    public Account() {
    }
    public Account(Integer balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    Random random = new Random();
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    Lock lock = new ReentrantLock();
    Semaphore lock2 = new Semaphore(1);
    public void topUpCardBalance() throws InterruptedException {
//        lock.lock();
        lock2.acquire();
        int amount = random.nextInt(1000);
        this.setBalance(this.getBalance() + amount);
        System.out.println("Баланс пополнен на: " + amount + " сом");
        System.out.println("Баланс счёта: " + this.getAccountNumber() + " составляет: " + this.getBalance() + " сом");
//        lock.unlock();
        lock2.release();
    }
    public void withdrawBalance() throws InterruptedException {
//        lock.lock();
        lock2.acquire();
        int amount = random.nextInt(1000);
        if(this.balance>amount) {
            setBalance(this.getBalance()-amount);
            System.out.println("С баланса было снято: " + amount);
        }else {
            System.out.println("Снятие суммы: " + amount + " недоступно!");
        }
        System.out.println("Баланс счёта: " + this.getAccountNumber() + " составляет : " + this.getBalance() + " сом");
            lock2.release();
//        lock.unlock();
    }
}
