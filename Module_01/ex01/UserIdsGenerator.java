
class UserIdsGenerator {
    private static UserIdsGenerator instence; 
    private static int id;

    public int generateId( ) {
        id += 1;
        return id;
    }

    public static UserIdsGenerator getInstance( ) {
        if ( instence == null ) 
            instence = new UserIdsGenerator();
        return instence;
    }
}