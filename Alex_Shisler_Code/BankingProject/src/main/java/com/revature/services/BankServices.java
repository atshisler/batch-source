package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankImpl;
import com.revature.project0.BankUser;
import com.revature.view.BankViewer;

/*
 * Controller 
 */
public class BankServices {

	private Scanner reader;
	private BankViewer viewer = new BankViewer();
	private int logDex = -1;
	private boolean logged = false;
	private boolean loginScr = true;
	private boolean accountCreation = false;
	private boolean deposit = false;
	private boolean withdrawal = false;
	private boolean isAccessible = false;
	private boolean exit = false;
	private static BankServices bankService;
	private BankImpl data;

	private BankServices() {
		super();
		data = data.getBankDao();
		reader = new Scanner(System.in);
	}

	/*-------------------------------------------------*/
	public static BankServices getBankService() {
		if (bankService == null) {
			bankService = new BankServices();
		}
		return bankService;
	}

	public BankUser getBankerDetails() {
		return data.getBankUser();
	}

	public List<BankUser> listAllBankCustomers() {
		return data.getAllBankCusts();
	}
	/*---------------------Getters---------------------------*/

	public void start() {
		viewer.displayLogo();
		while(!exit) {
		if (!logged) {
			viewer.signInOptions();
			loginMenu();
		}//loginOptions
		else {
			accountOptions();
		}//accountOptions
		}//loop
		
	}

	public void loginMenu() {
		int choice = reader.nextInt();
		switch (choice) {
		case 1:
			accountCreation();
			accountCreation = true;
			loginScr = false;
			deposit = false;
			withdrawal = false;
			break;

		case 2:
			logIn();
			accountCreation = false;
			loginScr = true;
			deposit = false;
			withdrawal = false;
			break;

		default:
			System.out.println("Invalid input");
			break;
		}
	}

	// finish implementation
	public void accountCreation() {
		String wordInput;
		viewer.namePrompt();
		wordInput = reader.next();
		viewer.passwordPrompt();
		wordInput = reader.next();

	}// accountCreation process

	public void logIn() {
		viewer.namePrompt();
		String user;
		String pass;
		user = reader.next();
		viewer.passwordPrompt();
		pass = reader.next();
		logDex = data.Login(user, pass);
		if (logDex != -1) {
			System.out.println("Hello " + listAllBankCustomers().get(logDex).getFirstName() + ".");
			logged = true;
		}
		else
			System.out.println("Invalid login credentials, please try again");

	}//logIn
	
	public void accountOptions() {
		viewer.accountOptions();
		switch (reader.nextInt()) {
		case 1:
			deposit();
			break;

		case 2:
			withdrawal();
			break;
		case 3:
			checkBalance();
			break;
		case 4:
			logOut();
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
	}
	
	public void deposit() {
		viewer.depositDisplay();
		double amount;
		amount = reader.nextDouble();
		data.deposit(amount);
	}
	
	public void withdrawal() {
		viewer.withdrawalDisplay();
		double amount;
		amount = reader.nextDouble();
		data.withdrawal(amount);
	}
	
	public void checkBalance() {
		data.getAccountInfo();
		viewer.displayBalance(data.getBankUser().getAccountBal());
	}
	
	public void logOut() {
		viewer.logOutView();
		logDex = -1;
		logged = false;
		exit = true;
	}
	/*----------------------Methods-------------------------*/
}
