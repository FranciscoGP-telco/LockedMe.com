package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	//Function with the welcome message
	public static void showWelcome() {
		System.out.println("--------------------");
		System.out.println("    LockedMe.com    ");
		System.out.println("--------------------");
		System.out.println("Application developed:\n"
				+ "    by Francisco García (franciscogarciapozo@gmail.com");
		System.out.println("--------------------");
	}
	
	//Function with the messages from the main menu
	public static void showMainMenu() {
		System.out.println("With this application you can work with the files in the folder X");
		System.out.println("Choose one of the following opions:");
		System.out.println("1. List the files in the folder");
		System.out.println("2. Operate with files in the folder ");
		System.out.println("3. Close the application");
		System.out.println("Insert you option: ");
	}
	
	//Function with the messages from the file submenu
	public static void showFilesSubmenu() {
		System.out.println("What operation do you want to do with the files in the folder?:");
		System.out.println("Choose one of the following opions:");
		System.out.println("1. Create a new file in the folder");
		System.out.println("2. Delete a file from the folder");
		System.out.println("3. Search for a file in the folder");
		System.out.println("4. Back to the previous menu");
		System.out.println("Insert you option: ");
	}
	
	//Function with the logic of the main menu
	public static void navigationMainMenu() { 
		//infinite loop. We don't leave the application until the user insert 3
		while(true) {
			showMainMenu();
			int optionSelected = optionSelection();
			//While the user doesn't insert a correct option, the loop continues
			while (optionSelected <= 0 || optionSelected > 3) {
				System.out.println("Introduce a number between 1 and 3. ");
				optionSelected = optionSelection();
			}
			//Depends of the option selected, the different functions are called, of the application is closed with the case 3
			switch (optionSelected) {
			case 1:
				FilesOptions.listFilesInFolder();
				break;
			case 2:
				navigationFilesMenu();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}
	
	
	public static void navigationFilesMenu() {
		//infinite loop. We don't leave the application untin the user insert 4
		while(true) {
			showFilesSubmenu();
			int optionSelected = optionSelection();
			//While the user doesn't insert a correct option, the loop continues
			while (optionSelected <= 0 || optionSelected > 4) {
				System.out.println("Incorrect option: You need to introduce a number between 1 and 4");
				optionSelected = optionSelection();
			}
			//Depends of the option selected, the different functions are called
			switch (optionSelected) {
			case 1:
				FilesOptions.createFile();
				break;
			case 2:
				FilesOptions.deleteFile();
				break;
			case 3:
				FilesOptions.searchFile();
				break;
			case 4:
				navigationMainMenu();
				break;
			}
		}
	}
	
	//Function to read the option from the user. A exception for another type of input is caught
	public static int optionSelection() {
		int optionSelected = 0;
		Scanner sc = new Scanner(System.in);
		try {
			optionSelected = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("You MUST introduce a number. ");
		}
		return optionSelected;
	}
}
	
