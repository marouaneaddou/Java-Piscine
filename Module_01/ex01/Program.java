
class Program {
    static void main( String args[] ) {
        User u1 = new User();
        System.out.println( u1.getId() );

        User u2 = new User();
        System.out.println( u2.getId() );

        // Verify that only one UserIdsGenerator instance exists
        UserIdsGenerator generator1 = UserIdsGenerator.getInstance();
        UserIdsGenerator generator2 = UserIdsGenerator.getInstance();
        if ( generator1 == generator2 ) {
            System.out.println("Instance are the same");
        }
        else {
            System.out.println("Instance are not the same");
        }
    }
}