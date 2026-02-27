
class User {
    private static int count = 0;
    private int         id;
    private String      name;
    private long        balance;
    public User ( String name, long balance) {
        this.id = count;
        this.name = name;
        this.balance = balance;
        count += 1;
    }

    public String getName( ) {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public long getBalance( ) {
        return this.balance;
    }

    public void setBalance( long balance ) {
        if ( balance > 0 ) this.balance = balance;
    }
}