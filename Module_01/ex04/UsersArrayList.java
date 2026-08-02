
class UserNotFoundException extends RuntimeException {
    UserNotFoundException( ) {
        super("User not found");
    }
}

class UsersArrayList implements UsersList {
    private User [] users;
    private Integer size;
    private Integer capacity;
    UsersArrayList( ) {
        this.capacity = 10;
        this.size = 0;
        this.users = new User[ this.capacity ];
    }

    @Override
    public void addUser( User user ) {
        if ( user == null ) return;
        if ( this.size == this.capacity ) {
            this.capacity += this.capacity / 2;
            User [] newUsers = new User[this.capacity];
            for( Integer i = 0; i < size; i++ ) {
                newUsers[i] = this.users[i];
            }
            this.users = newUsers;
        }
        this.users[size++] = user;
    }

    @Override
    public User getUserById( Integer id ) {
        for ( Integer i = 0; i < this.size; i++ ) {
            if ( this.users[i].getId() == id ) return this.users[i];
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex( Integer index ) {
        if ( index < 0 || index >= this.size ) throw new UserNotFoundException();
        return this.users[ index ];
    }

    @Override
    public Integer size( ) {
        return this.size;
    }

    public User[] getUsers( ) {
        User[] userResonse = new User[this.size];
        for ( Integer i = 0; i < this.size; i++ ) {
            userResonse[i] = this.users[i];
        }
        return userResonse;
    }
}