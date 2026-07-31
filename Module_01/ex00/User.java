
class User {
    private static Integer          id;
    private String                  name;
    private Integer                 balance;

    public User( ) {
        this.id = UserIdsGenerator.getInstance().generateId();
    }
    // id
    public Integer getId( ) {
        return this.id;
    }
    // Name
    public void setName( String name ) {
        this.name = name;
    }
    public String getName( ) {
        return this.name;
    }

    // Balance
    public Integer getBalance( ) {
        return balance;
    }
    public void setBalance( Integer balance ) {
        if ( balance < 0 ) {
            System.err.println("Balance cannot be negative");
            return;
        }
        this.balance = balance;
    }
}