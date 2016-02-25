package main;

import Controller.Controller;
import DAL.DAL;
import DAL.iOperatorDAO;
import tui.TUI;

public class Main{
	
	
	public static void main(String[] args){
	iOperatorDAO iod = new DAL();
	Controller control = new Controller(iod);
	TUI tui = new TUI(control);
	tui.run();
	}
}
