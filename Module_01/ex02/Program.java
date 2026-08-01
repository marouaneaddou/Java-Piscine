
class Program {
    public static void main( String args[] ){
        User [] users = new User[10];
        UsersArrayList userList = new UsersArrayList();
        Integer i = 0;
        for ( ; i < 10; i++ ) {
            users[i] = new User();
        }
        for ( i = 0; i < 10; i++ ) {
            userList.addUser( users[i] );
            System.out.printf("user by index: %d\n",  userList.getUserByIndex(i).getId() );
        }
        System.out.printf("size of user list is: %d\n", userList.size() );

        userList.addUser( new User() );
        System.out.printf("Size of user list is: %d\n", userList.size() );

        System.out.printf("User by id: %d\n",  userList.getUserById(1).getId() );

        System.out.printf("User by index: %d\n",  userList.getUserByIndex(9).getId() );
    } 
}