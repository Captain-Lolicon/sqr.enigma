package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() {		//Non tester par inspection car Getter
        return position;
    }

    public void setPosition(int posn) {		//Non tester par inspection car Setter
        position = posn;
    }
    
	public static Rotor rotorFactory(String str, String notches){	// A besoin d'�tre test�
		char[] s = str.trim().replace(" ", "").toCharArray();		//retire tout les espaces de la chaine de caract�re et la mets dans un tableau
		int[] cipher = new int[26];									//cipher -> Nouveau tableau de Int de taille 26
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);								//Rempli cipher avec le char de s[i] - A
		}
		
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){	
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) {								//Doit �tre test�
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) {								//Doit �tre test�
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    public void advance() {											//Doit �tre test�
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {									//Pas besoin de test
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {							//Pas besoin de test
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {							//Pas besoin de test
        return c - 'A';
    }
    
	private void createBCipher() {									//Doit �tre test�
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
