package com.revature.view;

import com.revature.services.BankServices;

public class BankViewer {
	
	private BankServices services;
	
	public BankViewer() {
		
	}
	
	public void displayLogo() {
		System.out.println("Welcome to Bank of Cash!");
	}
	
	public void signInOptions() {
		System.out.println("Please make a selection.");
		System.out.println("1. Create an account.\n2.Login.\n3.Exit.");
	}
	
	public void namePrompt() {
		System.out.println("Please enter your name: ");
	}
	
	public void passwordPrompt() {
		System.out.println("Please enter your password: ");
	}
	
	public void accountOptions() {
		System.out.println("Please make a selection");
		System.out.println("1.Deposit\n2.Withdrawal.\n3.Check Balance.\n4.Logout.");
	}
	
	public void depositDisplay() {
		System.out.println("How much would you like to deposit?");
	}
	public void withdrawalDisplay() {
		System.out.println("How much would you like to withdrawal?");
	}
	public void displayBalance(double balance) {
		
		System.out.print("Current balance is : $");
		System.out.printf("%.2f", balance);
		System.out.println();
	}
	
	public void logOutView() {
		System.out.println("You are now logged out");
	}
	
	
}
