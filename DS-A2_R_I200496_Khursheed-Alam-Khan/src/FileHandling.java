/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */

// File Handling Class

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandling 
{
	Scanner in = new Scanner(System.in);
	
	public static File cbf1 = new File("CBID.txt");
	public static File ccf2 = new File("CCID.txt");
	public static File cnf3 = new File("CCND.txt");
	
	public static File adf4 = new File("AD.txt"); // alien file

	
	CBID cb = new CBID(0, null, null, null, 0, null, null);
	CCID cc = new CCID(0, null, null, null, null);
	CCND cn = new CCND(0, null, null, null, null, null);
	
	DoubleList <CBID> dl = new DoubleList<CBID>();
	
	
	SingleList<CCID> sl = new SingleList<CCID>();
	SingleList<CCND> sl2 = new SingleList<CCND>();
	SingleList<AD> sl3 = new SingleList<AD>();
	
	CircleList<CCID> cl = new CircleList<CCID>();
	CircleList<CCND> cl2 = new CircleList<CCND>();
	
	int index=0;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
																							// CBID File
	
	// for storing CBID into database
	public void storeCBID() throws IOException
	{
		try {
		// reading and storing
		Scanner s = new Scanner(cbf1);

		while(s.hasNextLine())
		{

			String data = s.nextLine();
			String[] info = data.split(" ");
			cb.setCnic(Integer.parseInt(info[0]));
			cb.setName(info[1]);
			cb.setfName(info[2]);
			cb.setGender(info[3]);
			cb.setAge(Integer.parseInt(info[4]));
			cb.setAddress(info[5]+' '+info[6]);
			cb.setNation(info[7]);
			
			if(cb.getNation().equalsIgnoreCase("Alien")) 
			{
				AD ad = new AD(cb.getCnic(), cb.getName(), cb.getfName(), cb.getGender(), cb.getAge(), cb.getAddress(), cb.getNation());
				sl3.insertStart(ad);
				sortListAD();
				updateADFile();
			}
			
			else
			{
				CBID newCb = new CBID(cb.getCnic(), cb.getName(), cb.getfName(), cb.getGender(), cb.getAge(), cb.getAddress(), cb.getNation());
				
				// Storing in Doubly Linked List
				dl.InsertNode(index, newCb);
				
				index++;
			}
		}

		s.close();
		// completed
	}catch(NullPointerException e)
		{
			System.out.println(e);
		}
}
	
	// read directly from CBID File
	public void readCBID() throws FileNotFoundException
	{
	try {	
		Scanner s = new Scanner (cbf1);
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			System.out.println(line);
		}
		s.close();
	 }catch(NullPointerException e)
	{
		 System.out.println(e);
	}
}
	
	// display CBID information from Data base
	public void displayCBID()
	{
		Node <CBID> cb = dl.head;
		while(cb != null)
		{
			System.out.println(cb.data);
			cb = cb.next;
		}
	}
	
	// Display CBID by CNIC in Data base
	public void displayCnicCBID(int cnic)
	{
		Node<CBID> cb = dl.head;
		while(cb != null)
		{
			if(cb.data.getCnic()==cnic)
			{
				System.out.println(cb.data.toString());
				break;
			}
			cb=cb.next;
		}
	}
	
	
	// Update CBID by CNIC in Data base
		public void updateCnicCBID() throws IOException
		{	
			System.out.println("Enter CNIC: ");
			int cnic = in.nextInt();
			in.nextLine();
			Node<CBID> cb = dl.head;
			while(cb != null)
			{
				if(cb.data.getCnic()==cnic)
				{
					cb.data.setCnic(cnic);
					System.out.println("Enter name: ");
					String name = in.nextLine();
					cb.data.setName(name);
					System.out.println("Enter Father Name: ");
					String fName = in.nextLine();
					cb.data.setfName(fName);
					System.out.println("Enter Address: ");
					String address = in.nextLine();
					cb.data.setAddress(address);
					System.out.println("Enter Nationality: ");
					String nation = in.nextLine();
					cb.data.setNation(nation);
					System.out.println();
					
					if(cb.data.getNation().equalsIgnoreCase("Alien"))
					{
						AD ad = new AD(cb.data.getCnic(), cb.data.getName(), cb.data.getfName(), cb.data.getGender(), cb.data.getAge(), cb.data.getAddress(), cb.data.getNation());
						sl3.insertStart(ad);
						sortListAD();
						updateADFile();
						
						dl.DeleteNode(cb.data.getCnic());
						sortListCBID();
						updateCBIDFile();
						
						System.out.println();
						System.out.println("Alien Nationality Removed from CBID database and sent to Alien Database !!!");
						System.out.println("View information on Alien file (AD file).");
						System.out.println();
					}
			
					System.out.println("Updated!");
					break;
				}
				else
				cb=cb.next;
			}
		}
	
	// update CBID File from Database
		
		public void updateCBIDFile() throws IOException
		{	
			FileWriter writer = new FileWriter(cbf1);
			
			BufferedWriter br = new BufferedWriter(writer);
			PrintWriter pr = new PrintWriter(br);
			
			Node<CBID> cb = dl.head;
			while(cb != null)
			{
				pr.println(cb.data);
				cb=cb.next;
			}
			pr.close();
			br.close();
			writer.close();
		}
	
	
	// sorting double list for CBID in Database
    public void sortListCBID() 
    {  
        Node <CBID> current = dl.head, index = null;  
        CBID temp;  
          
        if(current == null) 
        {  
            return;  
        }  
        else 
        {  
            while(current != null) 
            {    
                index = current.next;  
                  
                while(index != null) 
                {  
                    if(current.data.getCnic() > index.data.getCnic()) 
                    {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
    }  
    
    // Add new Record CBID into CBID data base
    public void addCBID() throws IOException
    {
    	System.out.println("Enter CNIC: ");
    	int cnic = in.nextInt();
    	in.nextLine();
		System.out.println("Enter name: ");
		String name = in.nextLine();
		System.out.println("Enter Father Name: ");
		String fName = in.nextLine();
		System.out.println("Enter Gender: ");
		String gender = in.nextLine();
		System.out.println("Eneter Age: ");
		int age = in.nextInt();
		in.nextLine();
		System.out.println("Enter Address: ");
		String address = in.nextLine();
		System.out.println("Enter Nationality: ");
		String nation = in.nextLine();
		
		if(nation.equalsIgnoreCase("Alien"))
		{
			AD ad = new AD(cnic, name, fName, gender, age, address, nation);
			sl3.insertStart(ad);
			sortListAD();
			updateADFile();
			System.out.println();
			System.out.println("Alien Nationality Stored in the Alien Database !!!");
			System.out.println("Check Alien File (AD file) to view.");
		}
		else 
		{
			CBID newCb = new CBID(cnic, name, fName, gender, age, address, nation);
			dl.InsertNode(0, newCb);
			sortListCBID();
			updateCBIDFile();
		}
		System.out.println();
    }
    
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
																						// CCID File
	
	public void storeCCID()throws FileNotFoundException
	{
		// storing CCID file in data base
		Scanner s = new Scanner(ccf2);

		while(s.hasNextLine())
		{
			String data = s.nextLine();
			String[] info = data.split(" ");
			cc.setCnic(Integer.parseInt(info[0]));
			cc.setCrime(info[1]);
			cc.setCharge(info[2]);
			cc.setPunishment(info[3]+' '+info[4]+' '+info[5]);
			
			if(info[5].endsWith("-"))
			cc.setFine("");
			
			else if(!(info[5].endsWith("-")))
				cc.setFine(info[5]);
			
			else
				cc.setFine(info[6]);
			
			CCID newCC = new CCID(cc.getCnic(), cc.getCrime(), cc.getCharge(), cc.getPunishment() , cc.getFine());
			// Storing in circular Linked List
			cl.InsertNode(newCC);
			
			//storing Crime in Singly Linked List
			sl.insertStart(newCC);
		}

		s.close();
		// completed
	}
	
		// reading directly from CCID file
		public void readCCID() throws FileNotFoundException
		{
			Scanner s = new Scanner (ccf2);
			while(s.hasNextLine())
			{
				String line = s.nextLine();
				System.out.println(line);
			}
			s.close();
		}
		
		// update CBID File from Database
		
		public void updateCCIDFile() throws IOException
		{	try {
			FileWriter writer = new FileWriter(ccf2);
			
			BufferedWriter br = new BufferedWriter(writer);
			PrintWriter pr = new PrintWriter(br);
			
			Node<CCID> cc = cl.head;
			do
			{
				pr.println(cc.data);
				cc=cc.next;
			}while(cc!=cl.head);
			
			pr.close();
			br.close();
			writer.close();
		}catch(NullPointerException e)
		{
			System.out.println("File is Empty !!");
		}
	}
	
		// Sort CCID list
		public void sortListCCID() 
		{  
			Node<CCID> current = cl.head, index = null;  
			CCID temp;  
			if(cl.head == null) 
			{  
			System.out.println("List is empty");  
			}  
			else 
			{  
			do
			  {   
				index = current.next;  
				while(index != cl.head)
				{  
					if(current.data.getCnic() > index.data.getCnic()) 
					{  
					temp =current.data;  
					current.data= index.data;  
					index.data = temp;  
					}  
					index= index.next;  
				}  
				current =current.next;  
			  }while(current.next != cl.head);   
			}  
		}  
		
		 //Displays all CCID nodes in the list  
	    public void displayCCID() 
	    {  
	        Node current = cl.head;  
	        if(cl.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	             do
	             {  
	                System.out.println(current.data);  
	                current = current.next;  
	            }while(current != cl.head);  
	            System.out.println();  
	        }  
	    }  
	    
	  //Displays respective CNIC in the database  
	    public boolean displayCCIDByCnic(int cnic) 
	    {  
	        Node <CCID> current = cl.head;
	        boolean flag = false;
	        if(cl.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	        	do
	        	{
	            	if(current.data.getCnic()==cnic)
	            	{
	            		System.out.println(current.data);
	            		flag=true;
	            	}
	            	
	                current = current.next; 
	        	}while(current!=cl.head);
	        }
	        
	        return flag;
	    } 
	    
	    
	    
	    // Update crime list of CCID
	    public void updateCrime(int cnic) throws IOException
	    {
	    	Node<CCID> current = cl.head;
	   
	    	while(current!=null)
	    	{
		    		if(current.data.getCnic()==cnic)
		    		{
		    			System.out.println("Enter detail of Crime: ");
		    			String crime = in.nextLine();

		    			System.out.println("Enter charge: ");
		    			String charge = in.nextLine();

		    			System.out.println("Enter Punishment: ");
		    			String punishment = in.nextLine();

		    			System.out.println("Enter fine: ");
		    			String fine = in.nextLine();

		    			CCID cc = new CCID(cnic, crime, charge, punishment, fine);
		    			
		    			sl.insertStart(cc);
		    			cl.InsertNode(cc);
		    			updateCCIDFile();
		    			sortListCCID();
		    			sortListCCIDSingle();
		    			break;
		    			
		    		}
		    		else
		    		{
		    			current=current.next;
		    		}
			
	    	}
	   }
	    // Add crime list of CCID to a CNIC not in crime
	    public void addCrime(int cnic) throws IOException
	    {
	    	try {
	    	Node<CBID> current = dl.head;
	    	boolean flag = false;
	    	
	    	while(current!=null)
	    	{
	    		if(current.data.getCnic()==cnic)
	    		{
	    			System.out.println("Enter detail of Crime: ");
	    			String crime = in.nextLine();
	    			System.out.println("Enter charge: ");
	    			String charge = in.nextLine();
	    			System.out.println("Enter Punishment: ");
	    			String punishment = in.nextLine();
	    			System.out.println("Enter fine: ");
	    			String fine = in.nextLine();
	    			
	    			CCID newCC = new CCID(cnic, crime, charge, punishment, fine);
	    			
	    			cl.InsertNode(newCC);
	    			sl.insertStart(newCC);
	    			sortListCCID();
	    			updateCCIDFile();
	    			sortListCCIDSingle();
	    			
	    			flag=true;
	    			break;
	    		}
	    		else
	    		{
	    			current=current.next;
	    			flag=false;
	    		}
	    		
	    	}
	    	
	    	if(flag == false)
	    	{
	    		System.out.println(cnic+" CNIC NOT FOUND !!!");
	    	}
	    	
	    		
	    }catch(NullPointerException e)
	    	{
	    	  System.out.println("Empty File !!!");
	    	}
	  }
	    
	    // Delete Crime 
	    public void deleteCrime(int cnic) throws IOException
	    {
	    	try {
	    		
	    	Node<CCID> current = cl.head;
	    	boolean flag = displayCCIDViaCnic(cnic);
	    	System.out.println("");
	    	
	    	if(flag == false)
	    	{
	    		System.out.println(cnic+" CNIC DOES NOT EXIST !!!");
	    		System.out.println();
	    		return;
	    	}
	    	else
	    	{
	    		System.out.println("Enter the index as shown above to delete the node: ");
	    		int index = in.nextInt();
	    		cl.deleteAny(index);
		    	
		    	updateCCIDFile();
		    	sortListCCID();
		    	sortListCCIDSingle();
		    	
		    	System.out.println("Deleted Successfully!!!");
		    	
		    	System.out.println();
	    	}
	    }catch(NullPointerException e)
	    	{
	    		System.out.println("");
	    	}
	  }
	    
	 // sorts singly linked list for CCID
	    @SuppressWarnings("unchecked")
		public void sortListCCIDSingle() 
		{   
			Node<CCID> current = sl.head, index = null;  
			CCID temp;  
			if(sl.head == null) 
			{  
				System.out.println("List is empty");  
			}  
			else 
			{    
				index = current.next;
				while(index != null)
				{  
					if(current.data.getCnic() > index.data.getCnic()) 
					{  
						temp =current.data;  
						current.data= index.data;  
						index.data = temp;  
					}  
					index= index.next;  
				}  
				current =current.next;  
			}  
		} 
	    
	    
	    
	  //Displays respective CNIC in the database  
	    public boolean displayCCIDViaCnic(int cnic) 
	    {  
	        Node <CCID> current = cl.head;
	        int index = 1;
	        boolean flag = false;
	        if(cl.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	        	do
	        	{
	            	if(current.data.getCnic()==cnic)
	            	{
	            		System.out.println(current.data+" | at index "+index);
	            		flag=true;
	            	}
	            	
	                current = current.next; 
	                index++;
	        	}while(current!=cl.head);
	        }
	        
	        return flag;
	    } 
	    
	    
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
																							// CCND File	
	
	public void storeCCND()throws FileNotFoundException
	{
		// reading and storing
		Scanner s = new Scanner(cnf3);

		while(s.hasNextLine())
		{
			String data = s.nextLine();
			String[] info = data.split(" ");
			cn.setCnic(Integer.parseInt(info[0]));
			cn.setNumber(info[1]);
			cn.setNetwork(info[2]);
			cn.setaDate(info[3]);
			cn.setdDate(info[4]);
			cn.setStatus(info[5]);
			
			CCND newCN = new CCND(cn.getCnic(), cn.getNumber(), cn.getNetwork(), cn.getaDate() , cn.getdDate(), cn.getStatus());
			// Storing in circular Linked List
			cl2.InsertNode(newCN);
			
			//storing number in Singly Linked List
			sl2.insertStart(newCN);
		}

		s.close();
		// completed
		System.out.println();
	}
	
		// reading directly from CCND file
		public void readCCND() throws FileNotFoundException
		{
			Scanner s = new Scanner (cnf3);
			while(s.hasNextLine())
			{
				String line = s.nextLine();
				System.out.println(line);
			}
			s.close();
		}
		
		// sorting function for CCND  
		@SuppressWarnings("unchecked")
		public void sortListCCND() 
		{  
			Node<CCND> current = cl2.head, index = null;  
			CCND temp;  
			if(cl2.head == null) 
			{  
			System.out.println("List is empty");  
			}  
			else 
			{  
			do
			  {  
				index = current.next;  
				while(index != cl2.head)
				{  
					if(current.data.getCnic() > index.data.getCnic()) 
					{  
					temp =current.data;  
					current.data= index.data;  
					index.data = temp;  
					}  
					index= index.next;  
				}  
				current =current.next;  
			  }while(current.next != cl2.head);   
			}  
		} 
		
		
		//Displays the entire information 
	    @SuppressWarnings("unchecked")
		public void displayCCND() 
	    {  
	        Node <CCND> current = cl2.head;  
	        if(cl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	             do
	             {  
	                System.out.println(current.data);  
	                current = current.next;  
	            }while(current != cl2.head);  
	            System.out.println();  
	        }  
	    }  
	    
	  //Displays a specific node in the list via CNIC  
	    @SuppressWarnings("unchecked")
		public void displayCCNDByCnic(int cnic) 
	    {  
	        Node <CCND> current = sl2.head;  
	        if(sl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	            while(current!=null)
	            {
	            	if(current.data.getCnic()==cnic)
	            	{
	            		System.out.println(current.data);
	            	}
	           
	                current = current.next;  
	            }
	            System.out.println();  
	        }  
	    }  
	    
	    
	    // Add cell number
	    @SuppressWarnings("unchecked")
		public void addCell(int cnic) throws IOException
	    {
	    	Node <CCND> current = sl2.head;  
	        if(sl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	            while(current!=null)
	            {
	            	
	            	if(current.data.getCnic()==cnic)
	            	{
	            		
	            		boolean flag = checkCellCnic(cnic);
	            		
	            		if(flag == true)
	            		{	System.out.println();
	            			displayCCNDCell();
	            			System.out.println();
	            			System.out.println("Above list are cell numbers already in use!!!");
		            		System.out.println("Enter new cell number: ");
		            		String number = in.nextLine();
		            		
		            		boolean unique = checkCellNew(number);
		            		
		            		if(unique == false)
		            		{
		            			
		    		    			System.out.println(number+" CELL NUMBER ALREADY IN USE !!!");
		            				System.out.println("Pick a new number: ");
		            				number = in.nextLine();
		            				unique = checkCellNew(number);
		            				if(unique == true)
		            				{
		            					System.out.println(number+" is available to use!!!");
		            				}
		            				else
		            				{
		            					System.out.println(number+" cell number is already in use");
		            					System.out.println("System returning!!!");
		            					return;
		            				}
		            				
		            				System.out.println();
		            		
		            		}
		            	
			            		System.out.println("Enter name of network: ");
			            		String network = in.nextLine();
			            		System.out.println("Enter activation date: ");
			            		String aDate = in.nextLine();
			            		System.out.println("Enter deactiavion date: ");
			            		String dDate = in.nextLine();
			            		System.out.println("Enter status: ");
			            		String status = in.nextLine();
			            		
			            		CCND cn = new CCND (current.data.getCnic(), number, network, aDate, dDate, status );
			            		sl2.insertStart(cn);
			            		cl2.InsertNode(cn);
			            		updateCCNDFile();
			            		sortListCCNDSingle();
			            		sortListCCND();
			            		break;
	            		}
	            		
	            		else
	            			return;
	            	}
	            	else
	                current = current.next;
	            }
	            System.out.println();  
	        }  
	    }
	    
	    // display all cell numbers registered against a CNIC
	    @SuppressWarnings("unchecked")
		public void displayCellByCnic(int cnic)
	    {
	    	Node <CCND> current = sl2.head;  
	        if(sl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {  
	        	while(current!=null)
	        	{
	        		if(current.data.getCnic()==cnic)
	            	{
	            		System.out.println(current.data);
	            	}
	            	current = current.next;
	        	} 
	        }  
            System.out.println();
	    }
	    
	    
	    // checking if CNIC has more than 4 numbers registered
	    @SuppressWarnings("unchecked")
		public boolean checkCellCnic(int cnic)
	    {
	    	Node <CCND> current = sl2.head;
	    	boolean flag=false;
	    	int count = 1;
	        if(sl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {  
	        	while(current!=null)
	        	{
		            if(current.data.getCnic()==cnic)
		            {
		            	System.out.println(current.data);
		            	count++;
		            }
		            
		           current = current.next;
	        	}
	        	
	        	 if(count<=4)
		            {
		            	flag = true;
		            	return flag;
		            }
		            
		            else if(count>4)
		            {
		            	System.out.println("No more cell numbers can be registered on this CNIC");
		            	flag=false;
		            }
		             
	        	System.out.println(); 
	        }
	        return flag;
	    }
	    
	    
	  //Displays all the Phones registered so far  
	    @SuppressWarnings("unchecked")
		public void displayCCNDCell() 
	    {  
	        Node <CCND> current = sl2.head;  
	        if(sl2.head == null) 
	        {  
	            System.out.println("List is empty");  
	        }  
	        else 
	        {   
	        	while(current!=null)
	        	{
	        		System.out.println(current.data.getNumber());
	        		current = current.next;
	        	} 
	        } 
	        System.out.println();
	    }  
	    
	    // check if cell number is new or not
	    @SuppressWarnings("unchecked")
		public boolean checkCellNew(String number)
	    {
	    	Node <CCND> cn = sl2.head;
	    	boolean unique = true;
	    	
	    	if(cn==null)
	    	{
	    		System.out.println("List is empty!!!");
	    	}
	    	
	    	else
	    	{
	    		while(cn!=null)
	    		{
		    		if(cn.data.getNumber().equals(number))
		    		{
		    			unique = false;
		    			return unique;
		    		}
		    		else
		    		cn = cn.next;
	    		}
	    	}
	    	System.out.println();
	    	return unique;
	    }
	    
	    // sorts singly linked list for CCND
	    @SuppressWarnings("unchecked")
		public void sortListCCNDSingle() 
		{   
			Node<CCND> current = sl2.head, index = null;  
			CCND temp;  
			if(sl2.head == null) 
			{  
				System.out.println("List is empty");  
			}  
			else 
			{    
				index = current.next;
				while(index != null)
				{  
					if(current.data.getCnic() > index.data.getCnic()) 
					{  
						temp =current.data;  
						current.data= index.data;  
						index.data = temp;  
					}  
					index= index.next;  
				}  
				current =current.next;  
			}  
		} 
	    
	    
	    // update CCND Numbers File from data base
		
	 		public void updateCCNDFile() throws IOException
	 		{	try {
	 			FileWriter writer = new FileWriter(cnf3);
	 			
	 			BufferedWriter br = new BufferedWriter(writer);
	 			PrintWriter pr = new PrintWriter(br);
	 			
	 			Node<CCND> cn = sl2.head;
	 			while(cn!=null)
	 			{
	 				pr.println(cn.data);
	 				cn=cn.next;
	 			}
	 			pr.close();
	 			br.close();
	 			writer.close();
	 		}catch(NullPointerException e)
	 		{
	 			System.out.println("File is Empty !!");
	 		}
	 	}
	 		
	 	// swap numbers between two citizens via CNIC
	 		public void swapCell(int cnic, String number,  int cnic2, String number2) throws IOException
	 		{
	 			Node<CCND> current = sl2.head;
	 			CCND temp = null;
	 			CCND temp2 = null;
	 			boolean flag = false;
	 			boolean flag2 = false;
	 			
	 			if(sl2.head==null)
	 			{
	 				System.out.println("List is empty!!!");
	 			}
	 			else
	 			{	
	 				while(current!=null)
	 				{
	 					if(current.data.getCnic()==cnic && current.data.getNumber().equals(number))
	 					{
	 						temp=current.data;
	 						flag = true;
	 					}
	 					if(current.data.getCnic()==cnic2 && current.data.getNumber().equals(number2))
	 					{
	 						temp2=current.data;
	 						flag2=true;
	 					}
	 					current=current.next;
	 				}
	 				if(flag==true && flag2 == true)
	 				{
	 					temp.setNumber(number2);
	 					temp2.setNumber(number);
	 					
	 					updateCCNDFile();
	 					sortListCCNDSingle();
	 					sortListCCND();
	 					
	 					System.out.println("Successfully Swaped the cell numbers.");
	 				}
	 				else if(flag==false || flag2 == false)
	 				{
	 					System.out.println("Invalid CELL NUMBER OR CNIC !!!");
	 				}
	 				
	 			}
	 			
	 		}
	 		
	 		// display total number of cell numbers in each network
	 		public void displayCCNDNetworkCell()
	 		{
	 			@SuppressWarnings("unchecked")
				Node<CCND> current = sl2.head;
	 			int Vodafone = 0;
	 			int EE = 0;
	 			int Skymobile = 0;
	 			int BTmobile = 0;
	 			int O2 = 0;
	 			int Telenor = 0;
	 			int Warid = 0;
	 			int Zong = 0;
	 			int Jazz = 0;
	 			int Ufone = 0;
	 			
	 			int total = 0;
	 			
	 			if(current==null)
	 			{
	 				System.out.println("List is Empty!!!");
	 			}
	 			else
	 			{
	 				while(current!=null)
	 				{
	 					if(current.data.getNetwork().equalsIgnoreCase("Vodafone"))
	 					{
	 						Vodafone++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("EE"))
	 					{
	 						EE++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Skymobile"))
	 					{
	 						Skymobile++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("BTmobile"))
	 					{
	 						BTmobile++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("O2"))
	 					{
	 						O2++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Telenor"))
	 					{
	 						Telenor++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Warid"))
	 					{
	 						Warid++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Zong"))
	 					{
	 						Zong++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Jazz"))
	 					{
	 						Jazz++;
	 					}
	 					
	 					if(current.data.getNetwork().equalsIgnoreCase("Ufone"))
	 					{
	 						Ufone++;
	 					}
	 					
	 					current=current.next;
	 					
	 				}
	 				
	 				total = Vodafone + EE + Skymobile + BTmobile + O2 + Telenor + Warid + Zong + Jazz + Ufone;
	 			}
	 			
	 			System.out.println("Vodafone= "+Vodafone);
	 			System.out.println("EE= "+EE);
	 			System.out.println("Skymobile= "+Skymobile);
	 			System.out.println("BTmobile= "+BTmobile);
	 			System.out.println("O2= "+O2);
	 			System.out.println("Telenor= "+Telenor);
	 			System.out.println("Jazz= "+Jazz);
	 			System.out.println("Ufone= "+Ufone);
	 			System.out.println("Zong= "+Zong);
	 			System.out.println("Warid= "+Warid);
	 			System.out.println("-----------");
	 			System.out.println("Total= "+total);
	 			System.out.println();
	 			
	 		}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	    																		//for Alien Database
	    
    // sorting double list for AD in Database
    public void sortListAD() 
    {  
        Node <AD> current = sl3.head, index = null;  
        AD temp;  
          
        if(current == null) 
        {  
            return;  
        }  
        else 
        {  
            while(current != null) 
            {   
                index = current.next;  
                  
                while(index != null) 
                {   
                    if(current.data.getCnic() > index.data.getCnic()) 
                    {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
    }  
    
	 
    // update AD File from Database
	public void updateADFile() throws IOException
	{	
		FileWriter writer = new FileWriter(adf4);
		
		BufferedWriter br = new BufferedWriter(writer);
		PrintWriter pr = new PrintWriter(br);
		
		Node<AD> ad = sl3.head;
		while(ad != null)
		{
			pr.println(ad.data);
			ad=ad.next;
		}
		pr.close();
		br.close();
		writer.close();
	}
	
	// read directly from AD File
	public void readAD() throws FileNotFoundException
	{
		Scanner s = new Scanner (adf4);
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			System.out.println(line);
		}
		s.close();
	}
	
	// display alien data base linked list
	public void displayADInfo() 
    {  
        Node <AD> current = sl3.head;  
        if(sl3.head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else 
        {   
        	while(current!=null)
        	{
        		System.out.println(current.data);
        		current = current.next;
        	} 
        } 
        System.out.println();
    }
	
	
	// for storing AD into database
		public void storeAD() throws IOException
		{
			try {
			// reading and storing
			Scanner s = new Scanner(adf4);

			while(s.hasNextLine())
			{

				String data = s.nextLine();
				String[] info = data.split(" ");
				cb.setCnic(Integer.parseInt(info[0]));
				cb.setName(info[1]);
				cb.setfName(info[2]);
				cb.setGender(info[3]);
				cb.setAge(Integer.parseInt(info[4]));
				cb.setAddress(info[5]+' '+info[6]);
				cb.setNation(info[7]);
				
				AD ad = new AD(cb.getCnic(), cb.getName(), cb.getfName(), cb.getGender(), cb.getAge(), cb.getAddress(), cb.getNation());
				sl3.insertStart(ad);
				sortListAD();
				updateADFile();
			}	
			s.close();
			// completed
		}catch(NullPointerException e)
			{
				System.out.println(e);
			}
	}
	
}
