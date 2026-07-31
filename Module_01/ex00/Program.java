
class Program {
    public static void main( String args[] ) {
        User sender = new User();
        sender.setName( "Marouane" );
        User recipient = new User();
        recipient.setName( "Ayoub" );
        sender.setBalance( 1000 );
        recipient.setBalance( 500 );
        Transaction transaction = new Transaction();
        transaction.setTransactionCategory( TransferCategory.CREDITS );
        transaction.setSenderUser( sender );
        transaction.setRecipientUser( recipient );
        int transactionAmount = -100;
        if ( transactionAmount < sender.getBalance() ) {
            if ( transaction.getTransactionCategory() == TransferCategory.CREDITS && transactionAmount < 0 ) {
                transaction.setAmount( transactionAmount );
                sender.setBalance( sender.getBalance() + transactionAmount );
                recipient.setBalance( recipient.getBalance() + (-1 * transactionAmount) );
            }
            else {
                System.err.println("Check transaction type and amount");
            }
            System.out.println( sender.getBalance() );
            System.out.println( recipient.getBalance() );
        }
        else {
            System.err.println("Sender has insufficient balance");
        }
        
    }
}