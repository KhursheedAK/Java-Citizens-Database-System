/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */


//Citizens Cell Network Database (CCND)

public class CCND
{
	private int cnic;
	private String number;
	private String network;
	private String aDate;
	private String dDate;
	private String status;
	
	CCND(int cnic, String number, String network, String aDate, String dDate, String status) 
	{
		this.cnic=cnic;
		this.number=number;
		this.network=network;
		this.aDate=aDate;
		this.dDate=dDate;
		this.status=status;
	
	}

	
	
	public String getNumber() 
	{
		return number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	
	public int getCnic() 
	{
		return cnic;
	}


	public void setCnic(int cnic) 
	{
		this.cnic = cnic;
	}
	
	
	public String getNetwork() 
	{
		return network;
	}

	public void setNetwork(String network) 
	{
		this.network = network;
	}

	public String getaDate() 
	{
		return aDate;
	}

	public void setaDate(String aDate) 
	{
		this.aDate = aDate;
	}

	public String getdDate() 
	{
		return dDate;
	}

	public void setdDate(String dDate) 
	{
		this.dDate = dDate;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	// circular list 
	public String toString()
	{
		return(this.getCnic()+" "+this.getNumber()+" "+this.getNetwork()+" "+this.getaDate()+" "+this.getdDate()+" "+this.getStatus());
	}
}
