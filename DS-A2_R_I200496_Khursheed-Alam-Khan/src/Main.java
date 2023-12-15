/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// Main Class

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner cin = new Scanner(System.in);
		Scanner in = new Scanner(System.in);	
		
		FileHandling fh = new FileHandling();
		int option;
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("|                    Welcome to Khursheed's Civilian database System                                        |");
		System.out.println("|                                                                                                           |");
		System.out.println("|                                        NOTE:                                                              |");
		System.out.println("|                                                                                                           |");
		System.out.println("|     * Keep the ORDER of the content of each of your test files same as the sample files                   |");
		System.out.println("|       which was given in the google classroom so that my program can read the files properly              |");
		System.out.println("|                                                                                                           |");
		System.out.println("|     * For Crimes information:                                                                             |");
		System.out.println("|       1) Crime: one word only for example; murder, robbery, smuggling etc.                                |");
		System.out.println("|       2) Charge: either one word or two words with a space for example; life, 2 years, 1 year etc.        |");
		System.out.println("|       3) Punishment: two words with a space for example; in jail, in prison, house arrest etc.            |");
		System.out.println("|       4) Fine: one word only for example; 20000, -, 10000 etc.                                            |");
		System.out.println("|                                                                                                           |");
		System.out.println("|     * Use the above information when adding new crime                                                     |");
		System.out.println("|     * Use the order of sample files to input information for other functionalites e.g. Numbers, CBID etc. |");
		System.out.println("|     * Use the following names to name the files:                                                          |");
		System.out.println("|       1) for Citizens Basic Information Database: CBID                                                    |");
		System.out.println("|       2) for Citizens Criminal Information Database: CCID                                                 |");
		System.out.println("|       3) for Citizens Cell Network Database: CCND                                                         |");
		System.out.println("|       4) for Alien Database: AD                                                                           |");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
		System.out.println("");
		System.out.println("Storing information from files to Databases! ");
		System.out.println();
		
		if(fh.cbf1.exists())
		{
			System.out.println("CBID FILE FOUND !!!");
			fh.storeCBID();
			fh.sortListCBID();
			System.out.println();
			System.out.println("CBID file information Stored !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println("NO CBID FILE FOUND !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		
		if(fh.ccf2.exists())
		{
			System.out.println("CCID FILE FOUND !!!");
			fh.storeCCID();
			fh.sortListCCID();
			System.out.println();
			System.out.println("CCID file information Stored !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println("NO CCID FILE FOUND !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		if(fh.adf4.exists())
		{
			System.out.println("AD (ALIEN DATA BASE) FILE FOUND !!!");
			fh.storeAD();
			fh.sortListAD();
			System.out.println();
			System.out.println("AD (Alien data base file) information Stored !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println("NO AD (ALIEN DATA BASE) FILE FOUND !!!");
			System.out.println("----------------------------------");
			System.out.println();
		}
		
		if(fh.cnf3.exists())
		{
			System.out.println("CCND FILE FOUND !!!");
			fh.storeCCND();
			fh.sortListCCND();
			fh.sortListCCNDSingle();
			
			System.out.println("CCND file information Stored !!!");
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("Successfully stored all information into relevant databases !!!");
			System.out.println();
		}
		
		else
		{
			System.out.println("NO CCND FILE FOUND !!!");
			System.out.println();
		}
		do
		{
			System.out.println("1. Go to CBID File ");
			System.out.println("2. Go to CCID File ");
			System.out.println("3. Go to CCND File ");
			System.out.println("4. Go to AD (Alien Data) File ");
			System.out.println("5. Quit");
			System.out.println();
			System.out.println("Select Option: ");
			option=cin.nextInt();
			switch(option)
			{
				case 1:
				{
					if(FileHandling.cbf1.exists())
					{
						while(option!=7)
						{
							System.out.println("1. Store file into data base (Only Use if no files are available to read and store upon the running of the program, otherwise ignore this function)");
							System.out.println("2. Read the file ");
							System.out.println("3. Display sorted data in database");
							System.out.println("4. Search by CNIC ");
							System.out.println("5. Update record ");
							System.out.println("6. Add new record");
							System.out.println("7. Return ");
							
							System.out.println();
							System.out.println("Select option: ");
							option=cin.nextInt();
							
							if(option==1)
							{
								// Store file
								fh.storeCBID();
								fh.sortListCBID();
							}
							else if(option==2)
							{
								// Read File
								fh.readCBID();
								System.out.println();
							}
							else if(option==3)
							{
								// Display
								fh.displayCBID();
								System.out.println();
							}
							else if(option==4)
							{
								// Search by CNIC
								System.out.println("Enter CNIC: ");
								int cnic = cin.nextInt();
								System.out.println();
								
								System.out.println("Showing CBID Information: ");
								fh.displayCnicCBID(cnic);
								System.out.println();
								
								System.out.println("Showing CCID Information: ");
								fh.displayCCIDByCnic(cnic);
								System.out.println();
								
								System.out.println("Showing CCND Information: ");
								fh.displayCCNDByCnic(cnic);
								System.out.println();
							}
							else if(option==5)
							{
								// Update record
								fh.updateCnicCBID();
								fh.updateCBIDFile();
								System.out.println();
							}
							else if(option==6)
							{
								// Add new record
								fh.addCBID();
								System.out.println("Added Record Successfully !!");
								System.out.println();
							}
							else if(option==7)
							{
								//return
							}
							
						}
					}
					else
					{
						System.out.println("File not found !!!");
					}
					break;
				}
				
				case 2:
				{
					if(FileHandling.ccf2.exists())
					{
						while(option!=8)
						{
							System.out.println("1. Store the file into data base (Only Use if no files are available to read and store upon the running of the program, otherwise ignore this function)");
							System.out.println("2. Read the file ");
							System.out.println("3. Display sorted data in database");
							System.out.println("4. Search by CNIC ");
							System.out.println("5. Update record crime ");
							System.out.println("6. Add new crime ");
							System.out.println("7. Delete crime ");
							System.out.println("8. Return ");
							System.out.println();
							System.out.println("Select option: ");
							option=cin.nextInt();
							
							if(option ==1)
							{
								fh.storeCCID();
								fh.sortListCCID();
							}
							else if(option==2)
							{
								// Read file
								fh.readCCID();
								System.out.println();
							}
							else if(option==3)
							{
								// Display file
								fh.displayCCID();
								System.out.println();
							}
							else if(option==4)
							{
								// Search by CNIC
								System.out.println("Enter CNIC: ");
								int cnic = cin.nextInt();
								cin.nextLine(); 
								System.out.println();
								
								System.out.println("Showing CCID Information: ");
								fh.displayCCIDByCnic(cnic);
								System.out.println();
								
								System.out.println("Showing CBID Information: ");
								fh.displayCnicCBID(cnic);
								System.out.println();
								
								System.out.println("Showing CCND Information: ");
								fh.displayCCNDByCnic(cnic);
								System.out.println();
							}
							else if(option==5)
							{
								System.out.println("Enter CNIC: ");
								int cnic = cin.nextInt();
								cin.nextLine(); 
								fh.updateCrime(cnic);
							}
							else if(option==6)
							{
								System.out.println("Enter CNIC: ");
								int cnic=cin.nextInt();
								cin.nextLine(); 
								fh.addCrime(cnic);
							}
							else if(option==7)
							{
								System.out.println("Enter CNIC: ");
								int cnic=cin.nextInt();
								cin.nextLine(); 
								fh.deleteCrime(cnic);
							}
							else if(option==8)
							{
								// return
							}
							
						}
					}
					else
					{
						System.out.println("File not found !!!");
					}
					break;
				}
				
				case 3:
				{
					if(FileHandling.cnf3.exists())
					{
						while(option!=9)
						{
							System.out.println("1. Store the file into data base (Only Use if no files are available to read and store upon the running of the program, otherwise ignore this function)");
							System.out.println("2. Read the file ");
							System.out.println("3. Display sorted data in database ");
							System.out.println("4. Search by CNIC ");
							System.out.println("5. Add cell number ");
							System.out.println("6. Swap ownership of two registered numbers ");
							System.out.println("7. Display all cell registered against a CNIC ");
							System.out.println("8. Display cell numbers registered on each network ");
							System.out.println("9. Return ");
							System.out.println();
							System.out.println("Select option: ");
							option=cin.nextInt();
							
							if(option==1)
							{
								// Store the file
								fh.storeCCND();
								fh.sortListCCND();
							}
							else if(option==2)
							{
								// Read file
								fh.readCCND();
								System.out.println();
							}
							else if(option==3)
							{
								// Display
								fh.displayCCND();
								System.out.println();
							}
							else if(option==4)
							{
								// Search by CNIC
								System.out.println("Enter CNIC: ");
								int cnic = cin.nextInt();
								cin.nextLine();
								System.out.println();
								
								System.out.println("Showing CCND Information: ");
								fh.displayCCNDByCnic(cnic);
								System.out.println();
								
								System.out.println("Showing CBID Information: ");
								fh.displayCnicCBID(cnic);
								System.out.println();
								
								System.out.println("Showing CCID Information: ");
								fh.displayCCIDByCnic(cnic);
								System.out.println();
							}
							else if(option==5)
							{
								// Adds Cell number
								System.out.println("Enter CNIC for which you want to add a new cell number: ");
								int cnic = in.nextInt();
								in.nextLine(); 
								fh.addCell(cnic);
								System.out.println();
							}
							
							else if(option==6)
							{
								// Swap ownership of two registered numbers
								System.out.println("Enter CNIC of first person: ");
								int cnic = in.nextInt();
								in.nextLine();
								System.out.println("Enter one of the numbers registered with the cnic "+cnic);
								String number = in.nextLine();
								
								System.out.println("Enter CNIC of second person: ");
								int cnic2 = in.nextInt();
								in.nextLine();
								System.out.println("Enter one of the numbers registered with the cnic "+cnic2);
								String number2 = in.nextLine();
								System.out.println();
								fh.swapCell(cnic, number, cnic2, number2);
								System.out.println();
							}
							
							else if(option==7)
							{
								// displays all cell registered against a CNIC
								System.out.println("Enter CNIC: ");
								int cnic = in.nextInt();
								in.nextLine(); 
								fh.displayCellByCnic(cnic);
								System.out.println();
							}
							
							else if(option==8)
							{
								// Displays total cell numbers registered against a network
								fh.displayCCNDNetworkCell();
								
							}
							else if(option==9)
							{
								//return
							}
						}
					}
					else
					{
						System.out.println("File not found !!!");
					}
					break;
				}
				
				case 4:
				{
					System.out.println("1. Read File ");
					System.out.println("2. Print Sorted Alien Data base Linked List ");
					System.out.println("3. Return");
					System.out.println();
					System.out.println("Select Option: ");
					option = cin.nextInt();
					
					if(option==1)
					{
						if(FileHandling.adf4.exists())
						fh.readAD();
						
						
						else
							System.out.println("No AD file found !!!");
						System.out.println();
					}
					else if(option == 2)
					{
						// displays alien database linked list
						fh.displayADInfo();
						System.out.println();
					}
					else
					{
						//return
					}
					break;
				}
				
				case 5:
				{
					//quit
					break;
				}
			}

		}while(option!=5);
		
		System.out.println();
		System.out.println("Thanks for using Khursheed Alam Khan's Citizen's Information Database System. Hope to see you again !!!");

	}
		

	
}