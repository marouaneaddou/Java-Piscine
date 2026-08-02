import java.util.UUID;

class TransactionsService {
    private UsersArrayList users;

    public TransactionsService( ) {
        this.users = new UsersArrayList();
    }

    public User addUser( String name, Integer balance ) {
        final User user = new User( name, balance );
        users.addUser( user );
        return user;
    }

    public Integer getUserBalance( Integer id ) {
        return users.getUserById( id ).getBalance();
    }

    public void transfer( Integer senderId, Integer recipientId, Integer amount ) {
        final User sender       =   this.users.getUserById( senderId );
        final User recipient    =   this.users.getUserById( recipientId );
        final String tranId     =   UUID.randomUUID().toString();
        final Transaction senderTransaction     = new Transaction( sender, recipient, tranId, -1 * amount,  TransferCategory.CREDITS);
        final Transaction recipientTransaction  = new Transaction( sender, recipient, tranId, amount,  TransferCategory.DEBITS);
        sender.addTransaction( senderTransaction );
        recipient.addTransaction( recipientTransaction );
        sender.setBalance( sender.getBalance() - amount );
        recipient.setBalance( recipient.getBalance() + amount );
    }

    public Transaction[] getUserTransactions( Integer userId ) {
        final User user = this.users.getUserById( userId );
        return user.getTransactions();
    }

    public void removeTransaction( String tranId, Integer userId ) {
        final User user = this.users.getUserById( userId );
        user.removeTransaction( tranId );
    }

    public Transaction[] checkValidity( ) {
        TransactionsList unpairedTransaction = new TransactionsLinkedList();
        for ( User user : this.users.getUsers() ) {
            for ( Transaction transaction : user.getTransactions() ) {
                if ( transaction.getSenderUser().hasTransaction( transaction.getId() ) !=
                    transaction.getRecipientUser().hasTransaction( transaction.getId() )) {
                        unpairedTransaction.addTransaction( transaction );
                    }
            }
        }
        return unpairedTransaction.toArray();
    }

    public User[] getUsers() {
        return users.getUsers();
    }
} 