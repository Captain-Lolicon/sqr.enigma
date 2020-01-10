package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;
	
	/** Permet de retourner un reflector contenant un tableau de int. La fontion permet de convertir une chaine de 
	* charactère en un tableau de charactère sans espace et de
	*/
	
	public static Reflector reflectorFactory(String str){			//Doit être testé
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){
		super(r,0);
		reflection = r;
	}
	
    public int convertForward(int p) {								//Doit être testé
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) {						// ???
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
