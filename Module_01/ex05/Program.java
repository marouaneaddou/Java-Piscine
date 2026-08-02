
class Program {
    public static void main( String args[] ) {
        TransactionsService transactionService = new TransactionsService();
        Menu menu = new Menu( transactionService, true );
        menu.start();
    } 
}