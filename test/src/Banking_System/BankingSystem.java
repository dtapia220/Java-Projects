package Banking_System;
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345", 1000);
        BankAccount account2 = new BankAccount("67890", 500);

        System.out.println("Account 1 balance: $" + account1.getBalance());
        System.out.println("Account 2 balance: $" + account2.getBalance());

        account1.deposit(500);
        account2.withdraw(200);

        System.out.println("Account 1 balance: $" + account1.getBalance());
        System.out.println("Account 2 balance: $" + account2.getBalance());
    }
}