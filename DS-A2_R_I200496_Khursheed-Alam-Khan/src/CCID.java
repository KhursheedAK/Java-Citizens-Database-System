/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */


//Citizens Basic Information Database (CBID)

public class CCID 
{
	private int cnic;
	private String crime;
	private String charge;
	private String punishment;
	private String fine;
	
	CCID(int cnic, String crime, String charge, String punishment, String fine) 
	{
		this.cnic=cnic;
		this.crime=crime;
		this.charge=charge;
		this.punishment=punishment;
		this.fine=fine;

	}

	public int getCnic() 
	{
		return cnic;
	}


	public void setCnic(int cnic) 
	{
		this.cnic = cnic;
	}

	public String getCrime() 
	{
		return crime;
	}


	public void setCrime(String crime) 
	{
		this.crime = crime;
	}


	public String getCharge() 
	{
		return charge;
	}


	public void setCharge(String charge) 
	{
		this.charge = charge;
	}


	public String getPunishment() 
	{
		return punishment;
	}


	public void setPunishment(String punishment) 
	{
		this.punishment = punishment;
	}


	public String getFine() 
	{
		return fine;
	}


	public void setFine(String fine) 
	{
		this.fine = fine;
	}

	// must be stored in circular List
	
	@Override 
	public String toString()
	{
		return(this.getCnic()+" "+this.getCrime()+" "+this.getCharge()+" "+this.getPunishment()+" "+this.getFine());
	}
	
}
