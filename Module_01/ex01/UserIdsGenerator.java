
class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private Integer id = 1;
    private UserIdsGenerator() {

    }
    
    public static UserIdsGenerator getInstance( ) {
        if ( instance == null ) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public Integer generateId() {
        return id++;
    }
}