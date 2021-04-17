import java.util.Scanner;

public class BankAccount {

    private int Account_number = 123;
    private int Withdraw_limit = 10000;
    private int Amount;
    public Scanner s = new Scanner(System.in);

    BankAccount(int Account_number, int intial_value) {

        if (this.Account_number == (Account_number)) {
            Amount = intial_value;
            CheckAmount(Amount);
            int option = -1;


  
            while (option != 0) {
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
            
        }
    }

    void CheckAmount(int CheckAmt) {

        if (Amount <= 0 || Amount <= 1000) {
            Amount=0;
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
            System.out.println("Withdraw limit is upto 10,000 rs only/-");
        } else if (withdraw_value <= 0) {

            System.out.println("Please enter the amount value greater than 0 rs/-");

        }
         else if(withdraw_value>Amount){
                  System.out.println("WithDraw value is greater Please enter the the right amount value!.....");
         }
        else {
            Amount -= withdraw_value;
            System.out.print("Total Amount in your balance: " + Amount);
        }
    }

    void Deposit() {

        int Deposit_value;
        System.out.print("Enter the deposit amount: ");
        Deposit_value = s.nextInt();
        if (Deposit_value <= 0) {
            System.out.print("Please enter the amount value greater than 0 rs/-");
        } else {
            Amount += Deposit_value;
            System.out.println("Current Balance in your account is: " + Amount);
        }

    }

    void ShowDetails() {

        System.out.println("Account Number: " + Account_number);
        System.out.println("Current Balance: " + Amount);
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Account_number, intial_value;
        System.out.print("Enter the Account number: ");
        Account_number = sc.nextInt();
        System.out.print("Enter the intial Amount: ");
        intial_value = sc.nextInt();
        new BankAccount(Account_number, intial_value);

    }
}
