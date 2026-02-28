
class User {
    private final int         id;
    private String      name;
    private long        balance;
    
    public User ( String name, long balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }

    public int getUserId( ) {
        return this.id;
    }

    public String getName( ) {
        return this.name;
    }

    public long getBalance( ) {
        return this.balance;
    }

}