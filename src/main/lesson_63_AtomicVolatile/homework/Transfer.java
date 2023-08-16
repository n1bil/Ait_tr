package main.lesson_63_AtomicVolatile.homework;

public class Transfer implements Runnable {
    Account accDonor;
    Account accRecipient;
    int sum;

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
        Account firstAcc = accFrom;
        Account secondAcc = accTo;

        if (accFrom.getAccNumber() > accTo.getAccNumber()) {
            firstAcc = accTo;
            secondAcc = accFrom;
        }

        synchronized (firstAcc) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (secondAcc) {
                if (accFrom.getBalance() >= sum) {
                    accFrom.debit(sum);
                    accTo.credit(sum);
                }
            }
        }
    }

}
