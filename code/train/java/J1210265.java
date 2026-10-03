import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		int[] letters = new int[26]; //from a-z
		for (int z = 0; z < 26; z++) {
			letters[z] = 50;
		}
		for (int x = 0; x < n; x++) {
			String s = in.nextLine();
			int[] nletters = new int[26];
			for (int y = 0; y < s.length(); y++) {
				int a = alphabetExchange(s.charAt(y)) - 1;
				if (letters[a] != -1) {
					nletters[a]++;
				}
			}
			
			for (int z = 0; z < 26; z++) {
				if (nletters[z] == 0) {
					letters[z] = -1;
				} else {
					if (nletters[z] < letters[z]) {
						letters[z] = nletters[z];
					}
				}
			}
		}
		
		String result = "";
		for (int x = 0; x < 26; x++) {
			if (letters[x] > 0) {
				String letter = alphabetExchangeOpp(x + 1);
				for (int y = 0; y < letters[x]; y++) {
					result += letter;
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	public static int alphabetExchange(char l) {
		int num = 0;
		switch (l) {
		case 'a':
			num = 1; break;
		case 'b':
			num = 2; break;
		case 'c':
			num = 3; break;
		case 'd':
			num = 4; break;
		case 'e':
			num = 5; break;
		case 'f':
			num = 6; break;
		case 'g':
			num = 7; break;
		case 'h':
			num = 8; break;
		case 'i':
			num = 9; break;
		case 'j':
			num = 10; break;
		case 'k':
			num = 11; break;
		case 'l':
			num = 12; break;
		case 'm':
			num = 13; break;
		case 'n':
			num = 14; break;
		case 'o':
			num = 15; break;
		case 'p':
			num = 16; break;
		case 'q':
			num = 17; break;
		case 'r':
			num = 18; break;
		case 's':
			num = 19; break;
		case 't':
			num = 20; break;
		case 'u':
			num = 21; break;
		case 'v':
			num = 22; break;
		case 'w':
			num = 23; break;
		case 'x':
			num = 24; break;
		case 'y':
			num = 25; break;
		case 'z':
			num = 26; break;
		}
		return num;
	}
	
	public static String alphabetExchangeOpp(int l) {
		String letter = "";
		switch (l) {
		case 1:
			letter = "a";break;
		case 2:
			letter = "b";break;
		case 3:
			letter = "c";break;
		case 4:
			letter = "d";break;
		case 5:
			letter = "e";break;
		case 6:
			letter = "f";break;
		case 7:
			letter = "g";break;
		case 8:
			letter = "h";break;
		case 9:
			letter = "i";break;
		case 10:
			letter = "j";break;
		case 11:
			letter = "k";break;
		case 12:
			letter = "l";break;
		case 13:
			letter = "m";break;
		case 14:
			letter = "n";break;
		case 15:
			letter = "o";break;
		case 16:
			letter = "p";break;
		case 17:
			letter = "q";break;
		case 18:
			letter = "r";break;
		case 19:
			letter = "s";break;
		case 20:
			letter = "t";break;
		case 21:
			letter = "u";break;
		case 22:
			letter = "v";break;
		case 23:
			letter = "w";break;
		case 24:
			letter = "x";break;
		case 25:
			letter = "y";break;
		case 26:
			letter = "z";break;
		}
		return letter;
	}

}
