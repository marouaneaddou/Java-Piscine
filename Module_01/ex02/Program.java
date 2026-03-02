
class Program {
    public static void main ( String[] args ) {

        User sender = new User( "Mohammed", 500 );
        User recipient = new User( "Said", 200 );

        UsersList users = new UserArrayList( );

        System.out.printf( "%d\n", users.size() );

        users.addUser( sender );
        
        System.out.printf( "%d\n", users.size() );

        users.addUser( recipient );
        
        System.out.printf( "%d\n", users.size() );

        try {
            User first = users.getUserById( 1 );
            System.out.printf( "%s\n", first.getName() );

            User second = users.getUserByIndex( 1 );
            System.out.printf( "%s\n", second.getName() );
        }
        catch ( UserNotFoundException e ) {
            System.out.printf( "%s\n", e );
        }
    } 
}