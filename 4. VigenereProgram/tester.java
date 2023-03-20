
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class tester {
    public void testerCaesarCipher(){
        CaesarCipher cc = new CaesarCipher(5);
        FileResource fr = new FileResource();
        //String message = cc.decrypt(fr.asString());
        String message = cc.encrypt(fr.asString());
        System.out.println(message);
    }
    
    public void testerCaesarCracker(){
        CaesarCracker cc = new CaesarCracker('a');
        FileResource fr = new FileResource();
        String message = cc.decrypt(fr.asString());
        System.out.println(message);
    }
    
    public void testerVigenereCipher(){
        int[] key = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource();
        String message = vc.encrypt(fr.asString());
        System.out.println(message);
    }
}
