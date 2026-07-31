
class User {
    private static Integer          id = 0;
    private String                  name;
    private Integer                 balance;

    User( ) {
        id += 1;
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