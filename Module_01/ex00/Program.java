
class Program {
    public static void main ( String[] args ) {

        User sender = new User( "Mohammed", 500 );
        User recipient = new User( "Said", 200 );

        System.out.printf( "Balance of Mohammed is %,d\n", sender.getBalance() );
        System.out.printf( "Balance of Said is  %,d\n\n", recipient.getBalance() );

        Transaction firstTransaction = new Transaction( sender, recipient, 100 );

        System.out.printf( "New balance of Mohammed is %,d\n", sender.getBalance() );
        System.out.printf( "New balance of Said is  %,d\n\n", recipient.getBalance() );

        Transaction secondTransaction = new Transaction( sender, recipient, 500 );
        
        Transaction thirdTransaction = new Transaction( sender, recipient, -100 );
    } 
}