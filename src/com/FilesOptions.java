package com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FilesOptions {
	//Constant with the name of the working directory
	static final String WORK_DIRECTORY = "working directory";
	
	//Function to list all the files in the working directory
	public static void listFilesInFolder() {
		//A File object with the working directory is created
		File fi = new File(WORK_DIRECTORY);
		//With the function list(), we create a String array with all the files in the folder
		String[] arrayFilesName = fi.list();
		//If the array is empty (length 0), a message to the user explaining the situation is showed
		if(arrayFilesName.length == 0) {
			System.out.println("-------------------------------");
			System.out.println("The directory is empty");
		} else {
			//The array is sorted with sort(array), and a for loop is used to show all the results in the array
			Arrays.sort(arrayFilesName);
			System.out.println("Files in the working directory:");
			System.out.println("-------------------------------");
			for (String fileName: arrayFilesName) {
				System.out.println(fileName);
			}
		}
		System.out.println("-------------------------------");
	}
	
	//Function to create a file in the working directory
	public static void createFile() {
		Scanner sc = new Scanner(System.in);
		String fileName;
		
		System.out.println("Insert the name of the file to create:");
		fileName = sc.next();
		//A File object with the file name is created
		File fi = new File(WORK_DIRECTORY + "\\" + fileName);
		//With File.exists() the existence of the file is checked. If the file already exists, a message is showed to the user
		if(fi.exists()) {
			System.out.printf("The file %s can't be created because a file with this name exists in the working directory\n", fileName);
		}
		try {
			//Trying to create the file. Also a IOExcepcion is caught
			if(fi.createNewFile()) {
				System.out.printf("File %s created correctly\n", fileName);
			} else {
				System.out.printf("The file %s can't be created\n", fileName);
			}
		} catch (IOException e) {
			System.out.println("Error IO creating the file: " + e.toString());
		}
	}
	
	//Function to check if a file exists in the working direcotry
	public static void searchFile() {
		Scanner sc = new Scanner(System.in);
		String fileName;
		
		System.out.println("Insert the text of the file to find:");
		fileName = sc.next();
		//A File object with the file name is created
		File fi = new File(WORK_DIRECTORY + "\\" + fileName);
		//With File.exists() the existence of the file is checked.
		if(fi.exists()) {
			System.out.printf("The file %s exists in the working directory\n", fileName);
		} else {
			System.out.printf("The file %s doesn't exist in the working directory\n", fileName);
		}
	}
	
	//Function to delete a file from the working directory
	public static void deleteFile() {
		Scanner sc = new Scanner(System.in);
		String fileName;
		System.out.println("Insert the name of the file to delete:");
		fileName = sc.next();
		//A File object with the file name is created
		File fi = new File(WORK_DIRECTORY + "\\" + fileName);
		//With File.exists() the existence of the file is checked. If the file already exists, a message is showed to the user
		if(fi.exists()) {		
			if(fi.delete()) {
				System.out.printf("File %s deleted correctly\n", fileName);
			} else {
				System.out.printf("The file %s can't be deleted\n", fileName);
			}
		} else {
			System.out.printf("The file %s doesn't exists\n", fileName);
		}
	}
}
