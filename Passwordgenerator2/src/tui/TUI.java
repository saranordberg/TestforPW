package tui;

import java.util.Scanner;

import Controller.Controller;
import user.OperatorDTO;

public class TUI {

	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	private OperatorDTO loggedin = null;

	public TUI(Controller controller) {
		this.controller = controller;
	}

	public void run() {

		while (true) {
			System.out.println();
			System.out.println("Velkommen!");
			System.out.println("1. Opret ny bruger");
			System.out.println("2. Skift password");
			System.out.println("3. Afvejning");
			System.out.println("4. Afslut");
			if (loggedin == null) {
				System.out.println("5. log-in");
			} else if (loggedin != null) {
				System.out.println("5. log ud");
			}
			if (loggedin != null && loggedin.isSysAdmin()) {
				System.out.println("6. Admin controls");
			}
			System.out.println();
			switch (sc.nextInt()) {

			case 1:
				if (loggedin != null) {
					if (loggedin.isSysAdmin()) {
						controller.addUser();
					} else {
						System.out.println("Access denied");
					}
				} else {
					System.out.println("Log in først");
				}
				break;

			case 2:
				String gamlePw;
				String newPw = null;
				System.out.println("Skriv dit gamle password");
				gamlePw = sc.next();
				if (gamlePw.equals(loggedin.getPassword())) {
					do {
						if (newPw == null)
							System.out.println("Skriv dit nye password");
						else {
							System.out.println("Dit password skal overholde mindst 3 af følgende:");
							System.out.println("Minimum 6 tegn");
							System.out.println("Tal");
							System.out.println("Store og små bogstaver");
							System.out.println("Specielle tegn");
						}

						newPw = sc.next();
					} while (!loggedin.passwordValidation(newPw));

					System.out.println("Skriv dit nye password igen");

					if (newPw.equals(sc.next())) {
						System.out.println("Du har skiftet dit password");
						loggedin.setPassword(newPw);
					} else {
						System.out.println("Dit password matcher ikke");
					}
				} else {
					System.out.println("Forkert password");
				}
				break;

			case 3:
				controller.afVejning();
				break;

			case 4:
				System.out.println("Systemet lukker");
				System.exit(0);
				break;

			case 5:
				if (loggedin != null) {
					loggedin = null;
				} else if (loggedin == null) {
					loggedin = null;
					System.out.println("Skriv dit user ID og dit password:");
					int id = sc.nextInt();
					String pass = sc.next();
					try {
						if (controller.getOperator(id).getPassword().equals(pass)) {
							System.out.println("Du er logget ind i systemet");
							loggedin = controller.getOperator(id);
						} else {
							System.out.println("Forkert password");
						}
					} catch (NullPointerException e) {
						System.out.println("User ID findes ikke");
					}
				}
				break;
			case 6:
				if (loggedin != null && loggedin.isSysAdmin()) {
					System.out.println("Skriv oprId på den person du vil ændre på:");
					int brugerId = sc.nextInt();
					if (controller.getOperator(brugerId) != null) {
						controller.updateUser(brugerId);
					} else {
						System.out.println("oprId findes ikke.");
					}
				}
				break;
			}

		}
	}
}
