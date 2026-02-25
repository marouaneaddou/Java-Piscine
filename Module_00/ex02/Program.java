import java.util.Scanner;

class Program {
    static int sumNumber( int nb ) {
        int sum = 0;
        for ( ; nb != 0; ) {
            sum += nb % 10;
            nb = nb / 10;
        }
        return sum;
    }

    static int isPrim( int nb ) {
        boolean     x   = true;
        for (  int i = 2; ; i++ ) {
            if ( nb % i == 0 ) {
                x = false;
                break;
            }
            if ( i * i >= nb ) break;
        }
        return x == true ? 1 : 0;
    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int nb = 0, count = 0;
        System.out.printf("-> ");
        while ( scanner.hasNext() ) {
            nb = scanner.nextInt();
            if ( nb == 42 ) {
                System.out.printf( "Count of coffee-reques : %d", count );
                System.exit( 0 );
            }
            count += isPrim(sumNumber( nb ));
            System.out.printf("-> ");
        }
    }
}