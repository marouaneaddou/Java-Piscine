
class NegativeBalanceException extends RuntimeException {
    NegativeBalanceException() {
        super("Balance cannot be negative");
    }
}
class User {
    private Integer                 id;
    private String                  name;
    private Integer                 balance;
    private TransactionsLinkedList  transactions;

    User( ) {
        id = UserIdsGenerator.getInstance().generateId();
        this.transactions = new TransactionsLinkedList();
    }
    User( String name, Integer balance ) {
        this();
        this.setName( name );
        this.setBalance( balance );
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
            throw new NegativeBalanceException();
        }
        this.balance = balance;
    }
    public Integer getBalance( ) {
        return balance;
    }

    // Transactions
    public void addTransaction( Transaction transaction ) {
        this.transactions.addTransaction( transaction );
    }
    public Transaction[] getTransactions( ) {
        return this.transactions.toArray();
    }
    public void removeTransaction( String id ) {
        this.transactions.removeTransaction( id );
    }
    public boolean hasTransaction( String id ) {
        Transaction[] transactions = this.transactions.toArray();
        for ( Transaction transaction : transactions ) {
            if ( transaction.getId().equals( id )) return true;
        }
        return false;
    }
    public Transaction getTransactionById(String id) {
        return this.transactions.findById(id);
    }
}