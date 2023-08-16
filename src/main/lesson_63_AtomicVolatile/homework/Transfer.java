package main.lesson_63_AtomicVolatile.homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer implements Runnable {
    Account accDonor;
    Account accRecipient;
    int sum;
    private Lock lockFrom = new ReentrantLock();
    private Lock lockTo = new ReentrantLock();

    public Transfer(Account accDonor, Account accRecipient, int sum) {
        this.accDonor = accDonor;
        this.accRecipient = accRecipient;
        this.sum = sum;
    }

    @Override
    public void run() {
        transferMoney(accDonor, accRecipient, sum);
    }

    private void transferMoney(Account accFrom, Account accTo, int sum) {
        try {
            lockFrom.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockTo.lock();
                if (accFrom.getBalance() >= sum) {
                    accFrom.debit(sum);
                    accTo.credit(sum);
                }
        } finally {
            lockFrom.unlock();
            lockTo.unlock();
        }
    }
}
