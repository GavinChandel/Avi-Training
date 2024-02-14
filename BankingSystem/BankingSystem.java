package BankingMgtmSys;

import java.util.*;

// Class representing a bank account
class BankAccount {
    String bankAccount;
    double balance;

    // Constructor to initialize bank account with provided values
    public BankAccount(String bankAccount, double balance) {
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    // Default constructor to initialize the object without any value (default values)
    public BankAccount() {
    }
}

// Class representing a transaction
class Transaction {
    double TransactionID;
    int TransactionType;
    double amount;

    // Transaction class constructor
    public Transaction(double transactionID, int transactionType, double amount) {
        TransactionID = transactionID;
        TransactionType = transactionType;
        this.amount = amount;
    }
}

// Custom exception class for banking system
class BankingException extends Exception {
    double amount;

    // Exception for withdrawal amount
    public String error1(double amount, BankAccount account) {
        if (amount > account.balance)
            return "You do not have sufficient funds";
        else if (amount < 0)
            return "You cannot withdraw a negative amount";
        else if (amount > 100000)
            return "You cannot withdraw more than 1 Lakh in one transaction";
        return null;
    }

    // Exception for deposit amount
    public String error2(double amount, BankAccount account) {
        if (amount > 50000)
            return "Please deposit a small amount!!";
        else if (amount < 0)
            return "Negative amount cannot be deposited";
        return null;
    }

    // Exception for transferring between two accounts
    public String error3(double amount, BankAccount account) {
        if (amount > account.balance)
            return "You do not have sufficient funds";
        else if (amount > 50000)
            return "Please deposit a small amount!!";
        else if (amount < 0)
            return "Negative amount cannot be deposited";
        return null;
    }
}

// Main class for banking system
public class BankingSystem extends BankingException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>(); // List containing all instances of BankAccount class
        List<Transaction> transactions = new ArrayList<>();

        // Adding bank accounts to the system
        BankAccount ac1 = new BankAccount("12345", 10000);
        BankAccount ac2 = new BankAccount("23456", 20000);
        BankAccount ac3 = new BankAccount("34567", 30000);
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        while (true) {
            System.out.println("BANKING SYSTEM MENU");
            System.out.println("1.Deposit Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Transfer to other account");
            System.out.println("4.Display account details");
            System.out.println("5.Exit");

            try {
                // Exception handling for wrong input of choice
                System.out.println("Enter Your Choice:");
                int choice = sc.nextByte();
                if (choice > 5) {
                    throw new InputMismatchException();
                }

                switch (choice) {
                    case 1:
                        deposit(sc, accounts);
                        break;
                    case 2:
                        withdraw(sc, accounts);
                        break;
                    case 3:
                        transfer(sc, accounts);
                        break;
                    case 4:
                        displayacc(sc, accounts);
                        break;
                    case 5:
                        System.out.println("Exiting System");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!!! Please select from the provided options only!!! ");
            }
            sc.nextLine();
        }
    }

    // Function for depositing amount into a bank account
    public static void deposit(Scanner sc, List<BankAccount> accounts) {
        System.out.print("Enter A/c number: ");
        String acc = sc.next();
        boolean flag = false;

        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc)) {
                flag = true;
                System.out.print("Enter the deposit amount: ");
                double amount = sc.nextDouble();

                try {
                    // Catching various exceptions for deposit amount
                    if (amount > 50000) {
                        throw new BankingException();
                    } else if (amount < 0) {
                        throw new BankingException();
                    } else {
                        account.balance += amount;
                        System.out.println("Updated Balance is : " + account.balance);
                        System.out.println("Amount is Deposited Successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type");
                } catch (BankingException e) {
                    System.out.println(e.error2(amount, account));
                }
            }
        }
        if (!flag)
            System.out.println("Account Number does not Exist \nPlease Enter a valid A/c number");
    }

    // Function to withdraw amount from a bank account
    public static void withdraw(Scanner sc, List<BankAccount> accounts) {
        System.out.println("Enter A/c number:");
        String acc = sc.next();
        boolean flag = false;

        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc)) {
                flag = true;
                System.out.println("Enter the withdrawal amount: ");
                double amount = sc.nextDouble();

                try {
                    // Catching various exceptions for withdrawal amount
                    if (amount > account.balance) {
                        throw new BankingException();
                    } else if (amount > 100000) {
                        throw new BankingException();
                    } else if (amount < 0) {
                        throw new BankingException();
                    } else {
                        account.balance -= amount;
                        System.out.println("Withdrawal is successful\nAmount After withdrawal :" + account.balance);
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type");
                } catch (BankingException e) {
                    System.out.println(e.error1(amount, account));
                }
            }
        }
        if (!flag) {
            System.out.println("Please, enter a valid A/c number!!!");
        }
    }

    // Function to transfer amount between bank accounts
    public static void transfer(Scanner sc, List<BankAccount> accounts) {
        System.out.print("Enter the sender's A/c number: ");
        String acc1 = sc.next();
        sc.nextLine();
        System.out.print("Enter the receiver's A/c number: ");
        String acc2 = sc.next();
        sc.nextLine();
        int flag = 0;
        BankAccount a = new BankAccount(), b = new BankAccount();

        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc1)) {
                flag += 1;
                a = account;
            }
        }

        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc2)) {
                flag += 1;
                b = account;
            }
        }

        if (flag == 2) {
            System.out.println("Enter the amount you want to transfer");
            double amount = sc.nextInt();

            try {
                // Catching various exceptions in transferring amount between accounts
                if (amount > a.balance) {
                    throw new BankingException();
                } else if (amount < 0) {
                    throw new BankingException();
                } else if (amount > 50000) {
                    throw new BankingException();
                } else {
                    a.balance -= amount;
                    b.balance += amount;
                    System.out.println("Amount Is transferred Successfully");
                }
            } catch (BankingException e) {
                System.out.println(e.error3(amount, a));
            }
        } else {
            System.out.println("Accounts does not exist ");
        }
    }

    // Function to display the details of a bank account
    public static void displayacc(Scanner sc, List<BankAccount> accounts) {
        System.out.println("Enter your Bank account Number");
        String acc = sc.next();
        boolean flag = false;

        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc)) {
                System.out.println("Account Number :" + account.bankAccount + "\nBalance : " + account.balance);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Please enter a valid Account Number");
        }
    }
}
