import java.util.Scanner;

 class AtmMachine {
    private UserBankAccount ac;

    public AtmMachine(UserBankAccount ac) {
        this.ac = ac;
    }

    public void display() {
        System.out.println("Welcom to the ATM");
        System.out.println("1. withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. exit");
    }
        
    public void handleTransaction(int op) {
        Scanner sc = new Scanner(System.in);
        switch (op) {
            case 1:
                System.out.print("Enter amount to withdraw:");
                double withdraw = sc.nextDouble();
                ac.withdraw(withdraw);
                break;

            case 2:
                System.out.print("Enter amount to deposit:");
                double deposit = sc.nextDouble();
                ac.deposit(deposit);
                break;

            case 3:
                System.out.print("Current balance :" + ac.getBalance()); 
                break;
        
            case 4:
                System.out.println("Thank You");
                System.exit(0);
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    
  
}

class UserBankAccount {
    private double balance;

    public UserBankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successfull");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawl successfull");
            return true;
        } else {
            System.out.println("Invalid withdrawl amount");
            return false;
        }
    }
}


public class main {
    public static void main(String[] args) {
        UserBankAccount bankAccount = new UserBankAccount(10000);
        AtmMachine atm = new AtmMachine(bankAccount);
        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            atm.display();
            System.out.print("Enter your choice");
            option = sc.nextInt();
            atm.handleTransaction(option);
        }
        
    }

}