import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    private TransactionsService transactionService;
    private boolean isDev;

    Menu( TransactionsService tranService, boolean isDev ){
        this.transactionService = tranService;
        this.isDev = isDev;
    }

    public void start() {
        Scanner scanner = new Scanner( System.in );
        while( true ) {
            this.printMenu();
            try {
                Integer choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public void printMenu() {
        System.out.println("1. Add user");
        System.out.println("2. View user balance");
        System.out.println("3. Make transfer");
        System.out.println("4. View user transactions");
        if (this.isDev) {
            System.out.println("5. Remove transfer by ID");
            System.out.println("6. Check transfers validity");
        }
        System.out.println("7. Finish execution");
        System.out.print("Enter command: ");
    }
}