package user;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OperatorDTO {
	private int oprId;
	private String oprNavn;
	private String ini;
	private long cpr;
	private String password;
	private ArrayList<Integer> Users = new ArrayList<Integer>();
	private boolean SysAdmin;
	private Scanner keyboard;

	{

		for (int i = 11; i <= 99; i++) {
			Users.add(i);
		}
	}

	private int userCounter = 0;

	public OperatorDTO(String oprNavn, long cpr, int oprid) {
		this.oprId = oprid;
		this.oprNavn = oprNavn;
		this.ini = generateIni(oprNavn);
		this.cpr = cpr;
		this.setSysAdmin(false, "");
		this.password = generatePassword();

	}

	public String getOprNavn() {
		return oprNavn;
	}

	public void setOprNavn(String navn) {
		this.oprNavn = navn;
	}

	public String getIni() {
		return ini;
	}

	public long getCpr() {
		return cpr;
	}
	public void setCpr(long cpr) {
		this.cpr = cpr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String generateIni(String name) {
		String out;
		out = name.substring(0, 1);
		int space = name.indexOf(32);
		out = (out + name.substring(space + 1, space + 2));
		return out;
	}

	public int getOprId() {
		return oprId;
	}

	public void setOprId(int oprId) {
		this.oprId = oprId;
	}

	public String generatePassword(){
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

	public boolean isSysAdmin() {
		return SysAdmin;
	}

	public void setSysAdmin(boolean SysAdmin, String pw) {
		this.password = pw;
		this.SysAdmin = SysAdmin;
	}
	public void resetPassword(String password){
		this.password = password;
	}
}