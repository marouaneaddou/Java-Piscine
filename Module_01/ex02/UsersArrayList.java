
class UserArrayList extends UserList {

    private User[] users;
    private int count;
    private int maxSize;
    UserArrayList() {
        this.maxSize = 10;
        this.count = 0;
        this.users = new User[ this.maxSize ];
    }
}
    
