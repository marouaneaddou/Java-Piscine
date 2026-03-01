import java.util.UUID;

enum TransferCategory {
    DEBIT,
    CREDIT
}

class Transaction {
    private UUID        id;
    private User        recipient;
    private User        sender;
    private long        amount;
    TransferCategory    category;

    public UUID getId( ) {
        return this.id;
    }

    public Transaction( User sender, User recipient, long amount ) {
        if ( sender.getBalance( ) < amount ) {

            System.err.printf("Not enough balance in %s account\n", this.sender.getName());
        }
        else if ( amount < 0 ) {
            System.err.println("Transfer amount must be positive");
        }
        else {
            this.id = UUID.randomUUID();
            this.category = "DEBIT";
            this.recipient.setBalance( amount + this.recipient.getBalance() );
            this.sender.setBalance( this.sender.getBalance() - amount );
        }
    }

    public User getSender( ) {
        return this.sender;
    }

    public User getRecipient( ) {
        return this.recipient;
    }
}