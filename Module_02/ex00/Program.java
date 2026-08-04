
import java.util.Scanner;
import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;

class Program {
    public static void main( String args[] ) {
        Scanner scanner = new Scanner( System.in );
        String link = "";
        try{
            File file = new File("result.txt");
            file.createNewFile();
            FileOutputStream output = new FileOutputStream( file );
            Signature sign = new Signature("signatures.txt");
            Map<String, byte[]> signatures = sign.getSignatures();
            FileSignatureChecker checker = new FileSignatureChecker();
            String ext;
            while ( !link.equals("42") ) {
                System.out.printf("-> ");
                link = scanner.nextLine();
                ext = checker.exists( link, signatures );
                if ( !ext.isEmpty() ) {
                    output.write( ext.getBytes() );
                    output.write('\n');
                }
                System.out.println("PROCESSED");
            }
            output.close();
        }
        catch (Exception e ) {
            System.out.printf("%s\n", e.getMessage());
        }
    }
}