import java.util.Scanner;

class Main {
    static class ATM {
        private float balance;
        private int pin;

        public ATM(int pin) {
            this.pin = pin;
        }

        public boolean verifyPin(int enteredPin) {
            return this.pin == enteredPin;
        }

        public void checkPin() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (verifyPin(enteredPin)) {
                menu();
            } else {
                System.out.println("Invalid PIN. Please try again.");
                System.out.print("Enter your PIN: ");
                enteredPin = sc.nextInt();

                if (verifyPin(enteredPin)) {
                    menu();
                } else {
                    System.out.println("Two attempts failed. Exiting...");
                }
            }
        }

        public void menu() {
            Scanner sc = new Scanner(System.in);

            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Quit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    withdrawAmount();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    menu();
            }
        }

        public void withdrawAmount() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter withdrawal amount:");
            float amount = sc.nextFloat();

            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance);
            }

            menu();
        }

        public void depositAmount() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter deposit amount:");
            float amount = sc.nextFloat();

            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);

            menu();
        }

        public void transfer() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter transfer amount:");
            float amount = sc.nextFloat();

            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                System.out.println("Transfer successful. Remaining balance: " + balance);
            }

            menu();
        }

        public void showBalance() {
            System.out.println("Current balance: " + balance);
            menu();
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1236);
        atm.checkPin();
    }
}
