package Controller;
import java.util.Scanner;

import DAL.iOperatorDAO;
import user.OperatorDTO;

public class Controller {

	OperatorDTO[] users;
	int currentID, lastAdded;
	Scanner keyboard;

	public Controller(iOperatorDAO iod) {
		users = new OperatorDTO[88];
		lastAdded = 0;
		currentID = 11;
		keyboard = new Scanner(System.in);
		initSystemAdmin();

	}
	public Controller() {
		users = new OperatorDTO[88];
		lastAdded = 0;
		currentID = 11;
		keyboard = new Scanner(System.in);
		initSystemAdmin();
	}

	public void addUser() {
		keyboard = new Scanner(System.in);
		System.out.println("Skriv brugerens navn:");
		String navn = keyboard.nextLine();
		System.out.println("Skriv brugerens CPR:");
		long cpr = keyboard.nextLong();
		users[lastAdded] = new OperatorDTO(navn, cpr, currentID);
		System.out.println("Dit userId er: " + currentID);
		System.out.println("Dit password er: " + users[lastAdded].getPassword());
		currentID++;
		lastAdded++;
	}

	public void initSystemAdmin() {
		users[lastAdded] = new OperatorDTO("Martin Dalby", 0000000001, currentID);
		// users[lastAdded].setPassword("aA1bB2=");
		users[lastAdded].setSysAdmin(true, "P4ssword");
		currentID++;
		lastAdded++;

	}

	public OperatorDTO getOperator(int id) {
		try {
			return users[id - 11];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Max user ID er 99");
			return null;
		}

	}

	public void deleteUser(int oprId) {
		if (oprId-11 == 0){
			System.out.println("Du kan ikke slette basis admin");
		} else {
			users[oprId-11] = null;	
			System.out.println("Brugeren er nu slettet");
		}
		
	}

	public void updateUser(int oprId) {
		boolean loop = true;
		while (loop) {
			System.out.println();
			System.out.println("Du er ved at ændre i " + users[oprId-11].getOprNavn());
			System.out.println("1. Skift navn");
			System.out.println("2. Skift password");
			System.out.println("3. Skift cpr");
			System.out.println("4. Set bruger til admin");
			System.out.println("5. Slet bruger");
			System.out.println("6. Afslut");
			System.out.println();
			keyboard = new Scanner(System.in);
			switch (keyboard.nextInt()) {
			case 1:
				System.out.println("Skriv hvad du vil ændre navnet på brugeren til:");
				users[oprId-11].setOprNavn(keyboard.next());
				break;
			case 2:
				System.out.println("Du er ved at ændre password for brugeren: " + users[oprId-11].getOprNavn());
				users[oprId-11].generatePassword();
				System.out.println("Det nye password er: " + users[oprId-11].getPassword());
				break;
			case 3:
				System.out.println("Skriv hvad du vil ændre cpr til:");
				users[oprId-11].setCpr(keyboard.nextLong());
				break;
			case 4:
				System.out.println("Den nye admin er:  " + users[oprId-11].getOprNavn());
				System.out.println("Skriv hvad det nye admin password skal være:");
				users[oprId-11].setSysAdmin(true, keyboard.next());
				break;
			case 5:
				System.out.println("Du er ved at slette følgende bruger:  " + users[oprId-11].getOprNavn());
				System.out.println("Er du sikker? Tryk 1 for ja, tryk 2 for nej");
				switch(keyboard.nextInt()){
				case 1:
					deleteUser(oprId);
					loop = false;
					break;
				case 2: 
					break;
				}
				break;
			case 6:
				loop = false;
				break;
			}
		}
	}
	public double afVejning(){
		System.out.println("Skriv netto vægten");
		double netto = keyboard.nextDouble();
		System.out.println("Skriv tara vægten");
		double tara = keyboard.nextDouble();
		System.out.println("Vægten er : ");
		return netto-tara;
	}
}
