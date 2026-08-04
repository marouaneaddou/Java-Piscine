import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class Signature {
    private HashMap<String, byte[]> signatures = new HashMap<>();
    private byte[] hexaStringToBytes( String hexa ) {
        String[] signature = hexa.split(" ");
        byte[] result = new byte[ signature.length ];
        for ( int i = 0; i < signature.length; i++ ) {
            result[i] = (byte) Integer.parseInt( signature[i], 16 );
        }
        return result;
    }

    public Signature( String fname ) throws FileNotFoundException, IOException{
        File file = new File( fname );
        FileInputStream input = new FileInputStream(file);
        byte[] buffer = new byte[300];
        input.read( buffer );
        String str = new String( buffer );
        String[] result = str.split( "\n" );
        for ( int i = 0; i < result.length; i++ ) {
            String[] signature = result[i].split(":");
            this.signatures.put( signature[0].trim(), this.hexaStringToBytes(signature[1].trim()) ); 
        }
        input.close();
    }
    public Map<String, byte[]> getSignatures( ) {
        return this.signatures;
    }
}