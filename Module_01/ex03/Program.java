
class Program {
    public static void main( String args[] ) {
        User sender = new User();
        sender.setName( "Marouane" );
        sender.setBalance(1000);
        User recipient = new User();
        recipient.setName( "Ayoub" );
        recipient.setBalance(200);

        Transaction senderTransaction = new Transaction( sender, recipient ); 
        Transaction recipientTransaction = new Transaction( sender, recipient ); 
        final Integer amountTransaction = 200; 

        senderTransaction.setTransactionCategory( TransferCategory.CREDITS );
        senderTransaction.setAmount( -1 * amountTransaction );

        recipientTransaction.setTransactionCategory( TransferCategory.DEBITS );
        recipientTransaction.setAmount( amountTransaction );

        sender.setTransaction( senderTransaction );
        recipient.setTransaction( recipientTransaction );

        sender.setBalance( sender.getBalance() - amountTransaction );
        recipient.setBalance( recipient.getBalance() + amountTransaction );


        Transaction[] transactionsSender = sender.getTransactions().toArray();
        for ( int i = 0; i < transactionsSender.length; i++ ) {
            System.out.println( transactionsSender[i].getSenderUser().getName() );
            System.out.println( transactionsSender[i].getRecipientUser().getName() );
            System.out.println( transactionsSender[i].getTransactionCategory() );
            System.out.println( transactionsSender[i].getAmount());
        }
        System.out.println( senderTransaction.getId() );
        sender.getTransactions().removeTransaction( senderTransaction.getId() );
        
        Transaction[] transactionsRecipient = recipient.getTransactions().toArray();
        for ( int i = 0; i < transactionsRecipient.length; i++ ) {
            System.out.println( transactionsRecipient[i].getSenderUser().getName() );
            System.out.println( transactionsRecipient[i].getRecipientUser().getName() );
            System.out.println( transactionsRecipient[i].getTransactionCategory() );
            System.out.println( transactionsRecipient[i].getAmount());
        }
        recipient.getTransactions().removeTransaction( recipientTransaction.getId() );

        // Test remove transactions
        Transaction[] transaction = new Transaction[4];
        TransactionsList transactions = new TransactionsLinkedList();
        System.out.println("\nVerify transaction list methods\n");
        for ( int i = 0; i < 4; i++ ) {
            transaction[i] = new Transaction( sender, recipient );
            transaction[i].setTransactionCategory( TransferCategory.CREDITS );
            transaction[i].setAmount( -1 * amountTransaction );
            System.out.println(transaction[i].getId());
            transactions.addTransaction( transaction[i] );
        }
        System.out.println("DELETE MIDDLE");
        // delete middle
        transactions.removeTransaction( transaction[2].getId() );
        Transaction[] deleteMiddle = transactions.toArray(); 
        for ( int i = 0; i < deleteMiddle.length; i++ ) {
            System.out.println(deleteMiddle[i].getId());
        }
        System.out.println("DELETE TAIL");
        // delete tail
        transactions.removeTransaction( deleteMiddle[2].getId() );
        Transaction[] deleteTail = transactions.toArray(); 
        for ( int i = 0; i < deleteTail.length; i++ ) {
            System.out.println(deleteTail[i].getId());
        }
        System.out.println("DELETE HEAD");
        // delete head
        transactions.removeTransaction( deleteTail[0].getId() );
        Transaction[] deleteHead = transactions.toArray(); 
        for ( int i = 0; i < deleteHead.length; i++ ) {
            System.out.println(deleteHead[i].getId());
        }
    } 
}