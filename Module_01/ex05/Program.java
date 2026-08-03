
class Program {
    public static void main( String args[] ) {
        if ( args.length == 1 && (args[0].equals("--profile=dev") || args[0].equals("--profile=prod"))) {
            TransactionsService transactionService = new TransactionsService();
            Menu menu = new Menu( transactionService, args[0].equals("--profile=dev") ? true: false );
            menu.start();
        }
    } 
}