import java.util.UUID;

class UserNullException extends RuntimeException {
    UserNullException( String msg ) {
        super( msg );
    }
}

class InvalidTransactionTypeException extends RuntimeException {
    InvalidTransactionTypeException( String msg ) {
        super( msg );
    }
}

class IllegalTransactionException extends RuntimeException {
    IllegalTransactionException() {
        super("Sender has insufficient balance");
    }
}


enum TransferCategory {
    DEBITS,
    CREDITS
}

class Transaction {
    private final String        id;
    private User                recipient;
    private User                sender;
    private Integer             amount;      
    private TransferCategory    transferCategory;

    public Transaction( ) {
        id = UUID.randomUUID().toString();
    }

    public Transaction( User sender, User recipient ) {
        this();
        this.setSenderUser( sender );
        this.setRecipientUser( recipient );
    }

    public Transaction( User sender, User recipient, String id, Integer amount, TransferCategory type ) {
        this.id         = id;
        this.setSenderUser( sender );
        this.setRecipientUser( recipient );
        this.setTransactionCategory( type );
        this.setAmount( amount );
    }
    // id 
    public String getId( ) {
        return id;
    }
    
    // Sender User
    public void setSenderUser( User sender ) {
        if ( sender == null ) {
            throw new UserNullException( "Sender must not be null");
        }
        this.sender = sender;
    }
    public User getSenderUser( ) {
        return this.sender;
    }

    // Recipient User
    public void setRecipientUser( User recipient ) {
        if ( recipient == null ) {
            throw new UserNullException( "Recipient must not be null" );
        }
        this.recipient = recipient;
    } 
    public User getRecipientUser( ) {
        return this.recipient;
    } 

    // Amount
    public void setAmount( Integer amount ) {
        if ( amount < 0 && this.transferCategory != TransferCategory.CREDITS ) {
            throw new InvalidTransactionTypeException( "Negative amount requires CREDITS" );
        }
        else if ( amount > 0 && this.transferCategory != TransferCategory.DEBITS) {
            throw new InvalidTransactionTypeException( "Positive amount requires DEBITS" );
        }
        else if ( this.sender.getBalance() < amount ) {
            throw new IllegalTransactionException(); 
        }
        this.amount = amount;
    }
    public Integer getAmount( ) {
        return this.amount;
    }

    // Transaction Category 
    public void setTransactionCategory( TransferCategory category ) {
        this.transferCategory = category;
    }
    public TransferCategory getTransactionCategory( ) {
        return this.transferCategory;
    }
}