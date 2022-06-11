package security;

public class SymmetricSecurity {

    private int TABLE_SIZE = 65536;
    int nPosition;

    public SymmetricSecurity(int nPosition) {
        this.nPosition = nPosition;
    }
    
    private char shift(char c, int nPos) {
        int charCode = (int)c + nPos;
        if (charCode < 0)
            charCode += TABLE_SIZE;
        return (char)(charCode % TABLE_SIZE);
    }
    
    public String encode(String src) {
        String result = "";
        for (int i = 0; i < src.length(); i++) {
            result += shift(src.charAt(i), nPosition);
        }
        return result;
    }
    
    public String decode(String encodedSrc) {
        String src = "";
        for (int i = 0; i < encodedSrc.length(); i++) {
            src += shift(encodedSrc.charAt(i), -nPosition);
            
        }
        return src;
    }

    
    public String encodeComplex(String src) {
        String result = "";
        char curChar = src.charAt(0);
        result += shift(curChar, nPosition);
        int newShift;
        char preChar;
        
        for (int i = 1; i < src.length(); i++) {
            preChar = curChar;
            newShift = (int)preChar;
            curChar = src.charAt(i);
            result += shift(curChar, newShift);
        }
        return result;
    }
    
    public String decodeComplex(String encodedSrc) {
        String result = "";
        char curChar = shift(encodedSrc.charAt(0), -nPosition);
        result += curChar;
        
        int newShift;
        for (int i = 1; i < encodedSrc.length(); i++) {
            newShift = (int)curChar;
            curChar = shift(encodedSrc.charAt(i), -newShift);
            result += curChar;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String src = "abc";
        int nPosition = 10;
        SymmetricSecurity shifter = new SymmetricSecurity(nPosition);
        System.out.println("Src: " + src);
        String encoded = shifter.encodeComplex(src);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + shifter.decodeComplex(encoded));
    }
}
