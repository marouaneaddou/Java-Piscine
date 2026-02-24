import java.util.Scanner;

class Program {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        if ( !scanner.hasNextInt() ) {
            System.out.println( "IllegalArgument" );
            System.exit(1);
        }
        int         nb  = scanner.nextInt();
        if ( nb < 2 ) {
            System.out.println( "IllegalArgument" );
            System.exit(1);
        }
        boolean     x   = true;
        int         i   = 2;
        for ( ; ; i++ ) {
            if ( nb % i == 0 ) {
                x = false;
                break;
            }
            if ( i * i >= nb ) break;
        }
        System.out.printf( "%b %d" ,x , i - 1);
    }
}