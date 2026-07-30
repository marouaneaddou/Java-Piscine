import java.util.Scanner;

class Program {
    final private static int MAX = 65536;
    private static int[][] topTenFreq( int[] freq ) {
        int[][] top10 = new int[10][2];
        for ( int i = 0; i < MAX; i++ ) {
            if ( freq[i] == 0 ) continue;
            for ( int p = 0; p < 10; p++ ) {
                
                if ( freq[i] >= top10[p][1] ) {
                    if ( freq[i] == top10[p][1] ) p++;
                    for ( int x = 9; x > p ; x-- ) {
                        top10[x][0] = top10[x - 1][0];
                        top10[x][1] = top10[x - 1][1];
                    }
                    top10[p][0] = i;
                    top10[p][1] = freq[i];
                    break;
                }
                
            }

        }
        return top10;
    }

    private static void printHistogram( int[][] matrix ) {
        int max = matrix[0][1];
        for (int row = 10; row >= 0; row--) {
            for (int col = 0; col < 10; col++) {
                if ( matrix[col][1] == 0 ) break;
                int height = (matrix[col][1] * 10) / max;
                if ( height == row ) {
                    System.out.printf("%d  ", matrix[col][1]);
                }
                else if (height > row) {
                    System.out.print("#   ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        for (int col = 0; col < matrix.length; col++) {
            System.out.printf("%c   ", (char) matrix[col][0]);
        }
        System.out.println();
    }

    private static void printTopTen( int[][] top10 ) {
        System.out.println();
        for ( int i = 0; i < 10; i++ ) {
            System.out.printf( "%c %d\n", (char)top10[i][0], top10[i][1]);
        }
    }
    private static void printFreq( int[] freq ) {
        System.out.println();
        for ( int i = 0; i < MAX; i++ ) {
            if ( freq[i] == 0 ) continue;
            System.out.printf( "%c %d\n", (char)i, freq[i]);
        }
    }

    public static  void main( String[] args ) {
        int freq[] = new int[MAX];
        String line;
        Scanner scanner =  new Scanner( System.in );
        System.out.printf("-> ");
        if (  scanner.hasNextLine() ) {
            line = scanner.nextLine();
            for ( char c : line.toCharArray() ) {
                freq[(int)c]++;
            }
            // printFreq( freq );
            int[][] matrix = topTenFreq( freq );
            // printTopTen( matrix );
            printHistogram( matrix );
        }
        scanner.close();
    }
}