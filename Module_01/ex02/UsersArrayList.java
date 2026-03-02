class UserNotFoundException extends RuntimeException {
    UserNotFoundException( String msg ) {
        super( msg );
    } 
}

class  UserArrayList implements UsersList {

    private User[] users;
    private int count;
    private int maxSize;

    UserArrayList() {
        this.maxSize = 2;
        this.count = 0;
        this.users = new User[ this.maxSize ];
    }

    public void addUser( User user ) {
        if ( count == this.maxSize ) {
            this.maxSize += this.maxSize / 2;
            User[] arr = new User[ this.maxSize ];
            for ( int i = 0; i < count; i++ ) {
                arr[i] = this.users[i];
            }
            users = arr;
        }
        users[ count ] = user;
        count += 1;
    }

    public User getUserById( int id ) {
        for ( int i = 0; i < this.count; i++ ) {
            int x = this.users[i].getUserId( );
            if (  x == id ) 
                return this.users[i];
        }
        throw new UserNotFoundException( "User not found" );
    }

    public User getUserByIndex( int index ) {
        if ( index < 0 || index > this.count )
            throw new UserNotFoundException( "User not found" );
        return users[ index ];
    }

    public int  size( ) {
        return this.count;
    }
}
    
