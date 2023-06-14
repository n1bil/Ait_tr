package main.lesson_14.classwork.bank;

import main.lesson_14.classwork.bank.model.BankAccount;

public class BankAppl {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000, "Peter", "Bank1", 101, 100);
        System.out.println(account1.getBalance());
        System.out.println(account1.getAccount());
        account1.display();
        account1.deposit(500);
        System.out.println(account1.getBalance());
        account1.display();

        BankAccount account2 = new BankAccount(1001, "John", "Bank1", 101);
        account2.display(", Mr: ");

        BankAccount account3 = new BankAccount(1002,"Bank2", 201, 1_000_000);
        account3.display();

        BankAccount account4 = new BankAccount(1003, "Bank2", 201);
        account4.display();

        System.out.println();
    }
}
