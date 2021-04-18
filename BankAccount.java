import java.util.Scanner;

public class BankAccount {

    private int Account_number = 123;  // Account number value
    private int Withdraw_limit = 10000;  //withdraw limit
    private int Amount;  //Amount
    public Scanner s = new Scanner(System.in);  //Creating Scanner obj

    BankAccount(int Account_number, int intial_value) {
        //Parametrized constructor which take two parameters Account_number and intial value
        if (this.Account_number == (Account_number)) {
            //checking that user entered value is equal to set Account value matches or not
            Amount = intial_value;  // Storing value of intial value in Amount
            CheckAmount(Amount);  // CheckAmount is a function which checks amount is not less than r equal to 1000
            int option = -1;


            while (option != 0) {
                //option given to user to perform some operations
                System.out.println("To exit enter 0");
                System.out.println("Enter 1 for witdraw");
                System.out.println("Enter 2 for deposit");
                System.out.println("Enter 3 for account details");
                System.out.println();
                System.out.print("Enter your option: ");
                option = s.nextInt();

                switch (option) {

                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        Withdraw();
                        break;
                    case 2:
                        Deposit();
                        break;
                    case 3:
                        ShowDetails();
                        break;

                    default:
                        System.out.println("Please enter correct option!....");
                        break;

                }

            }

        } else {

            System.out.println("Please enter the valid Account number!...");
            // if Account_number is not valid it shows else part .

        }
    }

    // checkAmount function
    void CheckAmount(int CheckAmt) {

        if (Amount <= 0 || Amount <= 1000) {
            //checking if entered amount by user is not less than 0 and less than or equal to 1000/-
            Amount = 0;  //if above condition satisfy the intial amount will be set to 0
            System.out.println("Please enter intial amount greater than 1000/-");
        } else {
            System.out.println("Thanks for creating the account in bank");
            System.out.println("Your intial Amount is: " + Amount);
        }
    }

    void Withdraw() {
        int withdraw_value;
        System.out.print("Enter the withdraw value: ");
        withdraw_value = s.nextInt();
        if (withdraw_value > Withdraw_limit) {
            // This condition checks for withdraw_limit (i.e. if Amount is greater than withdraw_limit then it will print below statements)
            System.out.println("Withdraw limit is upto 10,000 rs only/-");
        } else if (withdraw_value <= 0) {
            // this condition checks for if user doesn't entered the amount value 0 or less than 0 because Amount cannot be negative

            System.out.println("Please enter the amount value greater than 0 rs/-");

        } else if (withdraw_value > Amount) {
            //this condition checks if amount entered by user  is greater than his/her current balance.
            System.out.println("WithDraw value is greater Please enter the the right amount value!.....");
        } else {
            // if above all condition doesn't satisfy it will do withdraw operations.
            Amount -= withdraw_value;
            System.out.print("Total Amount in your balance: " + Amount);
        }
    }

    void Deposit() {

        int Deposit_value;
        System.out.print("Enter the deposit amount: ");
        Deposit_value = s.nextInt();
        if (Deposit_value <= 0) {
            // it checks if Amount entered by user is not less than or equal to 0  because we cannot deposit negative amount 
            System.out.print("Please enter the amount value greater than 0 rs/-");
        } else {
            // if above condition fails it will perform else part where deposit operations is taking place
            Amount += Deposit_value;
            System.out.println("Current Balance in your account is: " + Amount);
        }

    }

    void ShowDetails() {
        //this function is created to show details of user
        System.out.println("Account Number: " + Account_number);
        System.out.println("Current Balance: " + Amount);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //created Scanner class obj
        int Account_number, intial_value;
        System.out.print("Enter the Account number: ");
        Account_number = sc.nextInt();
        System.out.print("Enter the intial Amount: ");
        intial_value = sc.nextInt();
        new BankAccount(Account_number, intial_value);  //constructor is called

    }
}
