
class Program {
    public static void main( String args[] ) {
        TransactionsService transactionService = new TransactionsService();
        User sender = transactionService.addUser("Maroune", 1000);
        User recipient = transactionService.addUser("Ayoub", 500);
        transactionService.transfer( sender.getId(), recipient.getId(), 200 );
        transactionService.transfer( sender.getId(), recipient.getId(), 100 );
        transactionService.transfer( sender.getId(), recipient.getId(), 300 );
        Transaction[] senderTransaction = transactionService.getUserTransactions( sender.getId() );
        transactionService.removeTransaction( senderTransaction[0].getId(), sender.getId() );

        for ( Transaction transaction : senderTransaction ) {
            System.out.printf("sender id %s\nrecipient is %s\n", transaction.getSenderUser().getId(), transaction.getRecipientUser().getId() );
        }
    } 
}