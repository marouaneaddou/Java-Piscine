import java.util.UUID;

enum TransferCategory {
    DEBIT,
    CREDIT
}

class Transaction {
    String              id;
    User                recipient;
    User                sender;
    long                amount;
    TransferCategory    category;

    public void setAmount( long amount ) {
        if ( amount < 0 ) {
            System.err.println("Transfer amount must be positive");
        }
        else 
            this.amount = amount;
    }

    public long getAmount( ) {
        return this.amount;
    }

    public void transferAmount( ) {
        if ( this.sender.getBalance( ) < this.amount ) {
            System.err.printf("Not enough balance\n");
        }
        else {
            this.recipient.setBalance( this.amount + this.recipient.getBalance() );
            this.sender.setBalance( this.sender.getBalance() - this.amount );
        }
    }
}