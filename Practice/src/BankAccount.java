import java.util.Scanner;

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount != 0)
        {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        balance -= amount;
        previousTransaction = -amount;
    }

    void getPreviousTransaction()
    {
        if(previousTransaction > 0 )
        {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0)
        {
            System.out.println("withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }


    void showMenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("Hello " + customerName);
        System.out.println("Welcome to the java bank app, we always do our best to keep you pleased");
        System.out.println("Your ID is: " + customerId);
        System.out.println("");
        System.out.println("");
        // Menu
        System.out.println("-------------------MENU-------------------");

        System.out.println("A.Check Balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Exit");

        do
        {
            System.out.println("=================================================================");
            System.out.println("Enter an option");
            System.out.println("=================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option)
            {
                case 'A':
                    System.out.println("-------------------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------------");
                    System.out.println("How much you want to deposit?");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("successfully deposited " + amount + " USD");
                    System.out.println("\n");
                    break;


                case 'C':
                    System.out.println("-------------------------------");
                    System.out.println("How much you want to withdraw?");
                    System.out.println("-------------------------------");
                    amount = scanner.nextInt();
                    withdraw(amount);
                    System.out.println("successfully withdrawn " + amount + " USD");
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("-------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("*********************************");
                    break;


                default:
                    System.out.println("Invalid option!!, Please try again");
                    break;

            }
        }while (option != 'E');

        System.out.println("Thank You For using java bank app");
    }


}
