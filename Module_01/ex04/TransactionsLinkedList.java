
class TransactionNotFoundException extends RuntimeException {
    TransactionNotFoundException() {
        super( "Transaction not found" );
    }
}

class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node tail;
    private Integer size; 

    public TransactionsLinkedList( ) {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addTransaction( Transaction transaction ) {
        if ( transaction == null ) return;
        Node newNode = new Node( transaction );
        if ( this.head == null ) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next =  newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void removeTransaction( String id ) {
        Node tmp = this.head;
        boolean isFound = false; 
        while ( tmp != null ) {
            if ( tmp.transaction.getId().equals( id ) ) {
                if ( tmp == head && tmp == tail ) {
                    this.head = null;
                    this.tail = null;
                }
                else if ( this.head == tmp ) {
                    head = head.next;
                    head.prev = null; 
                }
                else if( this.tail == tmp ) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }
                else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
                this.size--;
                isFound = true;
                break;
            }
            tmp = tmp.next;
        }
        if ( isFound == false )
            throw new TransactionNotFoundException();
    }

    @Override 
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[this.size];
        Node tmp = head;
        Integer i = 0;
        while( tmp != null ) {
            transactions[i++] = tmp.transaction;
            tmp = tmp.next;
        }
        return transactions;
    }

    class Node {
        Transaction transaction;
        Node prev;
        Node next;

        Node( Transaction transaction ) {
            this.prev = null;
            this.next = null;
            this.transaction = transaction;
        }
    }
}