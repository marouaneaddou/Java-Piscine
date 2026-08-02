
interface TransactionsList {
    void addTransaction( Transaction transaction );
    void removeTransaction( String id );
    Transaction[] toArray();
}