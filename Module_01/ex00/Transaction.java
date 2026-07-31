import java.util.UUID;

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

    Transaction( ) {
        id = UUID.randomUUID().toString();
    }
    // id 
    public String getId( ) {
        return id;
    }
    
    // Sender User
    public void setSenderUser( User sender ) {
        if ( sender == null ) {
            System.err.println("Sender must not be null");
            return;
        }
        this.sender = sender;
    }
    public User getSenderUser( ) {
        return this.sender;
    }

    // Recipient User
    public void setRecipientUser( User recipient ) {
        if ( recipient == null ) {
            System.err.println("Recipient must not be null");
            return;
        }
        this.recipient = recipient;
    } 
    public User getRecipientUser( ) {
        return this.recipient;
    } 

    // Amount
    public void setAmount( Integer amount ) {
        if ( amount < 0 && this.transferCategory != TransferCategory.CREDITS ) {
            System.err.println("Negative amount requires CREDITS");
            return;
        }
        else if ( amount > 0 && this.transferCategory != TransferCategory.DEBITS) {
            System.err.println("Positive amount requires DEBITS.");
            return;
        }
        else if ( this.sender.getBalance() < amount ) {
            System.err.println("Sender has insufficient balance");
            return;
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