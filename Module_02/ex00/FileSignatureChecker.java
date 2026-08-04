
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class FileSignatureChecker {

    private boolean matchSigniture( byte[] signature, byte[] fileSigniture ) {
        for ( int i = 0; i < signature.length; i++ ) {
            if ( signature[i] != fileSigniture[i] ) return false;
        }
        return true;
    }

    public FileSignatureChecker(){};

    public String exists( String path, Map<String, byte[]> signatures ) throws FileNotFoundException, IOException {
        File file = new File( path );
        FileInputStream input = new FileInputStream( file );
        byte[] buffer = new byte[12];
        input.read( buffer );
        for ( Map.Entry<String, byte[]> entry : signatures.entrySet() ) {
            if ( this.matchSigniture( entry.getValue() ,buffer ) == true) return entry.getKey();
        }
        input.close();
        return "";
    }
}