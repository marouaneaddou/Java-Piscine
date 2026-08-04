
import java.io.File;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;

class Program {
    private static String[] readFile( FileReader object ) throws IOException, FileNotFoundException{
        BufferedReader input = new BufferedReader( object );
        String line;
        StringBuffer s = new StringBuffer();
        while ( ( line = input.readLine() ) != null ) {
            s.append( line );
            s.append( " " );
        }
        if ( s.length() == 0 ) return new String[0];
        return s.toString().split(" ");
    }

    private static HashSet<String> occurrenceWords( String[] str1,  String[] str2 ) {
        HashSet<String> words = new HashSet<String>();
        for ( int i = 0; i < str1.length; i++ ) {
            words.add( str1[i] );
        }
        for ( int i = 0; i < str2.length; i++ ) {
            words.add( str2[i] );
        }
        return words;
    }

    private static Integer countOccurrence( String[] data, String word ) {
        int count = 0;
        for ( int i = 0; i < data.length; i++ ) {
            if ( data[i].equals(word)) count++;
        }
        return count;
    }

    public static void main( String args[] ) {
        if ( args.length == 2 ) {
            try {
                FileReader fileA = new FileReader( args[0] );
                FileReader fileB = new FileReader( args[1] );
                String[] dataFileOne = readFile( fileA );
                String[] dataFileTwo = readFile( fileB );
                HashSet<String> words = 
                    occurrenceWords( dataFileOne, dataFileTwo );
                int size = words.size();
                ArrayList<Integer> freqWordFileOne = new ArrayList<Integer>(size);
                ArrayList<Integer> freqWordFileTwo = new ArrayList<Integer>(size);
                for ( String word : words ) {
                    freqWordFileOne.add(countOccurrence( dataFileOne, word ));
                    freqWordFileTwo.add(countOccurrence( dataFileTwo, word ));
                }
                int numerator = 0;
                int sumA = 0;
                int sumB = 0;
                for ( int i = 0; i < size; i++ ) {
                    int a = freqWordFileOne.get( i );
                    int b = freqWordFileTwo.get( i );
                    numerator +=  a * b;
                    sumA += a * a;
                    sumB += b * b;
                }
                double denominator = Math.sqrt(sumA) * Math.sqrt(sumB);
                if ( denominator != 0 && numerator != 0 ) {
                    System.out.printf("Similarity %.2f\n", numerator / denominator);
                } else {
                    System.out.printf("Similarity 0.0\n");
                }}
            catch ( Exception e ) {
                System.out.println( e.getMessage() );
            }
        }
    }
}