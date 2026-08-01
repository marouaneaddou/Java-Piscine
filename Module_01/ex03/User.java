
class User {
    private Integer                 id;
    private String                  name;
    private Integer                 balance;
    private TransactionsList        transactions;

    User( ) {
        id = UserIdsGenerator.getInstance().generateId();
        this.transactions = new TransactionsLinkedList();
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
    public void setBalance( Integer balance ) {
        if ( balance < 0 ) {
            System.err.println("Balance cannot be negative");
            return;
        }
        this.balance = balance;
    }
    public Integer getBalance( ) {
        return balance;
    }

    // Transactions
    public void setTransaction( Transaction transaction ) {
        this.transactions.addTransaction( transaction );
    }
    public TransactionsList getTransactions( ) {
        return this.transactions;
    }
}