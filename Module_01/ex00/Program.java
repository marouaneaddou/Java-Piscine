import java.util.UUID;

class Program {
    public static void main ( String[] args ) {

        User sender = new User( );
        User recipient = new User( );

        sender.id = 1;
        sender.name = "Mohammed";
        sender.balance = 500;

        recipient.id = 2;
        recipient.name = "Said";
        recipient.balance = 200;

        long amount = 200;
        Transaction transaction = new Transaction( );
        transaction.setAmount( 600 );
        if ( transaction.getAmount( ) > 0 ) {
            transaction.id = UUID.randomUUID();
            transaction.category = "DEBIT";
            transaction.sender = sender;
            transaction.recipient = recipient;
            transaction.transferAmount( );
        }
        System.out.printf( "New balance of Mohammed is %,d\n", sender.getBalance() );
        System.out.printf( "New balance of Said is  %,d\n\n", recipient.getBalance() );
    } 
}