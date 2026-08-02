import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    private TransactionsService transactionService;
    private final Scanner scanner;
    private final boolean isDev;

    Menu( TransactionsService tranService, boolean isDev ){
        this.transactionService = tranService;
        this.isDev = isDev;
        this.scanner = new Scanner( System.in );
    }

    public void start() {
       
        while( true ) {
            this.printMenu();
            try {
                Integer choice = this.scanner.nextInt();
                switch (choice) {
                    case 1:
                        this.addUser();
                        break;

                    case 2:
                        viewUserBalances();
                        break;

                    case 3:
                        performTransfer();
                        break;

                    case 4:
                        viewUserTransactions();
                        break;

                    case 5:
                        if (this.isDev) {
                            removeTransferById();
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;

                    case 6:
                        if (this.isDev) {
                            checkTransferValidity();
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        this.scanner.close();
                        System.exit(0);
                        break;

                    default:
                    System.out.println("Invalid choice. Please try again.");
                }

            } catch ( InputMismatchException e ) {
                System.out.println("Please enter a valid data.");
                this.scanner.nextLine(); 
            } catch ( Exception e ) {
                System.out.println( e.getMessage() );
            }
        }
    }

    public void printMenu() {
        System.out.println("1. Add user");
        System.out.println("2. View user balance");
        System.out.println("3. Make transfer");
        System.out.println("4. View all transactions for a specific user");
        if (this.isDev) {
            System.out.println("5. Remove transfer by ID");
            System.out.println("6. Check transfers validity");
            System.out.println("7. Finish execution");
        }
        else 
            System.out.println("5. Finish execution");
        System.out.print("-> ");
    }

    public void addUser( ) {
        System.out.println("Enter a user name and a balance");
        String name = this.scanner.next();
        Integer balance = this.scanner.nextInt();
        User user = this.transactionService.addUser( name, balance );
        System.out.printf("User with id = %d is added\n", user.getId());
    }

    public void viewUserBalances( ) {
        System.out.printf("Enter a user Id\n->");
        Integer id = this.scanner.nextInt();
        User u = this.transactionService.getUserById( id );
        Integer userBalance = this.transactionService.getUserBalance( id );
        System.out.printf( "%s %d\n", u.getName(), userBalance );
    }

    public void performTransfer( ) {
        System.out.printf("Enter a sender ID, a recipient ID, and a transfer amount\n");
        Integer senderId = this.scanner.nextInt();
        Integer recipientId = this.scanner.nextInt();
        Integer amount = this.scanner.nextInt();
        this.transactionService.transfer( senderId, recipientId, amount );
        System.out.printf("The transfer is completed\n");
    }

    public void viewUserTransactions( ) {
        System.out.printf("Enter a user Id\n->");
        Integer userId = this.scanner.nextInt();
        Transaction[] transactions = this.transactionService.getUserTransactions( userId ); 

        for ( Transaction transaction : transactions ) {
            if ( transaction.getTransactionCategory() == TransferCategory.DEBITS ) {
                System.out.printf(
                    "To %s(id = %d) %d with id = %s%n",
                    transaction.getRecipientUser().getName(),
                    transaction.getRecipientUser().getId(),
                    transaction.getAmount(),
                    transaction.getId()
                );
            }
            else {
                System.out.printf(
                    "From %s(id = %d) %d with id = %s%n",
                    transaction.getSenderUser().getName(),
                    transaction.getSenderUser().getId(),
                    transaction.getAmount(),
                    transaction.getId()
                );
            }
        }
    }

    public void removeTransferById() {
        System.out.printf("Enter a user ID and a transfer ID\n->");
        Integer userId = this.scanner.nextInt();
        String transactionId = this.scanner.next();
        User user = this.transactionService.getUserById( userId );
        Transaction tran = user.getTransactionById( transactionId );
        this.transactionService.removeTransaction( transactionId, userId );
        if (tran.getTransactionCategory() == TransferCategory.DEBITS) {
            System.out.printf(
                "Transfer To %s(id = %d) %d removed%n",
                tran.getRecipientUser().getName(),
                tran.getRecipientUser().getId(),
                (-1 * tran.getAmount())
            );
        } else {
            System.out.printf(
                "Transfer From %s(id = %d) %d removed%n",
                tran.getSenderUser().getName(),
                tran.getSenderUser().getId(),
                tran.getAmount()
            );
        }
    }

    public void checkTransferValidity() {
        Transaction[] unpairedTransaction = this.transactionService.checkValidity();
        for ( Transaction transaction : unpairedTransaction ) {
            System.out.printf(
                "%s(id = %d) has an unacknowledged transfer id = %s from %s(id = %d) for %d%n",
                transaction.getRecipientUser().getName(),
                transaction.getRecipientUser().getId(),
                transaction.getId(),
                transaction.getSenderUser().getName(),
                transaction.getSenderUser().getId(),
                transaction.getAmount() < 0 ? -1 * transaction.getAmount() : transaction.getAmount()
            );
        }
    }
}