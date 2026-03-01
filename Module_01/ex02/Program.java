
class Program {
    public static void main ( String[] args ) {

        User sender = new User( "Mohammed", 500 );
        User recipient = new User( "Said", 200 );

        System.out.printf( "Id of sender is %d\n", sender.getUserId() );
        System.out.printf( "Id of recipient is %d\n\n", recipient.getUserId() );

        UserIdsGenerator id1 = UserIdsGenerator.getInstance();
        UserIdsGenerator id2 = UserIdsGenerator.getInstance();
        System.out.println( id1 == id2 );
        System.out.println( sender == recipient );

        
    } 
}