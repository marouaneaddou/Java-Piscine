import java.util.Scanner;

class Program {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        long gradesOne = 0;
        long gradesTwo = 0;
        while ( counter < 18 ) {
            System.out.printf("-> ");
            if ( scanner.hasNext() ) {
                String week = scanner.nextLine();
                if ( week.equals( "42" ) ) break;
                else if ( !week.equals( "Week " + (counter + 1))) {
                    System.out.printf("IllegalArgument");
                    System.exit( -1 );
                }
                int min = 10;
                System.out.printf("-> ");
                for ( int i = 0; i < 5 && scanner.hasNextInt(); i++  ) {
                    int nb = scanner.nextInt();
                    if ( nb >= 0 &&  nb < min ) min = nb;
                }
                String t = scanner.nextLine();
                if ( counter <= 15 ) gradesOne = gradesOne |  (min << ( counter * 4 ));
                else gradesTwo = gradesTwo |  (min << ( counter * 4 ));
                
                counter++;
            }
        }
        int minGrade = 0;
        for ( int i = 0; i < counter; i++ ) {
            if ( counter <= 15 )
                minGrade = (int)(( gradesOne >> ( 4 * i )) & 15);
            else 
                minGrade = (int)(( gradesOne >> ( 4 * i )) & 15);
            System.out.printf("Week %d ", i + 1 );
            for ( int j = 0; j < minGrade; j++ ) {
                System.out.printf("=");
            }
            System.out.printf(">\n");
        }
    }
}