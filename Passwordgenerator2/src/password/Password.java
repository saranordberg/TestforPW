package password;

import java.util.Random;

public class Password {

	
	public static String generatePassword(){
		int length = 8;
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#€%$&/()=[]{}";
		Random rnd = new Random();
		
		StringBuilder sb = new StringBuilder( length );
		for( int i = 0; i < length; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		
	   return sb.toString();
	}
	public boolean passwordValidation(String password) {
		boolean out;
		int checks = 0;
		if (password.length() <= 5) {
			return false;
		}
		if (checkLetters(password)) {
			checks++;
		}
		if (checkCapitals(password)) {
			checks++;
		}

		if (checkNumbers(password)) {
			checks++;
		}

		if (checkSymbols(password)) {
			checks++;
		}

		if (checks >= 3) {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkLetters(String x) {
		boolean loop = true;
		int i = 97;
		int j;
		while (loop) {
			j = x.indexOf(i);
			if (j >= 0) {
				return true;
			}
			i++;
			if (i >= 123)
				;
		}
		return false;
	}

	public boolean checkCapitals(String x) {
		boolean loop = true;
		int i = 65;
		int j;
		while (loop) {
			j = x.indexOf(i);
			if (j >= 0) {
				return true;
			}
			i++;
			if (i >= 91)
				;
		}
		return false;
	}

	public boolean checkNumbers(String x) {
		boolean loop = true;
		int i = 48;
		int j;
		while (loop) {
			j = x.indexOf(i);
			if (j >= 0) {
				return true;
			}
			i++;
			if (i >= 58)
				;
		}
		return false;
	}

	public boolean checkSymbols(String x) {
		boolean loop = true;
		int i = 0;
		int j;
		int[] k = { 46, 45, 95, 43, 33, 63, 61 };
		while (loop) {
			j = x.indexOf(k[i]);
			if (j >= 0) {
				return true;
			}
			i++;
			if (i >= 7) {
				return false;
			}
		}
		return false;
	}

	public static int[] generateAsciiTable() {
		int[] out = new int[70];
		int k = 97;
		for (int i = 0; i < 26; i++) {
			out[i] = k;
			k++;
		}
		k = 65;
		for (int i = 26; i < 53; i++) {
			out[i] = k;
			k++;
		}
		k = 48;
		for (int i = 53; i < 63; i++) {
			out[i] = k;
			k++;
		}
		out[63] = 46;
		out[64] = 45;
		out[65] = 95;
		out[66] = 43;
		out[67] = 33;
		out[68] = 63;
		out[69] = 61;
		return out;
	}
}
